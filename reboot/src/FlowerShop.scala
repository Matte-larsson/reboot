import java.util.UUID
case class Flower(name: String, price: Double, colour: String, stock: Int)
class FlowerShop {
  var flowers: Map[String, Flower] = Map.empty

  def createID() = UUID.randomUUID.toString()

//  def test(i: Int): String = "test " * i

  def addFlower(f: Flower): String = {
    val id = createID()
    flowers = flowers + (id -> f)
    id
  }
  def list(): List[Flower] = flowers.values.toList

  def get(id: String): Option[Flower] = {
    flowers.get(id)
  }
  def update(id: String, f: Flower): Unit = {
    flowers = flowers + (id -> f)
  }
  def buy(n: String, amount: Int): Double = {
    val f = get(n).get
    val newamount = f.stock - amount
    update(n, f.copy(stock = newamount))
    f.price * amount
  }
  def delete(f: String): Unit = {
    val taBortF = flowers.removed(f)
    flowers = taBortF
  }

}
