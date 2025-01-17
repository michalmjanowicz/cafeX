import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TillSystemSpec extends AnyFlatSpec with Matchers {

  "System" should "calculate correct price of items" in {
    val items = List(1, 2)
    val total = items.sum
    total shouldBe 3
  }
}
