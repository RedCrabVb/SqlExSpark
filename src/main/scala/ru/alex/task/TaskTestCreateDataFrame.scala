package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}

class TaskTestCreateDataFrame(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    val dataList = Array(("java", 2000),
      ("Python", 94834),
      ("Scala", 9824))

    val dataListColumn = Seq("Language", "Number")

    val df = spark.createDataFrame(dataList).toDF(dataListColumn: _*)

    df
  }
}
