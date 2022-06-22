package ru.alex

import org.apache.spark.sql.SparkSession
import ru.alex.task.{Task1, TaskTestCreateDataFrame}

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    implicit val spark = SparkSession.builder()
      .master("local[1]")
      .appName("SqlExSpark")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    new Task1().make.show()
    new TaskTestCreateDataFrame().make().show()
  }
}
