package DataVectis.Transaction_Client

import java.io.FileInputStream
import java.util.Properties

class Prop {

  def getProperty(propertyName:String): String ={

    val properties = new Properties()
    properties.load(new FileInputStream(  "Config" )  )

    val property = properties.getProperty(propertyName)

    property.toString
  }
}
