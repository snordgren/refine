package org.domino.html

sealed trait Node

case class Text(value: String) extends Node

sealed trait Element[A <: Attribute] extends Node {
  def name: String
  def attributes: Seq[A]
  def children: Seq[Node]
}

abstract class AbstractElement[A <: Attribute](val name: String) extends Element[A]

case class AnchorElement(attributes: Seq[AnchorAttribute],
  children: Seq[Node]) extends AbstractElement[AnchorAttribute]("a")

case class AbbrElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("abbr")

case class AddressElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("address")

case class AreaElement(attributes: Seq[AreaAttribute],
  children: Seq[Node]) extends AbstractElement[AreaAttribute]("area")

case class ArticleElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("article")

case class AsideElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("aside")

case class AudioElement(attributes: Seq[AudioAttribute],
  children: Seq[Node]) extends AbstractElement[AudioAttribute]("audio")

case class BElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("b")

case class BaseElement(attributes: Seq[BaseAttribute],
  children: Seq[Node]) extends AbstractElement[BaseAttribute]("base")

case class BDIElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("bdi")

case class BDOElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("bdo")

case class BlockQuoteElement(attributes: Seq[BlockQuoteAttribute],
  children: Seq[Node]) extends AbstractElement[BlockQuoteAttribute]("blockquote")

case class BodyElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("body")

case class BRElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("br")

case class ButtonElement(attributes: Seq[ButtonAttribute],
  children: Seq[Node]) extends AbstractElement[ButtonAttribute]("button")

case class CanvasElement(attributes: Seq[CanvasAttribute],
  children: Seq[Node]) extends AbstractElement[CanvasAttribute]("canvas")

case class CaptionElement(attributes: Seq[CaptionAttribute],
  children: Seq[Node]) extends AbstractElement[CaptionAttribute]("caption")

case class CiteElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("cite")

case class CodeElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("code")

case class ColElement(attributes: Seq[ColAttribute],
  children: Seq[Node]) extends AbstractElement[ColAttribute]("col")

case class ColGroupElement(attributes: Seq[ColGroupAttribute],
  children: Seq[Node]) extends AbstractElement[ColGroupAttribute]("colgroup")

case class DataListElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("datalist")

case class DDElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dd")

case class DelElement(attributes: Seq[DelAttribute],
  children: Seq[Node]) extends AbstractElement[DelAttribute]("del")

case class DetailsElement(attributes: Seq[DetailsAttribute],
  children: Seq[Node]) extends AbstractElement[DetailsAttribute]("details")

case class DFNElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dfn")

case class DialogElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dialog")

case class DivElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("div")

case class DLElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dl")

case class DTElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dt")

case class EMElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("em")

case class EmbedElement(attributes: Seq[EmbedAttribute],
  children: Seq[Node]) extends AbstractElement[EmbedAttribute]("embed")

case class FieldSetElement(attributes: Seq[FieldSetAttribute],
  children: Seq[Node]) extends AbstractElement[FieldSetAttribute]("fieldset")

case class FigCaptionElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("figcaption")

case class FigureElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("figure")

case class FooterElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("footer")

case class FormElement(attributes: Seq[FormAttribute],
  children: Seq[Node]) extends AbstractElement[FormAttribute]("form")

case class H1Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h1")

case class H2Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h2")

case class H3Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h3")

case class H4Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h4")

case class H5Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h5")

case class H6Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h6")

case class HeadElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("head")

case class HeaderElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("header")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

case class Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("a")

