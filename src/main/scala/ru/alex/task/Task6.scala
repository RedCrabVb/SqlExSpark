package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}

class Task6(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    //SELECT DISTINCT p.maker, l.speed
    //FROM laptop l
    //JOIN product p ON p.model = l.model
    //WHERE l.hd >= 10

    val laptopDF = tableLoad("public.laptop")
    val productDF = tableLoad("public.product")

    import spark.sqlContext.implicits._

    laptopDF
      .as("l")
      .join(productDF.as("p"), $"p.model" === $"l.model")
      .select("p.maker", "l.speed")
      .where("l.hd >= 10")
  }
}
