package org.domino

import org.domino.html.{Element, Node, Text}

object TextRenderer {
  def apply(root: Node): String = render(root)

  def render(root: Node): String = {
    root match {
      case Text(text) => text
      case el: Element[_] =>
        val attrStr = if (el.nonErasedAttr.nonEmpty) {
          val attributes = el.nonErasedAttr
          val attrBuf = new StringBuilder()
          var index = 0

          while (index < attributes.length) {
            val attr = attributes(index)
            attrBuf.append(' ')
            attrBuf.append(attr.render)
            index += 1
          }

          attrBuf.toString()
        } else ""

        val childStr = if (el.children.nonEmpty) {
          val childBuf = new StringBuilder()
          var index = 0
          while (index < el.children.length) {
            val child = el.children(index)
            childBuf.append(render(child))
            index += 1
          }
          childBuf.toString()
        } else ""

        "<" + el.name + attrStr + ">" + childStr + "</" + el.name + ">"
    }
  }
}
