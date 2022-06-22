package ru.alex.task
import org.apache.spark.sql.{DataFrame, SparkSession}

class Task1(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    //select model, speed, hd from PC p where p.price < 500
    val table: DataFrame = super.tableLoad(spark, "public.PC")

    table
      .select("model", "speed", "hd")
      .where("price < 500")
  }
}
