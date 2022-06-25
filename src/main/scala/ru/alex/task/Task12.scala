package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}

class Task12(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    //SELECT AVG(speed) FROM Laptop WHERE price > 1000

    tableLoad("Laptop").where("price > 1000").selectExpr("avg(speed)")
  }
}
