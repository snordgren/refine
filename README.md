# Domino

[![Join the chat at https://gitter.im/scalajs-domino/Lobby](https://badges.gitter.im/scalajs-domino/Lobby.svg)](https://gitter.im/scalajs-domino/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Domino is a library for declarative HTML rendering in Scala.js.

## Install
Add the following to your `build.sbt`. You can find `dominoVersion` in the Releases
tab.

	resolvers += "jitpack" at "https://jitpack.io"
	
	// JVM
	libraryDependencies += "com.github.snordgren.domino" %% "domino-core" % dominoVersion

	// Scala.js
    libraryDependencies ++= Seq(
      "com.github.snordgren.domino" %%% "domino-core" % dominoVersion,
      "com.github.snordgren.domino" %%% "domino-dom" % dominoVersion)
      
## Getting Started
### Hello, world!
```scala
import org.scalajs.dom.document
import domino._
import domino.dom._

object App {
  def main(args: Array[String]): Unit = {
    import html._
    
    val html = h1("Hello, world!")
    DominoDOM.render(html, "root")
  }
}
```

Import the ScalaJS document to acquire components, and import `domino.HTML._` in the
function where you render HTML (importing all members of HTML at the top of your file
will likely cause namespace collisions). DominoDOM.render will render your HTML to the
id that you pass in, or a custom element if you prefer.

### Components

```scala
import org.scalajs.dom.document
import domino._
import domino.dom._

case class Header(title: String) extends Component {
  override def render = {
    import html._
    
    h1(title)
  }
}

case class App() extends Component {
  override def render = {
    import html._
    
    div(Header(), p("I'm the description..."))
  }
}

object App {
  def main(args: Array[String]): Unit = {
    import html._
    
    DominoDOM.render(App(), "root")
  }
}
```

Components generate elements based on parameters. If the DOM is re-rendered,
components that compare equally between the first and second renders are not
re-rendered.
