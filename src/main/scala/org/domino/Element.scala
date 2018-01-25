package org.domino

sealed abstract class Element[A <: Attribute] {
  def attributes: Seq[A]
  def children: Seq[Element[_]]
  def name: String
}

sealed abstract class SpecialElement[A <: Attribute](val name: String) extends Element[A]

case class GenericElement(name: String, attributes: Seq[GlobalAttribute],
  children: Seq[Element[_]]) extends Element[GlobalAttribute]()

case class HTMLElement(attributes: Seq[HTMLAttribute],
  children: Seq[Element[_]]) extends SpecialElement[HTMLAttribute]("html")
