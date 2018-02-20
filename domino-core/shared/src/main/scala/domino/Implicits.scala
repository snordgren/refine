package domino

trait Implicits {
  implicit def double2Text(n: Double): Node = Text(n.toString)
  implicit def float2Text(n: Float): Node = Text(n.toString)
  implicit def int2Text(n: Int): Node = Text(n.toString)
  implicit def long2Text(n: Long): Node = Text(n.toString)
  implicit def string2Text(s: String): Node = Text(s)
}
