package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}

class Task2(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    //SELECT DISTINCT maker
    //FROM Product
    //WHERE type = 'printer'

    tableLoad("public.Product")
      .select("maker")
      .where("type == 'Printer'")
      .distinct()
  }
}
