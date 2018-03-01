package refine

import java.lang.StringBuilder

object EscapeHTML {
  def appendAttribute(str: String, result: StringBuilder): Unit = {
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
        case _ => result.appendCodePoint(currentChar)
      }
    }
  }

  def appendElement(str: String, result: StringBuilder): Unit = {
    var index = 0
    while (index < str.length) {
      val currentChar = str.codePointAt(index)
      index += Character.charCount(currentChar)
      currentChar match {
        case '&' => result.append("&amp;")
        case '<' => result.append("&lt;")
        case '>' => result.append("&gt;")
        case _ => result.appendCodePoint(currentChar)
      }
    }
  }

  def attribute(str: String): String = {
    val result = new StringBuilder()
    appendAttribute(str, result)
    result.toString
  }

  def element(str: String): String = {
    val result = new StringBuilder()
    appendElement(str, result)
    result.toString
  }
}
