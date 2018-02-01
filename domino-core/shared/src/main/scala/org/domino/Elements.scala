package org.domino

trait Elements {

  def a(children: Node*) = AnchorElement(Seq.empty, children)

  def a(head: AnchorAttribute, tail: AnchorAttribute*)(children: Node*) =
    AnchorElement(head +: tail, children)

  def anchor(children: Node*) = AnchorElement(Seq.empty, children)

  def anchor(head: AnchorAttribute, tail: AnchorAttribute*)(children: Node*) =
    AnchorElement(head +: tail, children)

  def abbr(children: Node*) = AbbrElement(Seq.empty, children)

  def abbr(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    AbbrElement(head +: tail, children)

  def address(children: Node*) = AddressElement(Seq.empty, children)

  def address(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    AddressElement(head +: tail, children)

  def area(children: Node*) = AreaElement(Seq.empty, children)

  def area(head: AreaAttribute, tail: AreaAttribute*)(children: Node*) =
    AreaElement(head +: tail, children)

  def article(children: Node*) = ArticleElement(Seq.empty, children)

  def article(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    ArticleElement(head +: tail, children)

  def aside(children: Node*) = AsideElement(Seq.empty, children)

  def aside(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    AsideElement(head +: tail, children)

  def audio(children: Node*) = AudioElement(Seq.empty, children)

  def audio(head: AudioAttribute, tail: AudioAttribute*)(children: Node*) =
    AudioElement(head +: tail, children)

  def b(children: Node*) = BElement(Seq.empty, children)

  def b(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    BElement(head +: tail, children)

  def base(children: Node*) = BaseElement(Seq.empty, children)

  def base(head: BaseAttribute, tail: BaseAttribute*)(children: Node*) =
    BaseElement(head +: tail, children)

  def bdi(children: Node*) = BDIElement(Seq.empty, children)

  def bdi(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    BDIElement(head +: tail, children)

  def bdo(children: Node*) = BDOElement(Seq.empty, children)

  def bdo(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    BDOElement(head +: tail, children)

  def blockquote(children: Node*) = BlockQuoteElement(Seq.empty, children)

  def blockquote(head: BlockQuoteAttribute, tail: BlockQuoteAttribute*)(children: Node*) =
    BlockQuoteElement(head +: tail, children)

  def body(children: Node*) = BodyElement(Seq.empty, children)

  def body(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    BodyElement(head +: tail, children)

  def br(children: Node*) = BRElement(Seq.empty, children)

  def br(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    BRElement(head +: tail, children)

  def button(children: Node*) = ButtonElement(Seq.empty, children)

  def button(head: ButtonAttribute, tail: ButtonAttribute*)(children: Node*) =
    ButtonElement(head +: tail, children)

  def canvas(children: Node*) = CanvasElement(Seq.empty, children)

  def canvas(head: CanvasAttribute, tail: CanvasAttribute*)(children: Node*) =
    CanvasElement(head +: tail, children)

  def caption(children: Node*) = CaptionElement(Seq.empty, children)

  def caption(head: CaptionAttribute, tail: CaptionAttribute*)(children: Node*) =
    CaptionElement(head +: tail, children)

  def cite(children: Node*) = CiteElement(Seq.empty, children)

  def cite(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    CiteElement(head +: tail, children)

  def code(children: Node*) = CodeElement(Seq.empty, children)

  def code(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    CodeElement(head +: tail, children)

  def col(children: Node*) = ColElement(Seq.empty, children)

  def col(head: ColAttribute, tail: ColAttribute*)(children: Node*) =
    ColElement(head +: tail, children)

  def colgroup(children: Node*) = ColGroupElement(Seq.empty, children)

  def colgroup(head: ColGroupAttribute, tail: ColGroupAttribute*)(children: Node*) =
    ColGroupElement(head +: tail, children)

  def datalist(children: Node*) = DataListElement(Seq.empty, children)

  def datalist(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    DataListElement(head +: tail, children)

  def dd(children: Node*) = DDElement(Seq.empty, children)

  def dd(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    DDElement(head +: tail, children)

  def del(children: Node*) = DelElement(Seq.empty, children)

  def del(head: DelAttribute, tail: DelAttribute*)(children: Node*) =
    DelElement(head +: tail, children)

  def details(children: Node*) = DetailsElement(Seq.empty, children)

  def details(head: DetailsAttribute, tail: DetailsAttribute*)(children: Node*) =
    DetailsElement(head +: tail, children)

  def dfn(children: Node*) = DFNElement(Seq.empty, children)

  def dfn(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    DFNElement(head +: tail, children)

  def dialog(children: Node*) = DialogElement(Seq.empty, children)

  def dialog(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    DialogElement(head +: tail, children)

  def div(children: Node*) = DivElement(Seq.empty, children)

  def div(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    DivElement(head +: tail, children)

  def dl(children: Node*) = DLElement(Seq.empty, children)

  def dl(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    DLElement(head +: tail, children)

  def dt(children: Node*) = DTElement(Seq.empty, children)

  def dt(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    DTElement(head +: tail, children)

  def em(children: Node*) = EMElement(Seq.empty, children)

  def em(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    EMElement(head +: tail, children)

  def embed(children: Node*) = EmbedElement(Seq.empty, children)

  def embed(head: EmbedAttribute, tail: EmbedAttribute*)(children: Node*) =
    EmbedElement(head +: tail, children)

  def fieldset(children: Node*) = FieldSetElement(Seq.empty, children)

  def fieldset(head: FieldSetAttribute, tail: FieldSetAttribute*)(children: Node*) =
    FieldSetElement(head +: tail, children)

  def figcaption(children: Node*) = FigCaptionElement(Seq.empty, children)

  def figcaption(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    FigCaptionElement(head +: tail, children)

  def figure(children: Node*) = FigureElement(Seq.empty, children)

  def figure(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    FigureElement(head +: tail, children)

  def footer(children: Node*) = FooterElement(Seq.empty, children)

  def footer(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    FooterElement(head +: tail, children)

  def form(children: Node*) = FormElement(Seq.empty, children)

  def form(head: FormAttribute, tail: FormAttribute*)(children: Node*) =
    FormElement(head +: tail, children)

  def h1(children: Node*) = H1Element(Seq.empty, children)

  def h1(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    H1Element(head +: tail, children)

  def h2(children: Node*) = H2Element(Seq.empty, children)

  def h2(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    H2Element(head +: tail, children)

  def h3(children: Node*) = H3Element(Seq.empty, children)

  def h3(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    H3Element(head +: tail, children)

  def h4(children: Node*) = H4Element(Seq.empty, children)

  def h4(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    H4Element(head +: tail, children)

  def h5(children: Node*) = H5Element(Seq.empty, children)

  def h5(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    H5Element(head +: tail, children)

  def h6(children: Node*) = H6Element(Seq.empty, children)

  def h6(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    H6Element(head +: tail, children)

  def head(children: Node*) = HeadElement(Seq.empty, children)

  def head(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    HeadElement(head +: tail, children)

  def header(children: Node*) = HeaderElement(Seq.empty, children)

  def header(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    HeaderElement(head +: tail, children)

  def hr(children: Node*) = HRElement(Seq.empty, children)

  def hr(head: HRAttribute, tail: HRAttribute*)(children: Node*) =
    HRElement(head +: tail, children)

  def html(children: Node*) = HTMLElement(Seq.empty, children)

  def html(head: HTMLAttribute, tail: HTMLAttribute*)(children: Node*) =
    HTMLElement(head +: tail, children)

  def i(children: Node*) = IElement(Seq.empty, children)

  def i(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    IElement(head +: tail, children)

  def iframe(children: Node*) = IFrameElement(Seq.empty, children)

  def iframe(head: IFrameAttribute, tail: IFrameAttribute*)(children: Node*) =
    IFrameElement(head +: tail, children)

  def img(children: Node*) = ImageElement(Seq.empty, children)

  def img(head: ImageAttribute, tail: ImageAttribute*)(children: Node*) =
    ImageElement(head +: tail, children)

  def input(children: Node*) = InputElement(Seq.empty, children)

  def input(head: InputAttribute, tail: InputAttribute*)(children: Node*) =
    InputElement(head +: tail, children)

  def ins(children: Node*) = InsElement(Seq.empty, children)

  def ins(head: InsAttribute, tail: InsAttribute*)(children: Node*) =
    InsElement(head +: tail, children)

  def kbd(children: Node*) = KBDElement(Seq.empty, children)

  def kbd(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    KBDElement(head +: tail, children)

  def label(children: Node*) = LabelElement(Seq.empty, children)

  def label(head: LabelAttribute, tail: LabelAttribute*)(children: Node*) =
    LabelElement(head +: tail, children)

  def legend(children: Node*) = LegendElement(Seq.empty, children)

  def legend(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    LegendElement(head +: tail, children)

  def li(children: Node*) = LIElement(Seq.empty, children)

  def li(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    LIElement(head +: tail, children)

  def link(children: Node*) = LinkElement(Seq.empty, children)

  def link(head: LinkAttribute, tail: LinkAttribute*)(children: Node*) =
    LinkElement(head +: tail, children)

  def main(children: Node*) = MainElement(Seq.empty, children)

  def main(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    MainElement(head +: tail, children)

  def map(children: Node*) = MapElement(Seq.empty, children)

  def map(head: MapAttribute, tail: MapAttribute*)(children: Node*) =
    MapElement(head +: tail, children)

  def mark(children: Node*) = MarkElement(Seq.empty, children)

  def mark(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    MarkElement(head +: tail, children)

  def meta(children: Node*) = MetaElement(Seq.empty, children)

  def meta(head: MetaAttribute, tail: MetaAttribute*)(children: Node*) =
    MetaElement(head +: tail, children)

  def meter(children: Node*) = MeterElement(Seq.empty, children)

  def meter(head: MeterAttribute, tail: MeterAttribute*)(children: Node*) =
    MeterElement(head +: tail, children)

  def nav(children: Node*) = NavElement(Seq.empty, children)

  def nav(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    NavElement(head +: tail, children)

  def noscript(children: Node*) = NoScriptElement(Seq.empty, children)

  def noscript(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    NoScriptElement(head +: tail, children)

  def `object`(children: Node*) = ObjectElement(Seq.empty, children)

  def `object`(head: ObjectAttribute, tail: ObjectAttribute*)(children: Node*) =
    ObjectElement(head +: tail, children)

  def ol(children: Node*) = OLElement(Seq.empty, children)

  def ol(head: OLAttribute, tail: OLAttribute*)(children: Node*) =
    OLElement(head +: tail, children)

  def optgroup(children: Node*) = OptGroupElement(Seq.empty, children)

  def optgroup(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    OptGroupElement(head +: tail, children)

  def option(children: Node*) = OptionElement(Seq.empty, children)

  def option(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    OptionElement(head +: tail, children)

  def output(children: Node*) = OutputElement(Seq.empty, children)

  def output(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    OutputElement(head +: tail, children)

  def p(children: Node*) = ParagraphElement(Seq.empty, children)

  def p(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    ParagraphElement(head +: tail, children)

  def param(children: Node*) = ParamElement(Seq.empty, children)

  def param(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    ParamElement(head +: tail, children)

  def picture(children: Node*) = PictureElement(Seq.empty, children)

  def picture(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    PictureElement(head +: tail, children)

  def pre(children: Node*) = PreElement(Seq.empty, children)

  def pre(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    PreElement(head +: tail, children)

  def progress(children: Node*) = ProgressElement(Seq.empty, children)

  def progress(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    ProgressElement(head +: tail, children)

  def q(children: Node*) = QElement(Seq.empty, children)

  def q(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    QElement(head +: tail, children)

  def rp(children: Node*) = RPElement(Seq.empty, children)

  def rp(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    RPElement(head +: tail, children)

  def rt(children: Node*) = RTElement(Seq.empty, children)

  def rt(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    RTElement(head +: tail, children)

  def ruby(children: Node*) = RubyElement(Seq.empty, children)

  def ruby(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    RubyElement(head +: tail, children)

  def s(children: Node*) = SElement(Seq.empty, children)

  def s(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    SElement(head +: tail, children)

  def samp(children: Node*) = SampElement(Seq.empty, children)

  def samp(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    SampElement(head +: tail, children)

  def script(children: Node*) = ScriptElement(Seq.empty, children)

  def script(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    ScriptElement(head +: tail, children)

  def section(children: Node*) = SectionElement(Seq.empty, children)

  def section(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    SectionElement(head +: tail, children)

  def select(children: Node*) = SelectElement(Seq.empty, children)

  def select(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    SelectElement(head +: tail, children)

  def small(children: Node*) = SmallElement(Seq.empty, children)

  def small(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    SmallElement(head +: tail, children)

  def source(children: Node*) = SourceElement(Seq.empty, children)

  def source(head: SourceAttribute, tail: SourceAttribute*)(children: Node*) =
    SourceElement(head +: tail, children)

  def span(children: Node*) = SpanElement(Seq.empty, children)

  def span(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    SpanElement(head +: tail, children)

  def strong(children: Node*) = StrongElement(Seq.empty, children)

  def strong(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    StrongElement(head +: tail, children)

  def style(children: Node*) = StyleElement(Seq.empty, children)

  def style(head: StyleAttribute, tail: StyleAttribute*)(children: Node*) =
    StyleElement(head +: tail, children)

  def sub(children: Node*) = SubElement(Seq.empty, children)

  def sub(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    SubElement(head +: tail, children)

  def summary(children: Node*) = SummaryElement(Seq.empty, children)

  def summary(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    SummaryElement(head +: tail, children)

  def sup(children: Node*) = SupElement(Seq.empty, children)

  def sup(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    SupElement(head +: tail, children)

  def table(children: Node*) = TableElement(Seq.empty, children)

  def table(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    TableElement(head +: tail, children)

  def tbody(children: Node*) = TBodyElement(Seq.empty, children)

  def tbody(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    TBodyElement(head +: tail, children)

  def td(children: Node*) = TDElement(Seq.empty, children)

  def td(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    TDElement(head +: tail, children)

  def template(children: Node*) = TemplateElement(Seq.empty, children)

  def template(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    TemplateElement(head +: tail, children)

  def textarea(children: Node*) = TextAreaElement(Seq.empty, children)

  def textarea(head: TextAreaAttribute, tail: TextAreaAttribute*)(children: Node*) =
    TextAreaElement(head +: tail, children)

  def tfoot(children: Node*) = TFootElement(Seq.empty, children)

  def tfoot(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    TFootElement(head +: tail, children)

  def th(children: Node*) = THElement(Seq.empty, children)

  def th(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    THElement(head +: tail, children)

  def thead(children: Node*) = THeadElement(Seq.empty, children)

  def thead(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    THeadElement(head +: tail, children)

  def time(children: Node*) = TimeElement(Seq.empty, children)

  def time(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    TimeElement(head +: tail, children)

  def title(children: Node*) = TitleElement(Seq.empty, children)

  def title(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    TitleElement(head +: tail, children)

  def tr(children: Node*) = TRElement(Seq.empty, children)

  def tr(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    TRElement(head +: tail, children)

  def track(children: Node*) = TrackElement(Seq.empty, children)

  def track(head: TrackAttribute, tail: TrackAttribute*)(children: Node*) =
    TrackElement(head +: tail, children)

  def u(children: Node*) = UElement(Seq.empty, children)

  def u(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    UElement(head +: tail, children)

  def ul(children: Node*) = ULElement(Seq.empty, children)

  def ul(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    ULElement(head +: tail, children)

  def `var`(children: Node*) = VarElement(Seq.empty, children)

  def `var`(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    VarElement(head +: tail, children)

  def video(children: Node*) = VideoElement(Seq.empty, children)

  def video(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    VideoElement(head +: tail, children)

  def wbr(children: Node*) = WBRElement(Seq.empty, children)

  def wbr(head: GlobalAttribute, tail: GlobalAttribute*)(children: Node*) =
    WBRElement(head +: tail, children)
}