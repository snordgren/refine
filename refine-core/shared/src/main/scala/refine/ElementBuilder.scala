package refine

final class ElementBuilder(name: String, closingTag: Boolean) {
  def apply[A](attributes: Attribute[A]*)(children: Node[A]*): Node.Element[A] =
    Node.Element[A](name, attributes, children, closingTag)
}
