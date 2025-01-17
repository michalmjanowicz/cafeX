object TillSystem {
  case class MenuItem(
                       name: String,
                       price: Double,
                       isFood: Option[Boolean] = None,
                       isHotFood: Option[Boolean] = None)

  val menu: List[MenuItem] = List(
    MenuItem("Cola", 0.50),
    MenuItem("Coffee", 1.00),
    MenuItem("Cheese sandwich", 2.00, Some(true)),
    MenuItem("Steak sandwich", 4.50, Some(true), Some(true))
  )

  def calculatePrice(items: List[MenuItem]): Double = {
    items.map(_.price).sum
  }

  def calculatePriceWithTip(items: List[MenuItem]): Double = {
    val priceWithNoTip = calculatePrice(items)
    val hasHotFood = items.exists(_.isHotFood.getOrElse(false))
    val hasFood = items.exists(_.isFood.getOrElse(false))
    val tipPercent = if (hasHotFood) 0.2 else if (hasFood) 0.1 else 0.0
    val totalTip = priceWithNoTip * tipPercent
    val finalTip = if (totalTip > 20) 20 else totalTip

    priceWithNoTip + finalTip
  }
}
