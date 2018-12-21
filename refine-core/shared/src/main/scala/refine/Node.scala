package refine

import scala.collection.mutable

sealed trait Node[A] {
  def renderToString: String =
    TextRenderer.run(this)
}

object Node {
  final case class Element[A](
    name: String, attributes: Seq[Attribute[A]], children: Seq[Node[A]], closingTag: Boolean
  ) extends Node[A] {

    lazy val callbacks: Seq[Attribute.Callback[A]] = {
      val b = new mutable.ArrayBuffer[Attribute.Callback[A]](attributes.length)
      var index = 0

      while (index < attributes.length) {
        val current = attributes(index)

        current match {
          case a: Attribute.Callback[A] => b += a
          case _ =>
        }

        index += 1
      }

      b
    }

    lazy val properties: Seq[Attribute.Property[A]] = {
      val b = new mutable.ArrayBuffer[Attribute.Property[A]](attributes.length)
      var index = 0

      while (index < attributes.length) {
        val current = attributes(index)

        current match {
          case a: Attribute.Property[A] => b += a
          case _ =>
        }

        index += 1
      }

      b
    }

  }

  final case class Text[A](value: String) extends Node[A]
}
