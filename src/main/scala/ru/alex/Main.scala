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


    val df: DataFrame = new TaskPersistence().make.persist(StorageLevel.DISK_ONLY)


    val df2 = df.union(df).union(df)
      .where("tags == 'Все'").select("title", "text")

    println(df2.persist())
    println("df2" + df2.count())
    println("df" + df.count())

    df2.show()

//    df.persist(StorageLevel.DISK_ONLY)

//    saveDF(df, "parquet", "snappy")
  }
}
