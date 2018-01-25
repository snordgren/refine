package org.domino.html

sealed trait Node
case class Text(value: String) extends Node
case class Element[A <: Attribute](name: String,
  attributes: Seq[A],
  children: Seq[Node]) extends Node
