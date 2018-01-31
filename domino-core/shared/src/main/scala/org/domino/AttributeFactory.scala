package org.domino

case class AttributeFactory[T, A](f: T => A) {
  def :=(value: T): A = f(value)
}
