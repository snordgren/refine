package org.domino.html

trait Elements {
  implicit def string2Text(s: String): Node = Text(s)

  def a(attributes: AnchorAttribute*)(children: Node*) =
    AnchorElement(attributes, children)

  def abbr(attributes: GlobalAttribute*)(children: Node*) =
    AbbrElement(attributes, children)

  def address(attributes: GlobalAttribute*)(children: Node*) =
    AddressElement(attributes, children)

  def area(attributes: AreaAttribute*)(children: Node*) =
    AreaElement(attributes, children)

  def article(attributes: GlobalAttribute*)(children: Node*) =
    ArticleElement(attributes, children)

  def aside(attributes: GlobalAttribute*)(children: Node*) =
    AsideElement(attributes, children)

  def audio(attributes: AudioAttribute*)(children: Node*) =
    AudioElement(attributes, children)

  def b(attributes: GlobalAttribute*)(children: Node*) =
    BElement(attributes, children)

  def base(attributes: BaseAttribute*)(children: Node*) =
    BaseElement(attributes, children)

  def bdi(attributes: GlobalAttribute*)(children: Node*) =
    BDIElement(attributes, children)

  def bdo(attributes: GlobalAttribute*)(children: Node*) =
    BDOElement(attributes, children)

  def blockquote(attributes: BlockQuoteAttribute*)(children: Node*) =
    BlockQuoteElement(attributes, children)

  def body(attributes: GlobalAttribute*)(children: Node*) =
    BodyElement(attributes, children)

  def br(attributes: GlobalAttribute*)(children: Node*) =
    BRElement(attributes, children)

  def button(attributes: ButtonAttribute*)(children: Node*) =
    ButtonElement(attributes, children)

  def canvas(attributes: CanvasAttribute*)(children: Node*) =
    CanvasElement(attributes, children)

  def caption(attributes: CaptionAttribute*)(children: Node*) =
    CaptionElement(attributes, children)

  def cite(attributes: GlobalAttribute*)(children: Node*) =
    CiteElement(attributes, children)

  def code(attributes: GlobalAttribute*)(children: Node*) =
    CodeElement(attributes, children)

  def col(attributes: ColAttribute*)(children: Node*) =
    ColElement(attributes, children)

  def colgroup(attributes: ColGroupAttribute*)(children: Node*) =
    ColGroupElement(attributes, children)

  def datalist(attributes: GlobalAttribute*)(children: Node*) =
    DataListElement(attributes, children)

  def dd(attributes: GlobalAttribute*)(children: Node*) =
    DDElement(attributes, children)

  def del(attributes: DelAttribute*)(children: Node*) =
    DelElement(attributes, children)

  def details(attributes: DetailsAttribute*)(children: Node*) =
    DetailsElement(attributes, children)

  def dfn(attributes: GlobalAttribute*)(children: Node*) =
    DFNElement(attributes, children)

  def dialog(attributes: GlobalAttribute*)(children: Node*) =
    DialogElement(attributes, children)

  def div(attributes: GlobalAttribute*)(children: Node*) =
    DivElement(attributes, children)

  def dl(attributes: GlobalAttribute*)(children: Node*) =
    DLElement(attributes, children)

  def dt(attributes: GlobalAttribute*)(children: Node*) =
    DTElement(attributes, children)

  def em(attributes: GlobalAttribute*)(children: Node*) =
    EMElement(attributes, children)

  def embed(attributes: EmbedAttribute*)(children: Node*) =
    EmbedElement(attributes, children)

  def fieldset(attributes: FieldSetAttribute*)(children: Node*) =
    FieldSetElement(attributes, children)

  def figcaption(attributes: GlobalAttribute*)(children: Node*) =
    FigCaptionElement(attributes, children)

  def figure(attributes: GlobalAttribute*)(children: Node*) =
    FigureElement(attributes, children)

  def footer(attributes: GlobalAttribute*)(children: Node*) =
    FooterElement(attributes, children)

  def form(attributes: FormAttribute*)(children: Node*) =
    FormElement(attributes, children)

  def h1(attributes: GlobalAttribute*)(children: Node*) =
    H1Element(attributes, children)

  def h2(attributes: GlobalAttribute*)(children: Node*) =
    H2Element(attributes, children)

  def h3(attributes: GlobalAttribute*)(children: Node*) =
    H3Element(attributes, children)

  def h4(attributes: GlobalAttribute*)(children: Node*) =
    H4Element(attributes, children)

  def h5(attributes: GlobalAttribute*)(children: Node*) =
    H5Element(attributes, children)

  def h6(attributes: GlobalAttribute*)(children: Node*) =
    H6Element(attributes, children)

  def head(attributes: GlobalAttribute*)(children: Node*) =
    HeadElement(attributes, children)

  def header(attributes: GlobalAttribute*)(children: Node*) =
    HeaderElement(attributes, children)

  def hr(attributes: HRAttribute*)(children: Node*) =
    HRElement(attributes, children)

  def html(attributes: HTMLAttribute*)(children: Node*) =
    HTMLElement(attributes, children)

  def i(attributes: GlobalAttribute*)(children: Node*) =
    IElement(attributes, children)

  def iframe(attributes: IFrameAttribute*)(children: Node*) =
    IFrameElement(attributes, children)

  def img(attributes: ImageAttribute*)(children: Node*) =
    ImageElement(attributes, children)

  def input(attributes: InputAttribute*)(children: Node*) =
    InputElement(attributes, children)

  def ins(attributes: InsAttribute*)(children: Node*) =
    InsElement(attributes, children)

  def kbd(attributes: GlobalAttribute*)(children: Node*) =
    KBDElement(attributes, children)

