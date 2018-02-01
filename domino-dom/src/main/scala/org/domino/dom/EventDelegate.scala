package org.domino.dom

import org.domino.EventAttribute
import org.scalajs.dom.raw

import scala.scalajs.js

/**
 * The EventDelegate object contains methods that handle the addition and removal of
 * event listeners from DOM objects that correspond to nodes.
 */
object EventDelegate {

  /**
   * Remove the custom event listeners stored on this element. They are then re-added
   * in the update code. This means that removed events are removed, without us having
   * to search the listener object for listeners that should be removed.
   *
   * If the listenerInfo object on the target is undefined, it is initialized to an
   * empty object literal, allowing event delegates to store their listener values on
   * it.
   *
   * @param target The target to remove the listeners from.
   */
  private[dom] def prepare(target: raw.HTMLElement): Unit = {
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
  private[dom] def update(attr: EventAttribute[_], target: raw.HTMLElement): Unit = {
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
