package org.domino

import org.domino.html.Attribute.{CustomData, Id}
import org.domino.html.{Element, EventAttribute, Node, SimpleAttribute, Text}

object TextRenderer {
  def apply(root: Node): String = render(root)

  def render(root: Node): String = {
    root match {
      case Text(text) => text
      case el: Element[_] =>
        val attrs = el.nonErasedAttr.map {
          case s: SimpleAttribute[_] =>
            s"""${s.name}="${s.value}""""
          case e: EventAttribute[_] =>
            s"""${e.name}="${e.f.toString()}""""
          case d: CustomData =>
            s"""data-${d.name}="${d.value}""""
          case Id(value) =>
            s"""id="#$value""""
        }.foldLeft("")((left, right) => s"$left $right")
        val children = el.children.map(render).fold("")((left, right) => s"$left$right")
        s"<${el.name}$attrs>$children</${el.name}>"
    }
  }
}
