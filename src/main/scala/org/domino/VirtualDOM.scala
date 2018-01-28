package org.domino

import org.scalajs.dom.{document, raw}

object VirtualDOM {
  def render(src: html.Node, dest: raw.Node): Either[String, Unit] = {
    if (dest == null) return Left("The target node was null.")
    
    def recreate(newChild: raw.Node) = {
      dest.parentNode.replaceChild(newChild, dest)
      render(src, newChild)
    }
    
    src match {
      case element: html.Element[_] =>
        dest match {
          case dest: raw.HTMLElement =>
            if (dest.nodeName.equalsIgnoreCase(element.name)) {
              updateElement(element, dest)
              println(dest.childElementCount + ", " + element.children.length)
              element.children.zipWithIndex.map((n) => {
                val (node, index) = n
                if (dest.childElementCount <= index) {
                  val newChild = node match {
                    case childEl: html.Element[_] => createElement(childEl)
                    case text: html.Text => document.createTextNode(text.value)
                  }
                  dest.appendChild(newChild)
                }
                (node, dest.children.item(index))
              }).foreach(n => {
                val (childSrc, childDest) = n
                render(childSrc, childDest)
              })
    
              Right()
    
            } else recreate(createElement(element))

          case _ => recreate(createElement(element))
        }

      case html.Text(text) =>
        dest match {
          case textNode: raw.Text =>
            if (!textNode.nodeValue.equals(text)) {
              textNode.textContent = text
            }
            Right()
          
          case _ =>
            dest.parentNode.removeChild(dest)
            recreate(document.createTextNode(text))
        }
    }
  }
  
  private def createElement(element: html.Element[_]): raw.HTMLElement =
    document.createElement(element.name).asInstanceOf[raw.HTMLElement]
  
  private def updateElement(source: html.Element[_], target: raw.HTMLElement): Unit = {
    import org.domino.html.Attribute._
    
    source.attributes.foreach {
      case CustomData(name, value) =>
        val attrId = s"data-$name"
        target.setAttribute(attrId, value)

      case c: html.SimpleAttribute[_] =>
        target.setAttribute(c.name, c.value.toString)

      case e: html.EventAttribute[_] =>
        target.addEventListener(e.name, e.f)
    }
    
    if (target.attributes.length > source.attributes.length) {
      (0 to target.attributes.length).flatMap((index) => {
        val attribute = target.attributes(index)
        val name = attribute.name
        if (!source.nonErasedAttr.exists((attr) => attr.name.equalsIgnoreCase(name))) {
          Some(name)
        } else None
      }).foreach((name) => {
        target.attributes.removeNamedItem(name)
      })
    }
  }
}
