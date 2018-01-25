package org.domino

sealed trait Attribute

sealed trait AreaAttribute extends Attribute
sealed trait AudioAttribute extends Attribute
sealed trait ButtonAttribute extends Attribute
sealed trait CaptionAttribute extends Attribute
sealed trait ColAttribute extends Attribute
sealed trait ColGroupAttribute extends Attribute
sealed trait FormAttribute extends Attribute
sealed trait HRAttribute extends Attribute
sealed trait HTMLAttribute extends Attribute
sealed trait IFrameAttribute extends Attribute
sealed trait ImageAttribute extends Attribute
sealed trait InputAttribute extends Attribute
sealed trait KeyGenAttribute extends Attribute
sealed trait ObjectAttribute extends Attribute
sealed trait ScriptAttribute extends Attribute
sealed trait SelectAttribute extends Attribute
sealed trait TableAttribute extends Attribute
sealed trait TBodyAttribute extends Attribute
sealed trait TDAttribute extends Attribute
sealed trait TextAreaAttribute extends Attribute
sealed trait TFootAttribute extends Attribute
sealed trait THAttribute extends Attribute
sealed trait THeadAttribute extends Attribute
sealed trait TRAttribute extends Attribute
sealed trait VideoAttribute extends Attribute

/**
 * The bottom type, a subtype of any potential type of attribute. This means that
 * attributes that are defined as instances of this trait are applicable to any
 * kind of element.
 */
sealed trait GlobalAttribute extends Attribute
  with AreaAttribute
  with AudioAttribute
  with ButtonAttribute
  with CaptionAttribute
  with ColAttribute
  with ColGroupAttribute
  with FormAttribute
  with HRAttribute
  with HTMLAttribute
  with IFrameAttribute
  with ImageAttribute
  with InputAttribute
  with KeyGenAttribute
  with ObjectAttribute
  with ScriptAttribute
  with SelectAttribute
  with TableAttribute
  with TBodyAttribute
  with TDAttribute
  with TextAreaAttribute
  with TFootAttribute
  with THAttribute
  with THeadAttribute
  with TRAttribute
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

  case class Language(value: String) extends GlobalAttribute
  val lang = AttributeFactory(Language)

  case class Manifest(value: String) extends HTMLAttribute
  val manifest = AttributeFactory(Manifest)
}
