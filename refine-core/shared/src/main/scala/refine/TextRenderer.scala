package refine

import java.lang.StringBuilder

object TextRenderer {
  def run[A](n: Node[A]): String = {
    val s = new StringBuilder()
    render(n, s)
    s.toString
  }

  private def render[A](n: Node[A], s: StringBuilder): Unit =
    n match {
      case a: Node.Element[A] =>
        if (a.name.equalsIgnoreCase("html")) {
          s.append("<!DOCTYPE html>")
        }
        s.append('<')
        s.append(a.name)

        writeAttributes(s, a.properties)

        s.append('>')

        if (a.children.nonEmpty || a.closingTag) {
          var index = 0

          while (index < a.children.length) {
            render(a.children(index), s)
            index += 1
          }

          s.append('<')
          s.append('/')
          s.append(a.name)
          s.append('>')
        }

      case Node.Text(text) =>
        appendText(text, s)
    }

  private def writeAttributes[A](s: StringBuilder, a: Seq[Attribute.Property[A]]): Unit =
    if (a.nonEmpty) {
      s.append(' ')

      var index = 0

      while (index < a.length) {
        appendAttribute(a(index), s)
        if (index + 1 < a.length) {
          s.append(' ')
        }
        index += 1
      }
    }

  private def appendAttribute[A](a: Attribute.Property[A], s: StringBuilder): Unit = {
    s.append(a.name)
    s.append("=\"")

    var index = 0
    val str = a.value.toString

    while (index < str.length) {
      val currentChar = str.codePointAt(index)
      index += Character.charCount(currentChar)
      currentChar match {
        case '&' => s.append("&amp;")
        case '<' => s.append("&lt;")
        case '>' => s.append("&gt;")
        case '"' => s.append("&quot;")
        case '\'' => s.append("&#39;")
        case _ => s.appendCodePoint(currentChar)
      }
    }

    s.append('"')
  }

  private def appendText(str: String, s: StringBuilder): Unit = {
    var index = 0
    while (index < str.length) {
      val currentChar = str.codePointAt(index)
      index += Character.charCount(currentChar)
      currentChar match {
        case '&' => s.append("&amp;")
        case '<' => s.append("&lt;")
        case '>' => s.append("&gt;")
        case _ => s.appendCodePoint(currentChar)
      }
    }
  }
}
