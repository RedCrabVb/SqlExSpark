package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}

class Task11(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    //select avg(speed) from pc

    tableLoad("pc").selectExpr("avg(price)")
  }
}
