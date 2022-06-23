package ru.alex

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.storage.StorageLevel
import ru.alex.task._

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    implicit val spark = SparkSession.builder()
      .master("local[1]")
      .appName("SqlExSpark")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    val df: DataFrame = new Task6().make

    df.persist(StorageLevel.DISK_ONLY)

    saveDF(df, "parquet", "snappy")
  }
}
