package refine.dom

import org.scalajs.dom.{document, raw}
import refine.{Component, Element, Node, Text}

import scala.scalajs.js

/**
 * Algebraic data type representing either the success or failure of an
 * attempt to render a node tree to the DOM.
 */
sealed trait RenderResult

object RenderResult {

  /**
   * The render was successful.
   */
  case object Success extends RenderResult

  /**
   * The render failed at some point. The error message should describe
   * what went wrong.
   *
   * @param errorMsg An explanation of what went wrong.
   */
  case class Failure(errorMsg: String) extends RenderResult
}

object RefineDOM {

  /**
   * Render an element to a node with the passed ID.
   *
   * @param src The wanted content of the node.
   * @param id The id of the node to render to.
   * @return The result of the render.
   */
  def render(src: Element[_], id: String): RenderResult =
    render(src, document.getElementById(id))

  /**
   * Render the passed virtual element to the passed DOM element.
   *
   * @param src The virtual element; the expected result.
   * @param dest The target to place the element inside.
   * @return The result of the render.
   */
  def render(src: Element[_], dest: raw.Element): RenderResult = {
    if (dest.childNodes.length < 1) {
      val newChild = createElement(src)
      dest.appendChild(newChild)
    }

    patch(src, dest.firstChild)
  }

  /**
   * Render a component to a DOM node with the passed ID.
   *
   * @param comp The component to render.
   * @param id The ID of the node to render to.
   * @return The result of the render.
   */
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

  /**
   * Instantiate a new element and cast it to the proper type.
   *
   * @param element The element to create the DOM-side representation of.
   * @return The real element.
   */
  private def createElement(element: Element[_]): raw.HTMLElement =
    document.createElement(element.name).asInstanceOf[raw.HTMLElement]

  // Update this element, ensuring that it has the proper attributes.
  private def updateElement(source: Element[_], target: raw.HTMLElement): Unit = {
    EventDelegate.prepare(target)

    // Create a local partially applied attribute patch function.
    val patch = PatchAttribute(target)

    // Apply it to all our attributes.
    source.nonErasedAttr.foreach(patch)

    // If we have too many attributes, remove the excess ones.
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

  /**
   * Attempt to reconcile the DOM-side node with the wanted result node.
   *
   * @param src The blueprint.
   * @param dest The target.
   * @return The result of the patching.
   */
  private def patch(src: Node, dest: raw.Node): RenderResult = {
    if (dest == null) return RenderResult.Failure("The target node was null.")
    if (js.isUndefined(dest)) return RenderResult.Failure("The target node was undefined.")

    // Recreate the original destination with a new child.
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
