package domino

trait AbstractElementFactory[A <: Attribute, E <: Element[A]] {
  val newElement: (Seq[A], Seq[Node]) => E

  def apply(children: Node*): E =
    newElement(Seq.empty, children)

  def apply(head: A, tail: A*)(children: Node*): Element[A] =
    newElement(head +: tail, children)
}

case class ElementFactory[A <: Attribute, E <: Element[A]](
  newElement: (Seq[A], Seq[Node]) => E)
  extends AbstractElementFactory[A, E]
