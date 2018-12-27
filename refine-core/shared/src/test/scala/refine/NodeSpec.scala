package refine

final class NodeSpec extends UnitSuite {
  test("the class property should be associative") {
    import DSL._

    val first = div[Unit](className("first second"))()
    val second = div[Unit](className("first"), className("second"))()

    val expectedProperty = DSL.className[Unit]("first second")

    first.properties.head should be(expectedProperty)
    first.properties.length should be(1)
    second.properties.head should be(expectedProperty)
    second.properties.length should be(1)
  }
}