  def label(attributes: LabelAttribute*)(children: Node*) =
    LabelElement(attributes, children)

  def legend(attributes: GlobalAttribute*)(children: Node*) =
    LegendElement(attributes, children)

  def li(attributes: GlobalAttribute*)(children: Node*) =
    LIElement(attributes, children)

  def link(attributes: LinkAttribute*)(children: Node*) =
    LinkElement(attributes, children)

  def main(attributes: GlobalAttribute*)(children: Node*) =
    MainElement(attributes, children)

  def map(attributes: MapAttribute*)(children: Node*) =
    MapElement(attributes, children)

  def mark(attributes: GlobalAttribute*)(children: Node*) =
    MarkElement(attributes, children)

  def meta(attributes: MetaAttribute*)(children: Node*) =
    MetaElement(attributes, children)

  def meter(attributes: MeterAttribute*)(children: Node*) =
    MeterElement(attributes, children)

  def nav(attributes: GlobalAttribute*)(children: Node*) =
    NavElement(attributes, children)

  def noscript(attributes: GlobalAttribute*)(children: Node*) =
    NoScriptElement(attributes, children)

  def `object`(attributes: ObjectAttribute*)(children: Node*) =
    ObjectElement(attributes, children)

  def ol(attributes: OLAttribute*)(children: Node*) =
    OLElement(attributes, children)

  def optgroup(attributes: GlobalAttribute*)(children: Node*) =
    OptGroupElement(attributes, children)

  def option(attributes: GlobalAttribute*)(children: Node*) =
    OptionElement(attributes, children)

  def output(attributes: GlobalAttribute*)(children: Node*) =
    OutputElement(attributes, children)

  def p(attributes: GlobalAttribute*)(children: Node*) =
    ParagraphElement(attributes, children)

  def param(attributes: GlobalAttribute*)(children: Node*) =
    Element("param", attributes, children)

  def picture(attributes: GlobalAttribute*)(children: Node*) =
    Element("picture", attributes, children)

  def pre(attributes: GlobalAttribute*)(children: Node*) =
    Element("pre", attributes, children)

  def progress(attributes: GlobalAttribute*)(children: Node*) =
    Element("progress", attributes, children)

  def q(attributes: GlobalAttribute*)(children: Node*) =
    Element("q", attributes, children)

  def rp(attributes: GlobalAttribute*)(children: Node*) =
    Element("rp", attributes, children)

  def rt(attributes: GlobalAttribute*)(children: Node*) =
    Element("rt", attributes, children)

  def ruby(attributes: GlobalAttribute*)(children: Node*) =
    Element("ruby", attributes, children)

  def s(attributes: GlobalAttribute*)(children: Node*) =
    Element("s", attributes, children)

  def samp(attributes: GlobalAttribute*)(children: Node*) =
    Element("samp", attributes, children)

  def script(attributes: GlobalAttribute*)(children: Node*) =
    Element("script", attributes, children)

  def section(attributes: GlobalAttribute*)(children: Node*) =
    Element("section", attributes, children)

  def select(attributes: GlobalAttribute*)(children: Node*) =
    Element("select", attributes, children)

  def small(attributes: GlobalAttribute*)(children: Node*) =
    Element("small", attributes, children)

  def source(attributes: SourceAttribute*)(children: Node*) =
    Element("source", attributes, children)

  def span(attributes: GlobalAttribute*)(children: Node*) =
    Element("span", attributes, children)

  def strong(attributes: GlobalAttribute*)(children: Node*) =
    Element("strong", attributes, children)

  def style(attributes: StyleAttribute*)(children: Node*) =
    Element("style", attributes, children)

  def sub(attributes: GlobalAttribute*)(children: Node*) =
    Element("sub", attributes, children)

  def summary(attributes: GlobalAttribute*)(children: Node*) =
    Element("summary", attributes, children)

  def sup(attributes: GlobalAttribute*)(children: Node*) =
    Element("sup", attributes, children)

  def table(attributes: GlobalAttribute*)(children: Node*) =
    Element("table", attributes, children)

  def tbody(attributes: GlobalAttribute*)(children: Node*) =
    Element("tbody", attributes, children)

  def td(attributes: GlobalAttribute*)(children: Node*) =
    Element("td", attributes, children)

  def template(attributes: GlobalAttribute*)(children: Node*) =
    Element("template", attributes, children)

  def textarea(attributes: TextAreaAttribute*)(children: Node*) =
    Element("textarea", attributes, children)

  def tfoot(attributes: GlobalAttribute*)(children: Node*) =
    Element("tfoot", attributes, children)

  def th(attributes: GlobalAttribute*)(children: Node*) =
    Element("th", attributes, children)

  def thead(attributes: GlobalAttribute*)(children: Node*) =
    Element("thead", attributes, children)

  def time(attributes: GlobalAttribute*)(children: Node*) =
    Element("time", attributes, children)

  def title(attributes: GlobalAttribute*)(children: Node*) =
    Element("title", attributes, children)

  def tr(attributes: GlobalAttribute*)(children: Node*) =
    Element("tr", attributes, children)

  def track(attributes: TrackAttribute*)(children: Node*) =
    Element("track", attributes, children)

  def u(attributes: GlobalAttribute*)(children: Node*) =
    Element("u", attributes, children)

  def ul(attributes: GlobalAttribute*)(children: Node*) =
    Element("ul", attributes, children)

  def `var`(attributes: GlobalAttribute*)(children: Node*) =
    Element("var", attributes, children)

  def video(attributes: GlobalAttribute*)(children: Node*) =
    Element("video", attributes, children)

  def wbr(attributes: GlobalAttribute*)(children: Node*) =
    Element("wbr", attributes, children)
}
