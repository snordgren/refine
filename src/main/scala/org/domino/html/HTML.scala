package org.domino.html

/**
 * The HTML object aggregates the factories for elements and attributes. It also
 * provides implicit conversions from objects into nodes.
 *
 * Import the members of this object in functions that are intended to return an
 * HTML tree. Do not import it as a top-level import as that may lead to namespace
 * collisions.
 */
object HTML extends Elements with Attributes {
  implicit def double2Text(n: Double): Node = Text(n.toString)
  implicit def float2Text(n: Float): Node = Text(n.toString)
  implicit def int2Text(n: Int): Node = Text(n.toString)
  implicit def long2Text(n: Long): Node = Text(n.toString)
  implicit def string2Text(s: String): Node = Text(s)
}
