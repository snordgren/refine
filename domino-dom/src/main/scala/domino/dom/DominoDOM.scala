package domino.dom

import domino.Attribute.{CustomData, Id}
import domino.{Component, Element, EventAttribute, Node, SimpleAttribute, Text}
import org.scalajs.dom.{document, raw}

import scala.scalajs.js

object DominoDOM {
  def render(src: Element[_], dest: raw.Element): Either[String, Unit] = {
    if (dest.childNodes.length < 1) {
      val newChild = createElement(src)
      dest.appendChild(newChild)
    }

    patch(src, dest.firstChild)
  }

  def render(comp: Component, dest: raw.Element): Either[String, Unit] = {
    val rendered = comp.render
    rendered match {
      case e: Element[_] =>
        render(e, dest)

      case _ =>
        if (dest.childElementCount < 1) {
          dest.appendChild(createChild(rendered))
        }

        patch(rendered, dest.firstChild)
    }
  }

  private def createElement(element: Element[_]): raw.HTMLElement =
    document.createElement(element.name).asInstanceOf[raw.HTMLElement]

  private def updateElement(source: Element[_], target: raw.HTMLElement): Unit = {

    EventDelegate.prepare(target)
    source.attributes.foreach {
      case CustomData(name, value) =>
        val attrId = s"data-$name"
        target.setAttribute(attrId, value)

      case Id(value) =>
        target.setAttribute("id", value)

      case c: SimpleAttribute[_] =>
        target.setAttribute(c.name, c.value.toString)

      case e: EventAttribute[_] =>
        EventDelegate.update(e, target)
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

  private def patch(src: Node, dest: raw.Node): Either[String, Unit] = {
    if (dest == null) return Left("The target node was null.")
    if (js.isUndefined(dest)) return Left("The target node was undefined.")

    def recreate(newChild: raw.Node): Either[String, Unit] = {
      dest.parentNode.replaceChild(newChild, dest)
      patch(src, newChild)
    }

    src match {
      case element: Element[_] =>
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
                  dest.appendChild(createChild(child))
                }
                val target = dest.childNodes(index)
                patch(child, target)
              }
              Right()
            } else recreate(createElement(element))
          case _ => recreate(createElement(element))
        }

      case Text(text) =>
        dest match {
          case textNode: raw.Text =>
            if (!textNode.nodeValue.equals(text)) {
              textNode.textContent = text
            }
            Right()

          case _ =>
            recreate(document.createTextNode(text))
        }

      case c: Component =>
        VirtualDOM.renderComponent(c, dest, patch)
    }
  }

  private def createChild(source: Node): raw.Node =
    source match {
      case c: Component => createChild(c.render)
      case e: Element[_] => createElement(e)
      case Text(text) => document.createTextNode(text)
    }
}
