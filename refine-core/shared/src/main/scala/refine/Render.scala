package refine

trait Render[T] extends HTML {
  def render(t: T): Node
}

object Render {
  implicit def toNode[A](a: A)(implicit ev: Render[A]): Node =
    ev.render(a)
}
