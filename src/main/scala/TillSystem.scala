object TillSystem   {
case class MenuItem(name: String, price: Double)

val menu: List[MenuItem] = List(
  MenuItem("Cola", 0.50),
  MenuItem("Coffee", 1.00),
  MenuItem("Cheese sandwich", 2.00),
  MenuItem("Steak sandwich", 4.50)
)

def calculatePrice(items: List[MenuItem]): Double = {
  items.map(_.price).sum
}
}