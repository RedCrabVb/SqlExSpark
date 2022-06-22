package ru.alex.task

import org.apache.spark.sql.{DataFrame, DataFrameReader, SparkSession}
import ru.alex.config.ConfigBD

abstract class Task(spark: SparkSession) extends ConfigBD {
  def make(): DataFrame

  protected def tableLoad(tableName: String): DataFrame = {
    spark.read
      .format(format)
      .option("driver", drive)
      .option("url", url)
      .option("user", user)
      .option("password", password)
      .option("dbtable", tableName)
      .load()
  }
}
