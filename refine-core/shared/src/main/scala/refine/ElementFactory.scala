package refine

/**
 * Trait for sharing code between OverloadedFactory and ElementFactory.
 *
 * @tparam A The type of attribute for the element to be created.
 * @tparam E The type of element to be created.
 */
trait AbstractElementFactory[A <: Attribute, E <: Element[A]] {

  /**
   * The constructor of the element - a factory function for instantiating
   * new instances of the element.
   */
  private[refine] val newElement: (Seq[A], Seq[Node]) => E

  /**
   * Instantiate a new element using this factory. This constructor only
   * adds children, with no attributes. Use this constructor for an empty
   * element with no attributes and no children, or an element with children
   * but no attributes.
   *
   * @param children The sequence of children to add to this element.
   * @return The new element.
   */
  def apply(children: Node*): E =
    newElement(AbstractElementFactory.emptySeq.asInstanceOf[Seq[A]], children)

  /**
   * Instantiate a new element using this factory. Use this constructor
   * for elements that require both elements and attributes.
   *
   * @param head The first attribute.
   * @param tail The rest of the attributes.
   * @param children The child elements. Leave empty to create an element with
   * attributes, but no children.
   * @return The new element.
   */
  def apply(head: A, tail: A*)(children: Node*): Element[A] =
    if (tail.length == 0)
      newElement(Seq(head), children)
    else newElement(head +: tail, children)
}

object AbstractElementFactory {
  // Avoid re-allocating the empty sequence by storing an empty one here.
  // This is faster than Seq.empty for some reason.
  private val emptySeq = Seq()
}

/**
 * Instantiates new elements of a particular type of element.
 *
 * @param newElement The element constructor.
 * @tparam A The attribute type that the element takes.
 * @tparam E The type of element that is returned.
 */
case class ElementFactory[A <: Attribute, E <: Element[A]](
  newElement: (Seq[A], Seq[Node]) => E)
  extends AbstractElementFactory[A, E]
