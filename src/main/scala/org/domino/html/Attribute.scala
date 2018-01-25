package org.domino.html

sealed trait Attribute

sealed trait AnchorAttribute extends Attribute
sealed trait AreaAttribute extends Attribute
sealed trait AudioAttribute extends Attribute
sealed trait BaseAttribute extends Attribute
sealed trait BlockQuoteAttribute extends Attribute
sealed trait ButtonAttribute extends Attribute
sealed trait CanvasAttribute extends Attribute
sealed trait CaptionAttribute extends Attribute
sealed trait ColAttribute extends Attribute
sealed trait ColGroupAttribute extends Attribute
sealed trait CommandAttribute extends Attribute
sealed trait DelAttribute extends Attribute
sealed trait DetailsAttribute extends Attribute
sealed trait EmbedAttribute extends Attribute
sealed trait FieldSetAttribute extends Attribute
sealed trait FormAttribute extends Attribute
sealed trait HRAttribute extends Attribute
sealed trait HTMLAttribute extends Attribute
sealed trait IFrameAttribute extends Attribute
sealed trait ImageAttribute extends Attribute
sealed trait InputAttribute extends Attribute
sealed trait InsAttribute extends Attribute
sealed trait LabelAttribute extends Attribute
sealed trait LinkAttribute extends Attribute
sealed trait LIAttribute extends Attribute
sealed trait MapAttribute extends Attribute
sealed trait MetaAttribute extends Attribute
sealed trait MeterAttribute extends Attribute
sealed trait ObjectAttribute extends Attribute
sealed trait OLAttribute extends Attribute
sealed trait OptGroupAttribute extends Attribute
sealed trait OptionAttribute extends Attribute
sealed trait OutputAttribute extends Attribute
sealed trait ParamAttribute extends Attribute
sealed trait ProgressAttribute extends Attribute
sealed trait QAttribute extends Attribute
sealed trait ScriptAttribute extends Attribute
sealed trait SelectAttribute extends Attribute
sealed trait SourceAttribute extends Attribute
sealed trait StyleAttribute extends Attribute
sealed trait TableAttribute extends Attribute
sealed trait TBodyAttribute extends Attribute
sealed trait TDAttribute extends Attribute
sealed trait TextAreaAttribute extends Attribute
sealed trait TFootAttribute extends Attribute
sealed trait THAttribute extends Attribute
sealed trait THeadAttribute extends Attribute
sealed trait TimeAttribute extends Attribute
sealed trait TRAttribute extends Attribute
sealed trait TrackAttribute extends Attribute
sealed trait VideoAttribute extends Attribute

/**
 * The bottom type, a subtype of any potential type of attribute. This means that
 * attributes that are defined as instances of this trait are applicable to any
 * kind of element.
 */
sealed trait GlobalAttribute extends Attribute
  with AnchorAttribute
  with AreaAttribute
  with AudioAttribute
  with BlockQuoteAttribute
  with ButtonAttribute
  with CanvasAttribute
  with CaptionAttribute
  with ColAttribute
  with ColGroupAttribute
  with CommandAttribute
  with DelAttribute
  with DetailsAttribute
  with EmbedAttribute
  with FieldSetAttribute
  with FormAttribute
  with HRAttribute
  with HTMLAttribute
  with IFrameAttribute
  with ImageAttribute
  with InputAttribute
  with InsAttribute
  with LabelAttribute
  with LinkAttribute
  with LIAttribute
  with MapAttribute
  with MetaAttribute
  with MeterAttribute
  with ObjectAttribute
  with OLAttribute
  with OptGroupAttribute
  with OptionAttribute
  with OutputAttribute
  with ParamAttribute
  with ProgressAttribute
  with QAttribute
  with ScriptAttribute
  with SelectAttribute
  with SourceAttribute
  with StyleAttribute
  with TableAttribute
  with TBodyAttribute
  with TDAttribute
  with TextAreaAttribute
  with TFootAttribute
  with THAttribute
  with THeadAttribute
  with TimeAttribute
  with TRAttribute
  with TrackAttribute
  with VideoAttribute

object Attribute {
  case class Accept(value: String) extends FormAttribute with InputAttribute
  case class AcceptCharset(value: String) extends FormAttribute
  case class Action(value: String) extends FormAttribute
  case class Align(value: String) extends CaptionAttribute
    with ColAttribute
    with ColGroupAttribute
    with HRAttribute
    with IFrameAttribute
    with ImageAttribute
    with TableAttribute
    with TBodyAttribute
    with TDAttribute
    with TFootAttribute
    with THAttribute
    with THeadAttribute
    with TRAttribute

