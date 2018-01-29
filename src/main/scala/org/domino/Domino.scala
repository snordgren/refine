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

    removeEventAttributes(target)
    source.attributes.foreach {
      case CustomData(name, value) =>
        val attrId = s"data-$name"
        target.setAttribute(attrId, value)

      case Id(value) =>
        target.setAttribute("id", value)

      case c: html.SimpleAttribute[_] =>
        target.setAttribute(c.name, c.value.toString)

      case e: html.EventAttribute[_] =>
        updateEventAttribute(e, target)
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

  /**
   * Remove the custom event listeners stored on this element. They are then re-added
   * in the update code. This means that removed events are removed, without us having
   * to search the listener object for listeners that should be removed.
   *
   * @param target The target to remove the listeners from.
   */
  private def removeEventAttributes(target: raw.HTMLElement): Unit = {
    val dynamicTarget = target.asInstanceOf[js.Dynamic]

    // The listenerStore field on the target DOM element is used to store the event listeners
    // for each type of event, as dynamic fields of the listenerStore object. When an event is
    // fired, the listener looks up the event listener currently stored in the listenerStore with
    // the same name as the event, then executes that listener if it finds one.
    dynamicTarget.listenerStore = js.Dynamic.literal()

    // The listenerInfo field on the target DOM element is used to store info as to whether
    // the delegating listener has been registered or not. If the object is not present on
    // the DOM element it should be added.
    if (js.isUndefined(dynamicTarget.listenerInfo)) {
      dynamicTarget.listenerInfo = js.Dynamic.literal()
    }
  }

  /**
   * The DOM doesn't support removing the event listeners for a type of event, which
   * we might sometimes have to do when the listeners for an object changes. Instead,
   * we add an event listener that stays constant, this event listener looks up the
   * event name in an object stored in a field in the DOM element and executes the
   * listener stored there (if there is one).
   *
   * On each render we rebuild the listener store to match the exact composition
   * of event listeners in that particular render.
   *
   * @param attr The event listener to link with the element.
   * @param target The element that the event listener should be attached to.
   */
  private def updateEventAttribute(attr: html.EventAttribute[_], target: raw.HTMLElement): Unit = {
    val dynamicTarget = target.asInstanceOf[js.Dynamic]

    // If the listenerInfo field does not have an entry with the name of this event,
    // there is no delegating listener bound for this event. We should bind one and
    // register that one has been bound.
    if (!dynamicTarget.listenerInfo.hasOwnProperty(attr.name).asInstanceOf[Boolean]) {
      target.addEventListener(attr.name, (event: raw.Event) => {

        // Add the delegating listener to this element for this event.
        if (dynamicTarget.listenerStore.hasOwnProperty(attr.name).asInstanceOf[Boolean]) {
          val listener = dynamicTarget.listenerStore.selectDynamic(attr.name)
          listener.apply(event)
        }
      })

      // Register an entry in the listenerInfo object with the name of this attribute,
      // so that invocations after this one don't add their own delegating listener.
      dynamicTarget.listenerInfo.updateDynamic(attr.name)(true)
    }

    // Update the field in the listenerStore referring to this particular event attribute.
    dynamicTarget.listenerStore.updateDynamic(attr.name)(attr.f)
  }
}
