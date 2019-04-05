package DataVectis.Transaction_Client


import org.apache.spark.sql.SparkSession




object bank {

  def main(args: Array[String]): Unit = {


    // SparkSession connexion

    val spark = SparkSession.builder
      .master("local")
      .appName("data-exploration")
      .getOrCreate()

    val prop = new Prop()

    println(prop.getProperty("PATH_HDFS_CLIENT_Input"))
    println(prop.getProperty("PATH_HDFS_Transaction_Input"))
    println(prop.getProperty("PATH_HDFS_OUTPUT"))
    println(prop.getProperty("NOM_TABLE"))

    // Import Data client and Data Transaction


    val client = spark.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .option("delimiter", ";")
      .load(prop.getProperty("PATH_HDFS_CLIENT_Input"))

    client.printSchema
    client.show()

    val transaction = spark.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .option("delimiter", ";")
      .load(prop.getProperty("PATH_HDFS_Transaction_Input"))
    transaction.printSchema
    transaction.show()


    //  Join Data
    val jointure = client.join(transaction, client("id") === transaction("id_client"))
    jointure.show()

    // Detect all the client whi have a credit, number of transaction > 100 ay night, with their name and address

    val df = jointure.filter( "type_operation == 'Credit' ").filter("time == 'PM' ").filter("number_transaction > 100 ")
    df.show()

    // Stock the data as a parquet

    //df.write.parquet("DataFrame.parquet")





  }

}




