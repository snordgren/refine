package refine

/**
 * Implicit functions for automatically transforming numbers and strings into
 * Text nodes.
 */
trait Conversions {
  implicit def toText(n: Double): Node = Text(n.toString)
  implicit def toText(n: Float): Node = Text(n.toString)
  implicit def toText(n: Int): Node = Text(n.toString)
  implicit def toText(n: Long): Node = Text(n.toString)
  implicit def toText(s: String): Node = Text(s)
  implicit def toNode[A](a: A)(implicit ev: Render[A]): Node =
    ev.render(a)
}
