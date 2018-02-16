# Domino

[![Join the chat at https://gitter.im/scalajs-domino/Lobby](https://badges.gitter.im/scalajs-domino/Lobby.svg)](https://gitter.im/scalajs-domino/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Domino is a library for declarative HTML rendering in Scala.js.

## Example

```scala
import domino.HTML
import org.scalajs.dom.document

object App {
  import HTML._

  def main(args: Array[String]): Unit = {
    val root = document.getElementById("root")
    DominoDOM.render(h1("Hello, world!"), root)
  }
}
```

## Install
Add the following to your `build.sbt`.

	resolvers += "jitpack" at "https://jitpack.io"
	
	lazy val dominoVersion = "0.4.0"
	
	// JVM
	libraryDependencies += "com.github.scalacode.domino" %% "domino-core" % dominoVersion

	// Scala.js
    libraryDependencies ++= Seq(
      "com.github.scalacode.domino" %%% "domino-core" % dominoVersion,
      "com.github.scalacode.domino" %%% "domino-dom" % dominoVersion)
      
## Getting Started
### Hello, world!
```scala
import org.scalajs.dom.document

object App {
  def main(args: Array[String]): Unit = {
    import domino.HTML._
    
    val html = h1("Hello, world!")
    val root = document.getElementById("root")
    DominoDOM.render(html, root)
  }
}
```

Import the ScalaJS document to acquire components, and import `domino.HTML._` in the function where you render HTML (importing all members of HTML at the top of your file will likely cause namespace collisions). DominoDOM.render will render your HTML to the element you pass in, typically your root node. 

### Components

```scala
import org.scalajs.dom.document
import domino.Component
import domino.HTML

case class Header(title: String) extends Component {
  override def render = {
    import HTML._
    
    h1(title)
  }
}

case class App() extends Component {
  override def render = {
    import HTML._
    
    div(Header(), p("I'm the description..."))
  }
}

object App {
  def main(args: Array[String]): Unit = {
    import HTML._
    
    val root = document.getElementById("root")
    DominoDOM.render(App(), root)
  }
}
```

Components generate elements based on parameters. If the DOM is re-rendered, components whose parameters are identical are not re-rendered. 
