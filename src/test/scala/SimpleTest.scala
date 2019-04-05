
// BDD


import DataVectis.Transaction_Client.Prop
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter



class SimpleTest extends FunSuite with BeforeAndAfter {
  before {
    println("Checking properties")
  }

  test(" Test PROP  ") {
    val p = new Prop()
    println(    p.getProperty("NOM_USER")  )

    assert(p.getProperty("NOM_USER") == "Zeineb")

  }

  after{
    println( "test completed")
  }

}

