package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}

class Task10(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    //SELECT model, price FROM Printer WHERE price >= (SELECT MAX(price) FROM Printer)

    val printer = tableLoad("public.printer")

    printer.createOrReplaceTempView("printer")

    printer.select("model", "price").where("price >= (SELECT MAX(price) FROM printer)")
  }
}
