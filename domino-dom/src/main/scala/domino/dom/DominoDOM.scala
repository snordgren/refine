package domino.dom

import domino.{Component, Element, Node, Text}
import org.scalajs.dom.{document, raw}

import scala.scalajs.js

sealed trait RenderResult

object RenderResult {

  case object Success extends RenderResult

  case class Failure(errorMsg: String) extends RenderResult

}

object DominoDOM {
  def render(src: Element[_], id: String): RenderResult =
    render(src, document.getElementById(id))

  def render(src: Element[_], dest: raw.Element): RenderResult = {
    if (dest.childNodes.length < 1) {
      val newChild = createElement(src)
      dest.appendChild(newChild)
    }

    patch(src, dest.firstChild)
  }

  def render(comp: Component, id: String): RenderResult =
    render(comp, document.getElementById(id))

  def render(comp: Component, dest: raw.Element): RenderResult = {
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

    val patch = PatchAttribute(target)
    source.nonErasedAttr.foreach(patch)

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

  private def patch(src: Node, dest: raw.Node): RenderResult = {
    if (dest == null) return RenderResult.Failure("The target node was null.")
    if (js.isUndefined(dest)) return RenderResult.Failure("The target node was undefined.")

    def recreate(newChild: raw.Node): RenderResult = {
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
              RenderResult.Success
            } else recreate(createElement(element))
          case _ => recreate(createElement(element))
        }

      case Text(text) =>
        dest match {
          case textNode: raw.Text =>
            if (!textNode.nodeValue.equals(text)) {
              textNode.textContent = text
            }
            RenderResult.Success

          case _ =>
            recreate(document.createTextNode(text))
        }

      case c: Component =>
        RenderComponent(c, dest, patch)
    }
  }

  private def createChild(source: Node): raw.Node =
    source match {
      case c: Component => createChild(c.render)
      case e: Element[_] => createElement(e)
      case Text(text) => document.createTextNode(text)
    }
}
