package domino

/**
 * This factory reconciles the namespace conflict that an attribute and
 * element with the same name causes. This is possible as the syntax for
 * creating an attribute is different from that of creating an element.
 */
case class OverloadedFactory[A <: Attribute, E <: Element[A], T, B](
  newElement: (Seq[A], Seq[Node]) => E,
  newAttribute: T => B)
  extends AbstractAttributeFactory[T, B]
    with AbstractElementFactory[A, E]
