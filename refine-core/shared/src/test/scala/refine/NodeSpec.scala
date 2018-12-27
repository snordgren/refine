package refine

final class NodeSpec extends UnitSuite {
  test("the class property should be associative") {

    val first = Node.Element[Unit]("div", Seq(DSL.className("first second")), Seq.empty,
      closingTag = true)

    val second = Node.Element[Unit]("div", Seq(DSL.className("first"), DSL.className("second")),
      Seq.empty, closingTag = true)

    val expectedProperty = DSL.className[Unit]("first second")

    first.properties.head should be(expectedProperty)
    first.properties.length should be(1)
    second.properties.head should be(expectedProperty)
    second.properties.length should be(1)
  }
}
