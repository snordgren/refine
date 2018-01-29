package org.domino

import org.scalajs.dom.{document, raw}

import scala.scalajs.js

object Domino {
  def render(src: html.Element[_], dest: raw.Element): Either[String, Unit] = {
    if (dest.childNodes.length < 1) {
      val newChild = createElement(src)
      dest.appendChild(newChild)
      merge(src, newChild)
    } else {
      merge(src, dest.firstChild)
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

      case Id(value) =>
        target.setAttribute("id", s"#$value")

      case c: html.SimpleAttribute[_] =>
        target.setAttribute(c.name, c.value.toString)

      case e: html.EventAttribute[_] =>
        val dynamicTarget = target.asInstanceOf[js.Dynamic]
        if (js.isUndefined(dynamicTarget.handler)) {
          dynamicTarget.handler = js.Dynamic.literal()
        }

        if (js.isUndefined(dynamicTarget.handler.selectDynamic(e.name))) {
          target.addEventListener(e.name, (event: raw.Event) => {
            val handler = dynamicTarget.handler.selectDynamic(e.name)
            handler.apply(event)
          })
        }

        dynamicTarget.handler.updateDynamic(e.name)(e.f)
    }

    if (target.hasAttributes() && target.attributes.length > source.attributes.length) {
      (0 until target.attributes.length).flatMap((index) => {
        val attribute = target.attributes.item(index)
        val name = attribute.name
        if (!source.nonErasedAttr.exists((attr) => attr.name.equalsIgnoreCase(name))) {
          Some(name)
        } else None
      }).foreach((name) => {
        target.attributes.removeNamedItem(name)
      })
    }
  }
  private def merge(src: html.Node, dest: raw.Node): Either[String, Unit] = {
    if (dest == null) return Left("The target node was null.")
    if (js.isUndefined(dest)) return Left("The target node was undefined.")

    def recreate(newChild: raw.Node): Either[String, Unit] = {
      dest.parentNode.replaceChild(newChild, dest)
      merge(src, newChild)
    }

    src match {
      case element: html.Element[_] =>
        dest match {
          case dest: raw.HTMLElement =>
            if (dest.nodeName.equalsIgnoreCase(element.name)) {
              updateElement(element, dest)
              if (dest.childNodes.length > element.children.length) {
                val start = element.children.length
                (start until dest.childNodes.length).map(dest.childNodes(_)).foreach(child => {
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
                merge(child, target)
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
}
