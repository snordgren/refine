package org.domino

import org.scalajs.dom.{document, raw}

object VirtualDOM {
  def render(src: html.Node, dest: raw.HTMLElement): Unit =
    src match {
      case element: html.Element[_] =>
        element.children.zipWithIndex.foreach((t) => {
          val (node, index) = t
          if (index >= dest.childElementCount) {
            val el = createElement(element)
            dest.appendChild(el)
          } else {

          }
        })

      case html.Text(text) =>
        dest.outerHTML = text
    }
  private def createElement(element: html.Element[_]): raw.Element =
    element match {
      case html.AnchorElement(attributes, children) => document.createElement(element.name)
      case _ => document.createElement(element.name)
    }
}
