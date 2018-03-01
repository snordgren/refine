package refine

/**
 * Trait for sharing attribute creation code between AttributeFactory and
 * OverloadedFactory.
 *
 * @tparam T The type of value that the attribute requires.
 * @tparam A The type of attribute that this factory instantiates.
 */
trait AbstractAttributeFactory[T, A] {
  val newAttribute: T => A

  /**
   * Instantiate a new attribute instance with the parameter value.
   *
   * @param value The value of the attribute.
   * @return The created attribute object with the correct value.
   */
  def :=(value: T): A = newAttribute(value)
}

/**
 * The AttributeFactory type is used to instantiate HTML attributes assigned to
 * values using the := operator.
 *
 * @param newAttribute The function that instantiates a new attribute of type A with a
 * value of type T.
 * @tparam T The type of the constructor parameter value for the attribute.
 * @tparam A The type of attribute.
 */
case class AttributeFactory[T, A](newAttribute: T => A)
  extends AbstractAttributeFactory[T, A]
