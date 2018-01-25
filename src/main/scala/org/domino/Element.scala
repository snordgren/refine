package org.domino

sealed trait Node
case class Text(value: String) extends Node
sealed abstract class Element[A <: Attribute] extends Node {
  def attributes: Seq[A]
  def children: Seq[Node]
  def name: String
}

sealed abstract class SpecialElement[A <: Attribute](val name: String) extends Element[A]

case class AnchorElement(attributes: Seq[AnchorAttribute],
  children: Seq[Node]) extends SpecialElement[AnchorAttribute]("a")

case class AudioElement(attributes: Seq[AudioAttribute],
  children: Seq[Node]) extends SpecialElement[AudioAttribute]("audio")

case class ButtonElement(attributes: Seq[ButtonAttribute],
  children: Seq[Node]) extends SpecialElement[ButtonAttribute]("button")

case class CaptionElement(attributes: Seq[CaptionAttribute],
  children: Seq[Node]) extends SpecialElement[CaptionAttribute]("caption")

case class ColElement(attributes: Seq[ColAttribute],
  children: Seq[Node]) extends SpecialElement[ColAttribute]("col")

case class ColGroupElement(attributes: Seq[ColGroupAttribute],
  children: Seq[Node]) extends SpecialElement[ColGroupAttribute]("colgroup")

case class FormElement(attributes: Seq[FormAttribute],
  children: Seq[Node]) extends SpecialElement[FormAttribute]("form")

case class GenericElement(name: String, attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends Element[GlobalAttribute]()

case class HTMLElement(attributes: Seq[HTMLAttribute],
  children: Seq[Node]) extends SpecialElement[HTMLAttribute]("html")

case class InputElement(attributes: Seq[InputAttribute],
  children: Seq[Node]) extends SpecialElement[InputAttribute]("input")

case class ObjectElement(attributes: Seq[ObjectAttribute],
  children: Seq[Node]) extends SpecialElement[ObjectAttribute]("object")