  case class Alternative(value: String) extends AreaAttribute
    with ImageAttribute
    with InputAttribute

  case class Async(value: Boolean) extends ScriptAttribute
  case class AutoComplete(value: Boolean) extends FormAttribute with InputAttribute
  case class AutoFocus(value: Boolean) extends ButtonAttribute
    with InputAttribute
    with SelectAttribute
    with TextAreaAttribute

  case class AutoPlay(value: Boolean) extends AudioAttribute with VideoAttribute
  case class Buffered(value: String) extends AudioAttribute with VideoAttribute
  case class Charset(value: String) extends MetaAttribute with ScriptAttribute
  case class Checked(value: String) extends CommandAttribute with InputAttribute
  case class Cite(value: String) extends BlockQuoteAttribute
    with DelAttribute
    with InsAttribute
    with QAttribute

  case class ClassName(value: String) extends GlobalAttribute
  case class Cols(value: String) extends TextAreaAttribute
  case class ColSpan(value: String) extends TDAttribute with THAttribute
  case class Content(value: String) extends MetaAttribute
  case class ContentEditable(value: String) extends GlobalAttribute
  case class ContextMenu(value: String) extends GlobalAttribute
  case class Controls(value: String) extends AudioAttribute with VideoAttribute
  case class CrossOrigin(value: String) extends AudioAttribute
    with ImageAttribute
    with LinkAttribute
    with ScriptAttribute
    with VideoAttribute

  case class Data(value: String) extends ObjectAttribute
  case class CustomData(name: String, value: String) extends GlobalAttribute
  case class DateTime(value: String) extends DelAttribute
    with InsAttribute
    with TimeAttribute

  case class Default(value: String) extends TrackAttribute
  case class Defer(value: String) extends ScriptAttribute
  case class Dir(value: String) extends GlobalAttribute
  case class DirName(value: String) extends InputAttribute with TextAreaAttribute
  case class Disabled(value: Boolean) extends ButtonAttribute
    with CommandAttribute
    with FieldSetAttribute
    with InputAttribute
    with OptGroupAttribute
    with OptionAttribute
    with SelectAttribute
    with TextAreaAttribute

  case class Download(value: String) extends AnchorAttribute with AreaAttribute
  case class Draggable(value: String) extends GlobalAttribute
  case class DropZone(value: String) extends GlobalAttribute
  case class EncodingType(value: String) extends FormAttribute
  case class For(value: String) extends LabelAttribute with OutputAttribute
  case class Form(value: String) extends ButtonAttribute
    with FieldSetAttribute
    with InputAttribute
    with LabelAttribute
    with MeterAttribute
    with ObjectAttribute
    with OutputAttribute
    with ProgressAttribute
    with SelectAttribute
    with TextAreaAttribute

  case class FormAction(value: String) extends InputAttribute with ButtonAttribute
  case class Headers(name: String) extends TDAttribute with THAttribute
  case class Height(value: String) extends CanvasAttribute
    with EmbedAttribute
    with IFrameAttribute
    with ImageAttribute
    with InputAttribute
    with ObjectAttribute
    with VideoAttribute

  case class Hidden(value: Boolean) extends GlobalAttribute
  case class High(value: String) extends MeterAttribute
  case class Href(value: String) extends AnchorAttribute
    with AreaAttribute
    with BaseAttribute
    with LinkAttribute

  case class HrefLanguage(value: String) extends AnchorAttribute
    with AreaAttribute
    with LinkAttribute

  case class HTTPEquiv(value: String) extends MetaAttribute
  case class Id(value: String) extends GlobalAttribute
  case class Integrity(value: String) extends LinkAttribute with ScriptAttribute
  case class IsMap(value: String) extends ImageAttribute
  case class ItemProp(value: String) extends GlobalAttribute
  case class Kind(value: String) extends TrackAttribute
  case class Label(value: String) extends TrackAttribute
  case class Language(value: String) extends GlobalAttribute
  case class ScriptingLanguage(value: String) extends ScriptAttribute
  case class List(value: String) extends InputAttribute
  case class Loop(value: String) extends AudioAttribute with VideoAttribute
  case class Low(value: String) extends MeterAttribute
  case class Manifest(value: String) extends HTMLAttribute
  case class Max(value: String) extends InputAttribute
    with MeterAttribute
    with ProgressAttribute

