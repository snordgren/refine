package domino.dom

import domino.Attribute.{AutoComplete, CustomData, Id}
import domino.{Attribute, BooleanAttribute, EventAttribute, SimpleAttribute}
import org.scalajs.dom.raw

object PatchAttribute {
  def apply(target: raw.HTMLElement) =
    (attr: Attribute) =>
      attr match {
        case a: AutoComplete =>
          target.setAttribute(a.name, if (a.value) "on" else "off")

        case CustomData(name, value) =>
          val attrId = s"data-$name"
          target.setAttribute(attrId, value)

        case Id(value) =>
          target.setAttribute("id", value)

        case b: BooleanAttribute =>
          if (b.value) {
            target.setAttribute(b.name, b.name)
          } else target.removeAttribute(b.name)

        case c: SimpleAttribute[_] =>
          target.setAttribute(c.name, c.value.toString)

        case e: EventAttribute[_] =>
          EventDelegate.update(e, target)
      }
}
