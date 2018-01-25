package org.domino

sealed abstract class Element[A <: Attribute] {
  def attributes: Seq[A]
  def children: Seq[Element[_]]
  def name: String
}

sealed abstract class SpecialElement[A <: Attribute](val name: String) extends Element[A]

case class AudioElement(attributes: Seq[AudioAttribute],
  children: Seq[Element[_]]) extends SpecialElement[AudioAttribute]("audio")

case class ButtonElement(attributes: Seq[ButtonAttribute],
  children: Seq[Element[_]]) extends SpecialElement[ButtonAttribute]("button")

case class CaptionElement(attributes: Seq[CaptionAttribute],
  children: Seq[Element[_]]) extends SpecialElement[CaptionAttribute]("caption")

case class ColElement(attributes: Seq[ColAttribute],
  children: Seq[Element[_]]) extends SpecialElement[ColAttribute]("col")

case class ColGroupElement(attributes: Seq[ColGroupAttribute],
  children: Seq[Element[_]]) extends SpecialElement[ColGroupAttribute]("colgroup")

case class FormElement(attributes: Seq[FormAttribute],
  children: Seq[Element[_]]) extends SpecialElement[FormAttribute]("form")

case class GenericElement(name: String, attributes: Seq[GlobalAttribute],
  children: Seq[Element[_]]) extends Element[GlobalAttribute]()

case class HTMLElement(attributes: Seq[HTMLAttribute],
  children: Seq[Element[_]]) extends SpecialElement[HTMLAttribute]("html")

case class InputElement(attributes: Seq[InputAttribute],
  children: Seq[Element[_]]) extends SpecialElement[InputAttribute]("input")

case class ObjectElement(attributes: Seq[ObjectAttribute],
  children: Seq[Element[_]]) extends SpecialElement[ObjectAttribute]("object")
