package refine.dom

import org.scalajs.dom.{Event, document, raw}
import refine.Node

import scala.collection.mutable
import scala.scalajs.js

object RefineDOM {

  /**
   * Render to the DOM, ignoring any events.
   */
  def renderStatic[A](node: Node.Element[A], target: raw.Node): Unit =
    render[A]((_, _) => (), node, target)

  def render[A](f: (A, Event) => Unit, node: Node.Element[A], target: raw.Node): Unit = {

    val childNodes = target.childNodes
    val targetChild = if (target.hasChildNodes()) {
      childNodes(0)
    } else {
      val newChild = createElementFrom(node)
      target.appendChild(newChild)
      newChild
    }

    while (childNodes.length > 1) {
      target.removeChild(childNodes(1))
    }

    renderUnsafe(f, node, targetChild)
  }

  private def createElementFrom[A](a: Node.Element[A]): raw.HTMLElement = {
    document.createElement(a.name).asInstanceOf[raw.HTMLElement]
  }

  private def removeSurplusChildren[A](n: Node.Element[A], e: raw.HTMLElement): Unit = {
    val childNodes = e.childNodes
    val currentLength = childNodes.length

    if (n.children.length < currentLength) {
      var index = n.children.length

      while (index < currentLength) {
        e.removeChild(childNodes.apply(index))

        index += 1
      }
    }
  }

  private def renderUnsafe[A](f: (A, Event) => Unit, node: Node[A], target: raw.Node): Unit =
    node match {
      case a: Node.Element[A] => renderElementAt(f, a, target)
      case Node.Text(text) => renderTextAt(text, target)
    }

  private def renderElementAt[A](
    f: (A, Event) => Unit, n: Node.Element[A], target: raw.Node
  ): Unit =
    target match {
      case a: raw.HTMLElement =>
        if (a.nodeName.equalsIgnoreCase(n.name)) {
          updateElementAttributes(n, a)
          updateElementCallbacks(f, n, a)
          removeSurplusChildren(n, a)
          updateChildren(f, n, a)
        } else {
          val newTarget = createElementFrom(n)
          replaceNode(target, newTarget)
          renderElementAt(f, n, newTarget)
        }

      case a: raw.Text =>
        val newTarget = createElementFrom(n)
        replaceNode(a, newTarget)
        renderElementAt(f, n, newTarget)

      case _ =>
    }

  private def renderTextAt(text: String, target: raw.Node): Unit =
    target match {
      case a: raw.Text =>
        if (text != a.textContent) {
          a.textContent = text
        }

      case _ =>
        val newNode = document.createTextNode(text)
        replaceNode(target, newNode)
    }

  private def replaceNode(oldNode: raw.Node, newNode: raw.Node): Unit = {
    oldNode.parentNode.replaceChild(newNode, oldNode)
  }

  private def updateChildren[A](
    f: (A, Event) => Unit, n: Node.Element[A], e: raw.HTMLElement
  ): Unit = {
    val oldChildNodes = e.childNodes
    var index = 0

    while (index < n.children.length) {
      val currentSourceChild = n.children(index)

      val target = if (oldChildNodes.length > index) {
        oldChildNodes(index)
      } else {
        val newChild = currentSourceChild match {
          case a: Node.Element[A] => createElementFrom(a)
          case Node.Text(text) => document.createTextNode(text)
        }
        e.appendChild(newChild)
        newChild
      }

      renderUnsafe(f, currentSourceChild, target)

      index += 1
    }
  }

  private def updateElementAttributes[A](n: Node.Element[A], e: raw.HTMLElement): Unit = {
    val oldAttrs = e.attributes
    var index = 0
    val toRemove = new mutable.ArrayBuffer[raw.Attr](oldAttrs.length)

    while (index < oldAttrs.length) {
      val current = oldAttrs(index)

      n.properties.find(_.name == current.name) match {
        case Some(newAttr) => current.value = newAttr.value
        case None => toRemove += current
      }

      index += 1
    }

    for (a <- toRemove) {
      e.removeAttributeNode(a)
    }

    for (a <- n.properties) {
      if (!e.hasAttribute(a.name)) {
        e.setAttribute(a.name, a.value)
      }
    }
  }

  private def updateElementCallbacks[A](
    f: (A, Event) => Unit, n: Node.Element[A], e: raw.HTMLElement
  ): Unit = {
    val dynamicE = e.asInstanceOf[js.Dynamic]

    // Re-allocate the listener store on each update, so that all unused listeners are
    // automatically dropped.
    dynamicE.vdomListenerStore = js.Dynamic.literal()

    // The vdomListenerMetadata stores whether or not an event listener delegating to the
    // current value in the listener store has been registered on the DOM node.
    if (js.isUndefined(dynamicE.vdomListenerMetadata)) {
      dynamicE.vdomListenerMetadata = js.Dynamic.literal()
    }

    val callbacks = n.callbacks
    for (a <- callbacks) {
      val callbackEventName = a.event.jsName

      // If the metadata has no property with the name of the current event, we bind an
      // event listener, and register that one has been bound.
      if (!dynamicE.vdomListenerMetadata.hasOwnProperty(callbackEventName)
        .asInstanceOf[Boolean]) {

        // Register our new event handler.
        e.addEventListener(callbackEventName, { (b: Event) =>
          val store = dynamicE.vdomListenerStore

          if (store.hasOwnProperty(callbackEventName).asInstanceOf[Boolean]) {
            val listener = store.selectDynamic(callbackEventName)
            listener.apply(b)
          }
        })

        // Register that our new event handler has been bound.
        dynamicE.vdomListenerMetadata.updateDynamic(callbackEventName)(true)
      }

      dynamicE.vdomListenerStore.updateDynamic(callbackEventName) { (b: Event) =>
        f(a.message, b)
      }
    }
  }
}
