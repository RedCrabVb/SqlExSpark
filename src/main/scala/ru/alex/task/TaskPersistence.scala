package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.storage.StorageLevel

class TaskPersistence(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    val df = spark.read.option("header", "true").csv("./input/archive/russian_news.csv")

    df.persist(StorageLevel.MEMORY_ONLY)
  }
}
