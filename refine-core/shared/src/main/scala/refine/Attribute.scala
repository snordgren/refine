package refine

sealed trait Attribute[A]
object Attribute {
  final case class Property[A](name: String, value: String) extends Attribute[A]

  final case class Callback[A](event: Event, message: A) extends Attribute[A]
}
