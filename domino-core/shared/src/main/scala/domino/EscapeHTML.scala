package domino

import java.lang.StringBuilder

object EscapeHTML {
  def apply(str: String): String = {
    val result = new StringBuilder()
    var index = 0
    while (index < str.length) {
      val currentChar = str.codePointAt(index)
      index += Character.charCount(currentChar)
      currentChar match {
        case '&' => result.append("&amp;")
        case '<' => result.append("&lt;")
        case '>' => result.append("&gt;")
        case '"' => result.append("&quot;")
        case '\'' => result.append("&#39;")
        case '`' => result.append("&#96;")
        case ',' => result.append("&#44;")
        case '!' => result.append("&#33;")
        case '@' => result.append("&#64;")
        case '$' => result.append("&#36;")
        case '%' => result.append("&#37;")
        case '(' => result.append("&#40;")
        case ')' => result.append("&#41;")
        case '=' => result.append("&#61;")
        case '+' => result.append("&#43;")
        case '-' => result.append("&#45;")
        case '{' => result.append("&#123;")
        case '}' => result.append("&#125;")
        case '[' => result.append("&#91;")
        case ']' => result.append("&#93;")
        case '/' => result.append("&#47;")
        case _ => result.appendCodePoint(currentChar)
      }
    }

    result.toString
  }
}
