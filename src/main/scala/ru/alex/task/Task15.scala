package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}

class Task15(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    //select hd from pc group by hd having count(hd) > 1

    tableLoad("pc").groupBy("hd").count().where("count > 1")
  }
}