  case class MaxLength(value: String) extends InputAttribute with TextAreaAttribute
  case class MinLength(value: String) extends InputAttribute with TextAreaAttribute
  case class Media(value: String) extends AnchorAttribute
    with AreaAttribute
    with LinkAttribute
    with SourceAttribute

  case class Method(value: String) extends FormAttribute
  case class Min(value: String) extends InputAttribute with MeterAttribute
  case class Multiple(value: String) extends InputAttribute with SelectAttribute
  case class Muted(value: String) extends AudioAttribute with VideoAttribute
  case class Name(value: String) extends ButtonAttribute
    with FormAttribute
    with FieldSetAttribute
    with IFrameAttribute
    with InputAttribute
    with MapAttribute
    with MetaAttribute
    with ObjectAttribute
    with OutputAttribute
    with ParamAttribute
    with SelectAttribute
    with TextAreaAttribute


  case class NoValidate(value: String) extends FormAttribute
  case class Open(value: String) extends DetailsAttribute
  case class Optimum(value: String) extends MeterAttribute
  case class Pattern(value: String) extends InputAttribute
  case class Ping(value: String) extends AnchorAttribute with AreaAttribute
  case class Placeholder(value: String) extends InputAttribute with TextAreaAttribute
  case class Poster(value: String) extends VideoAttribute
  case class Preload(Value: String) extends AudioAttribute with VideoAttribute
  case class RadioGroup(value: String) extends AudioAttribute with VideoAttribute
  case class ReadOnly(value: String) extends InputAttribute with TextAreaAttribute
  case class Rel(value: String) extends AnchorAttribute
    with AreaAttribute
    with LinkAttribute

  case class Required(value: String) extends InputAttribute
    with SelectAttribute
    with TextAreaAttribute

  case class Reversed(value: String) extends OLAttribute
  case class Rows(value: String) extends TextAreaAttribute
  case class RowSpan(value: String) extends TDAttribute with THAttribute
  case class Sandbox(value: String) extends IFrameAttribute
  case class Scope(value: String) extends THAttribute
  case class Scoped(value: String) extends AnchorAttribute with AreaAttribute
  case class Seamless(value: String) extends IFrameAttribute
  case class Selected(value: String) extends OptionAttribute
  case class Shape(value: String) extends AnchorAttribute with AreaAttribute
  case class Size(value: String) extends InputAttribute with SelectAttribute
  case class Sizes(value: String) extends LinkAttribute
    with ImageAttribute
    with SourceAttribute

  case class Slot(value: String) extends GlobalAttribute
  case class Span(value: String) extends ColAttribute with ColGroupAttribute
  case class SpellCheck(value: String) extends GlobalAttribute
  case class Source(value: String) extends AudioAttribute
    with EmbedAttribute
    with IFrameAttribute
    with ImageAttribute
    with InputAttribute
    with ScriptAttribute
    with SourceAttribute
    with TrackAttribute
    with VideoAttribute

  case class SourceDocument(value: String) extends IFrameAttribute
  case class SourceLanguage(value: String) extends TrackAttribute
  case class SourceSet(value: String) extends ImageAttribute
  case class Start(value: String) extends OLAttribute
  case class Step(value: String) extends InputAttribute
  case class Style(value: String) extends GlobalAttribute
  case class Summary(value: String) extends TableAttribute
  case class TabIndex(value: String) extends GlobalAttribute
  case class Target(value: String) extends AnchorAttribute
    with AreaAttribute
    with BaseAttribute
    with FormAttribute

  case class Title(value: String) extends GlobalAttribute
  case class Type(value: String) extends ButtonAttribute
    with EmbedAttribute
    with InputAttribute
    with ObjectAttribute
    with ScriptAttribute
    with SourceAttribute
    with StyleAttribute

  case class UseMap(value: String) extends ImageAttribute
    with InputAttribute
    with ObjectAttribute

  case class Value(value: String) extends ButtonAttribute
    with InputAttribute
    with LIAttribute
    with MeterAttribute
    with OptionAttribute
    with ParamAttribute
    with ProgressAttribute

  case class Width(value: String) extends CanvasAttribute
    with EmbedAttribute
    with IFrameAttribute
    with ImageAttribute
    with InputAttribute
    with ObjectAttribute
    with VideoAttribute

  case class Wrap(value: String) extends TextAreaAttribute
}
