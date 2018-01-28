package org.domino

import org.scalajs.dom.{document, raw}

import scala.scalajs.js

object VirtualDOM {
  def render(src: html.Node, dest: raw.Node): Either[String, Unit] = {
    if (dest == null) return Left("The target node was null.")
    if (js.isUndefined(dest)) return Left("The target node was undefined.")
  
    def recreate(newChild: raw.Node): Either[String, Unit] = {
      dest.parentNode.replaceChild(newChild, dest)
      render(src, newChild)
    }
    
    src match {
      case element: html.Element[_] =>
        dest match {
          case dest: raw.HTMLElement =>
            if (dest.nodeName.equalsIgnoreCase(element.name)) {
              updateElement(element, dest)
              if (dest.childNodes.length > element.children.length) {
                val start = element.children.length
                (start until dest.childNodes.length).map(dest.childNodes(_)) foreach (child => {
                  child.parentNode.removeChild(child)
                })
              }
              element.children.zipWithIndex.foreach { case (child, index) =>
                if (dest.childNodes.length <= index) {
                  val newChild = child match {
                    case e: html.Element[_] => createElement(e)
                    case html.Text(text) => document.createTextNode(text)
                  }
                  dest.appendChild(newChild)
                }
                val target = dest.childNodes(index)
                render(child, target)
              }
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
  
    if (target.hasAttributes() && target.attributes.length > source.attributes.length) {
      (0 until target.attributes.length).flatMap((index) => {
        val attribute = target.attributes.item(index)
        if (attribute != null) {
          val name = attribute.name
          if (!source.nonErasedAttr.exists((attr) => attr.name.equalsIgnoreCase(name))) {
            Some(name)
          } else None
        } else None
      }).foreach((name) => {
        target.attributes.removeNamedItem(name)
      })
    }
  }
}
