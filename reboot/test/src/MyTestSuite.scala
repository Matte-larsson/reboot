import utest._

object MyTestSuite extends TestSuite {

  val tests = Tests {
    test("test 1") - {
      val dut = new MyTest()

      val r = dut.test(3)
      
      r ==> "test test test "
    }
  }
}