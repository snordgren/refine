package refine.dom

case class EventAttributeFactory[A, B](newAttribute: A => B) {
  def apply(f: A): B =
    newAttribute(f)
}
