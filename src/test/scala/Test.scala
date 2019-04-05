
// TDD


import org.scalatest.FunSuite
import DataVectis.Transaction_Client.Prop

class  Test extends FunSuite {

  test("TEST PROP") {
    val p = new Prop()
    println(    p.getProperty("NOM_USER")  )

    assert(p.getProperty("NOM_USER") == "Zeineb")


  }

}

