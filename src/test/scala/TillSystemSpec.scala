import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import TillSystem._

class TillSystemSpec extends AnyFlatSpec with Matchers {

  "System" should "calculate correct price of items" in {
    val items = List(
      MenuItem("Cola", 0.50),
      MenuItem("Coffee", 1.00),
      MenuItem("Cheese", 2.00)
    )
    val total = calculatePrice(items)
    total shouldBe 3.50
  }
}
