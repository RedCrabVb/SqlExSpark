package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}

class Task3(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    //select model, ram, screen from Laptop where price > 1000
      tableLoad("public.Laptop")
        .select("model", "ram", "screen")
        .where("price> 1000")
  }
}
