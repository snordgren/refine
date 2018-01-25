package org.domino

sealed trait Attribute

sealed trait AnchorAttribute extends Attribute
sealed trait AreaAttribute extends Attribute
sealed trait AudioAttribute extends Attribute
sealed trait BlockQuoteAttribute extends Attribute
sealed trait ButtonAttribute extends Attribute
sealed trait CaptionAttribute extends Attribute
sealed trait ColAttribute extends Attribute
sealed trait ColGroupAttribute extends Attribute
sealed trait CommandAttribute extends Attribute
sealed trait DelAttribute extends Attribute
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
sealed trait KeyGenAttribute extends Attribute
sealed trait MetaAttribute extends Attribute
sealed trait MeterAttribute extends Attribute
sealed trait ObjectAttribute extends Attribute
sealed trait OptGroupAttribute extends Attribute
sealed trait OptionAttribute extends Attribute
sealed trait OutputAttribute extends Attribute
sealed trait ProgressAttribute extends Attribute
sealed trait QAttribute extends Attribute
sealed trait ScriptAttribute extends Attribute
sealed trait SelectAttribute extends Attribute
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
  with CaptionAttribute
  with ColAttribute
  with ColGroupAttribute
  with CommandAttribute
  with DelAttribute
  with FieldSetAttribute
  with FormAttribute
  with HRAttribute
  with HTMLAttribute
  with IFrameAttribute
  with ImageAttribute
  with InputAttribute
  with InsAttribute
  with KeyGenAttribute
  with LabelAttribute
  with LinkAttribute
  with MetaAttribute
  with MeterAttribute
  with ObjectAttribute
  with OptGroupAttribute
  with OptionAttribute
  with OutputAttribute
  with ProgressAttribute
  with QAttribute
  with ScriptAttribute
  with SelectAttribute
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
  case class AttributeFactory[T, A](f: T => A) {
    def :=(value: T): A = f(value)
  }

  case class Accept(value: String) extends FormAttribute with InputAttribute
  val accept = AttributeFactory(Accept)

  case class AcceptCharset(value: String) extends FormAttribute
  val acceptCharset = AttributeFactory(AcceptCharset)

  case class Action(value: String) extends FormAttribute
  val action = AttributeFactory(Action)

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
  val align = AttributeFactory(Align)

  case class Alternative(value: String) extends AreaAttribute
    with ImageAttribute
    with InputAttribute
  val alt = AttributeFactory(Alternative)

  case class Async(value: Boolean) extends ScriptAttribute
  val async = AttributeFactory(Async)

  case class AutoComplete(value: Boolean) extends FormAttribute with InputAttribute
  val autoComplete = AttributeFactory(AutoComplete)

  case class AutoFocus(value: Boolean) extends ButtonAttribute
    with InputAttribute
    with KeyGenAttribute
    with SelectAttribute
    with TextAreaAttribute
  val autoFocus = AttributeFactory(AutoFocus)

  case class AutoPlay(value: Boolean) extends AudioAttribute with VideoAttribute
  val autoplay = AttributeFactory(AutoPlay)

  case class Buffered(value: String) extends AudioAttribute with VideoAttribute
  val buffered = AttributeFactory(Buffered)

  case class Challenge(value: String) extends KeyGenAttribute
  val challenge = AttributeFactory(Challenge)

  case class Charset(value: String) extends MetaAttribute with ScriptAttribute
  val charset = AttributeFactory(Charset)

  case class Checked(value: String) extends CommandAttribute with InputAttribute
  val checked = AttributeFactory(Checked)

  case class Cite(value: String) extends BlockQuoteAttribute
    with DelAttribute
    with InsAttribute
    with QAttribute
  val cite = AttributeFactory(Cite)

  case class ClassName(name: String) extends GlobalAttribute
  val className = AttributeFactory(ClassName)

  case class Cols(value: String) extends TextAreaAttribute
  val cols = AttributeFactory(cols)

  case class ColSpan(value: String) extends TDAttribute with THAttribute
  val colspan = AttributeFactory(ColSpan)

  case class Content(value: String) extends MetaAttribute
  val content = AttributeFactory(Content)

  case class ContentEditable(value: String) extends GlobalAttribute
  val contenteditable = AttributeFactory(ContentEditable)

  case class ContextMenu(value: String) extends GlobalAttribute
  val contextmenu = AttributeFactory(ContextMenu)

  case class Controls(value: String) extends AudioAttribute with VideoAttribute
  val controls = AttributeFactory(Controls)

  case class CrossOrigin(value: String) extends AudioAttribute
    with ImageAttribute
    with LinkAttribute
    with ScriptAttribute
    with VideoAttribute
  val crossorigin = AttributeFactory(CrossOrigin)

  case class Data(value: String) extends ObjectAttribute
  val data = AttributeFactory(Data)

  case class CustomData(name: String, value: String) extends GlobalAttribute
  def data(name: String) = AttributeFactory((t: String) => CustomData(name, t))

  case class DateTime(value: String) extends DelAttribute
    with InsAttribute
    with TimeAttribute
  val datetime = AttributeFactory(DateTime)

  case class Default(value: String) extends TrackAttribute
  val default = AttributeFactory(Default)

  case class Defer(value: String) extends ScriptAttribute
  val defer = AttributeFactory(Defer)

  case class Dir(value: String) extends GlobalAttribute
  val dir = AttributeFactory(Dir)

  case class DirName(value: String) extends InputAttribute with TextAreaAttribute
  val dirname = AttributeFactory(DirName)

  case class Disabled(value: Boolean) extends ButtonAttribute
    with CommandAttribute
    with FieldSetAttribute
    with InputAttribute
    with KeyGenAttribute
    with OptGroupAttribute
    with OptionAttribute
    with SelectAttribute
    with TextAreaAttribute
  val disabled = AttributeFactory(Disabled)

  case class Download(value: String) extends AnchorAttribute with AreaAttribute
  val download = AttributeFactory(Download)

  case class Draggable(value: String) extends GlobalAttribute
  val draggable = AttributeFactory(Draggable)

  case class DropZone(value: String) extends GlobalAttribute
  val dropzone = AttributeFactory(DropZone)

  case class EncodingType(value: String) extends FormAttribute
  val enctype = AttributeFactory(EncodingType)

  case class For(value: String) extends LabelAttribute with OutputAttribute
  val `for` = AttributeFactory(For)

  case class Form(value: String) extends ButtonAttribute
    with FieldSetAttribute
    with InputAttribute
    with KeyGenAttribute
    with LabelAttribute
    with MeterAttribute
    with ObjectAttribute
    with OutputAttribute
    with ProgressAttribute
    with SelectAttribute
    with TextAreaAttribute
  val form = AttributeFactory(Form)

  case class Language(value: String) extends GlobalAttribute
  val lang = AttributeFactory(Language)

  case class Manifest(value: String) extends HTMLAttribute
  val manifest = AttributeFactory(Manifest)
}
