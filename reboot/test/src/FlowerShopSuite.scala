import utest._

object FlowerShopSuite extends TestSuite {

  val tests = Tests {
    test("test add") - {
      val fs = new FlowerShop()
      val fl = Flower("rose", 20.50, "red", 10)
      fs.addFlower(fl)

      fs.list().size ==> 1
    }
    test("test get") - {
      val fs = new FlowerShop()
      val fl = Flower("rose", 20.50, "red", 10)
      val add = fs.addFlower(fl)
      val r = fs.get(add).get

      r ==> fl
      fl.name ==> "rose"
    }
    test("test list") - {
      val fs = new FlowerShop()
      val r = fs.list()

      r.size ==> 0
    }
    test("test update ") - {
      val fs = new FlowerShop()
      val fl = Flower("rose", 20.50, "red", 10)
      val add = fs.addFlower(fl)
      val cpy = fs.get(add).get.copy(price = 30)
      fs.update(add, cpy)

      val r = fs.get(add).get.price

      r ==> 30
    }
    test("test buy ") - {
      val fs = new FlowerShop()
      val fl = Flower("rose", 20.50, "red", 10)
      val add = fs.addFlower(fl)

      val cost = fs.buy(add, 5)

      val r = cost

      r ==> 102.5
    }
    test("test delete ") - {
      val fs = new FlowerShop()
      val fl = Flower("rose", 20.50, "red", 10)
      val fl2 = Flower("ros", 20.50, "red", 10)
      val t = fs.addFlower(fl)
      fs.addFlower(fl2)
      fs.delete(t)

      val r = fs.list()

      r.size ==> 1
    }
  }
}
