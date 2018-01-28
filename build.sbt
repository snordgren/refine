enablePlugins(ScalaJSPlugin)
name := "domino"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.2",
  "org.scalatest" %%% "scalatest" % "3.0.4" % Test
)
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.4"
scalacOptions ++= Seq("-language:implicitConversions")
scalaJSUseMainModuleInitializer := true

resourceGenerators in Compile += Def.task {
  import scala.io.Source
  val elementData = file("src/main/csv/ElementData.csv")

  def genElemFile(): String = {
    val header =
      raw"""package org.domino.html

sealed trait Node
final case class Text(value: String) extends Node
sealed trait Element[A <: Attribute] extends Node {
  def name: String
  def attributes: Seq[A]
  def children: Seq[Node]
  
  def nonErasedAttr: Seq[Attribute] = attributes
}

abstract class AbstractElement[A <: Attribute](val name: String) extends Element[A]
"""
    val body = Source.fromFile(elementData).getLines().drop(1)
      .map((line) => {
        val parts = line.split(",")
        val tag = parts.head
        val attr = parts(1)
        val name = parts(2)
        s"""
final case class ${name}Element(attributes: Seq[${attr}Attribute],
  children: Seq[Node]) extends AbstractElement[${attr}Attribute]("$tag")"""
      }).reduce((l, r) => s"$l\n$r")

    header + body
  }

  def genElemFactoryFile(): String = {
    val header =
      raw"""package org.domino.html

trait Elements {
  implicit def string2Text(s: String): Node = Text(s)
"""
    val footer = "}"
    val body: String = Source.fromFile(elementData).getLines().drop(1)
      .map((line) => {
        val parts = line.split(",")
        val tag = parts.head
        val attr = parts(1)
        val name = parts(2)
        s"""
  def $tag(attributes: ${attr}Attribute*)(children: Node*) =
    ${name}Element(attributes, children)
"""
      }).reduce((l: String, r: String) => l + r)

    header + body + footer
  }

  val elementFile = baseDirectory.value / "src/main/scala/org/domino/html/Element.scala"
  IO.write(elementFile, genElemFile().getBytes("UTF-8"))

  val elementsFile = baseDirectory.value / "src/main/scala/org/domino/html/Elements.scala"
  IO.write(elementsFile, genElemFactoryFile().getBytes("UTF-8"))

  Seq(elementFile, elementsFile)
}.taskValue
