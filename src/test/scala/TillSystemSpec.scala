import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import TillSystem._

class TillSystemSpec extends AnyFlatSpec with Matchers {

  val cola: MenuItem =   MenuItem("Cola", 0.50)
  val coffee: MenuItem = MenuItem("Coffee", 1.00)
  val cheese: MenuItem = MenuItem("Cheese sandwich", 2.00, isFood = Option(true))
  val steak: MenuItem =  MenuItem("Steak sandwich", 4.5, isFood = Option(true), isHotFood = Option(true))

  "System" should "calculate correct price of items" in {
    val items = List(cola, coffee, cheese)
    val total = calculatePrice(items)
    total shouldBe 3.50
  }
  "System" should "calculate tip and final bill for drinks only" in {
    val items = List(coffee, cola)
    val total = calculatePriceWithTip(items)
    total shouldBe 1.5
  }
  "System" should "calculate tip and final bill for food" in {
    val items = List(coffee, cola, cheese)
    val total = calculatePriceWithTip(items)
    total shouldBe 3.85
  }
  "System" should "calculate tip and final bill for hot food" in {
    val items = List(steak, steak)
    val total = calculatePriceWithTip(items)
    total shouldBe 10.8
  }
  "System" should "calculate tip and final bill for hot food with tip cap" in {
    val items = List.fill(30)(steak) // should be 155

    val total = calculatePriceWithTip(items)
    total shouldBe 155
  }
}