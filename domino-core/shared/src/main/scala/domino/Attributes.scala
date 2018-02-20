package domino

trait Attributes {

  import Attribute._

  lazy val accept = AttributeFactory(Accept)
  lazy val acceptCharset = AttributeFactory(AcceptCharset)
  lazy val accesskey = AttributeFactory(AccessKey)
  lazy val action = AttributeFactory(Action)
  lazy val align = AttributeFactory(Align)
  lazy val alt = AttributeFactory(Alternative)
  lazy val async = AttributeFactory(Async)
  lazy val autoComplete = AttributeFactory(AutoComplete)
  lazy val autoFocus = AttributeFactory(AutoFocus)
  lazy val autoplay = AttributeFactory(AutoPlay)
  lazy val buffered = AttributeFactory(Buffered)
  lazy val charset = AttributeFactory(Charset)
  lazy val checked = AttributeFactory(Checked)
  private[domino] lazy val citeAttribute = AttributeFactory(Cite)
  lazy val className = AttributeFactory(ClassName)
  lazy val cls = className
  lazy val cols = AttributeFactory(Cols)
  lazy val colspan = AttributeFactory(ColSpan)
  lazy val content = AttributeFactory(Content)
  lazy val contenteditable = AttributeFactory(ContentEditable)
  lazy val controls = AttributeFactory(Controls)
  lazy val crossorigin = AttributeFactory(CrossOrigin)
  lazy val data = AttributeFactory(Data)
  lazy val datetime = AttributeFactory(DateTime)
  lazy val default = AttributeFactory(Default)
  lazy val defer = AttributeFactory(Defer)
  lazy val dir = AttributeFactory(Dir)
  lazy val dirname = AttributeFactory(DirName)
  lazy val disabled = AttributeFactory(Disabled)
  lazy val download = AttributeFactory(Download)
  lazy val draggable = AttributeFactory(Draggable)
  lazy val dropzone = AttributeFactory(DropZone)
  lazy val enctype = AttributeFactory(EncodingType)
  lazy val `for` = AttributeFactory(For)
  lazy val formaction = AttributeFactory(FormAction)
  lazy val headers = AttributeFactory(Headers)
  lazy val height = AttributeFactory(Height)
  lazy val hidden = AttributeFactory(Hidden)
  lazy val high = AttributeFactory(High)
  lazy val href = AttributeFactory(Href)
  lazy val hreflang = AttributeFactory(HrefLanguage)
  lazy val httpEquiv = AttributeFactory(HTTPEquiv)
  lazy val id: AttributeFactory[String, Id] = AttributeFactory(Id)
  lazy val integrity = AttributeFactory(Integrity)
  lazy val ismap = AttributeFactory(IsMap)
  lazy val itemprop = AttributeFactory(ItemProp)
  lazy val kind = AttributeFactory(Kind)
  lazy val lang = AttributeFactory(Attribute.Language)
  lazy val language = AttributeFactory(ScriptingLanguage)
  lazy val list = AttributeFactory(List)
  lazy val loop = AttributeFactory(Loop)
  lazy val low = AttributeFactory(Low)
  lazy val manifest = AttributeFactory(Manifest)
  lazy val max = AttributeFactory(Max)
  lazy val maxlength = AttributeFactory(MaxLength)
  lazy val minlength = AttributeFactory(MinLength)
  lazy val media = AttributeFactory(Media)
  lazy val method = AttributeFactory(Method)
  lazy val min = AttributeFactory(Min)
  lazy val multiple = AttributeFactory(Multiple)
  lazy val muted = AttributeFactory(Muted)
  lazy val name = AttributeFactory(Name)
  lazy val novalidate = AttributeFactory(NoValidate)
  lazy val open = AttributeFactory(Open)
  lazy val optimum = AttributeFactory(Optimum)
  lazy val pattern = AttributeFactory(Pattern)
  lazy val ping = AttributeFactory(Ping)
  lazy val placeholder = AttributeFactory(Placeholder)
  lazy val poster = AttributeFactory(Poster)
  lazy val preload = AttributeFactory(Preload)
  lazy val radiogroup = AttributeFactory(RadioGroup)
  lazy val readonly = AttributeFactory(ReadOnly)
  lazy val rel = AttributeFactory(Rel)
  lazy val required = AttributeFactory(Required)
  lazy val reversed = AttributeFactory(Reversed)
  lazy val rows = AttributeFactory(Rows)
  lazy val rowspan = AttributeFactory(RowSpan)
  lazy val sandbox = AttributeFactory(Sandbox)
  lazy val scope = AttributeFactory(Scope)
  lazy val scoped = AttributeFactory(Scoped)
  lazy val seamless = AttributeFactory(Seamless)
  lazy val selected = AttributeFactory(Selected)
  lazy val shape = AttributeFactory(Shape)
  lazy val size = AttributeFactory(Size)
  lazy val sizes = AttributeFactory(Sizes)
  lazy val slot = AttributeFactory(Slot)
  lazy val spellcheck = AttributeFactory(SpellCheck)
  lazy val src = AttributeFactory(Source)
  lazy val srcdoc = AttributeFactory(SourceDocument)
  lazy val srclang = AttributeFactory(SourceLanguage)
  lazy val srcset = AttributeFactory(SourceSet)
  lazy val start = AttributeFactory(Start)
  lazy val step = AttributeFactory(Step)
  lazy val tabindex = AttributeFactory(TabIndex)
  lazy val target = AttributeFactory(Target)
  lazy val `type` = AttributeFactory(Type)
  lazy val usemap = AttributeFactory(UseMap)
  lazy val value = AttributeFactory(Value)
  lazy val width = AttributeFactory(Width)
  lazy val wrap = AttributeFactory(Wrap)

  def data(name: String) = AttributeFactory((t: String) => CustomData(name, t))
}
