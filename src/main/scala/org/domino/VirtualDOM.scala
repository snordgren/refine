package org.domino

import org.scalajs.dom.{document, raw}

object VirtualDOM {
  def render(src: html.Node, dest: raw.Element): Unit =
    src match {
      case element: html.Element[_] =>
        dest match {
          case dest: raw.HTMLElement =>
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

          case _ =>
            val newChild = createElement(element)
            document.replaceChild(newChild, dest)
            render(src, newChild)
        }

      case html.Text(text) =>
        dest.outerHTML = text
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
    }


  }
}
