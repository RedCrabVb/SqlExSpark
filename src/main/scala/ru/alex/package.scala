package ru

import org.apache.spark.sql.{DataFrame, SparkSession}


package object alex {

  def saveDF(dt: DataFrame, format: String, compression: String) =
    dt.coalesce(1)
      .write
      .partitionBy()
      .mode("overwrite")
      .format(format)
      .option("compression", compression)
      .mode("overwrite")
      .save(s"./out/file_${format}_${compression}")
}
