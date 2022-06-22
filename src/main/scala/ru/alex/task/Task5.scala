package ru.alex.task

import org.apache.spark.sql.{DataFrame, SparkSession}

class Task5(implicit spark: SparkSession) extends Task(spark) {
  override def make(): DataFrame = {
    //select distinct model, speed, hd from PC where (cd = '12x' or cd = '24x') and price < 600

    tableLoad("public.PC")
      .where("(cd == '12x' or cd == '24x') and price < 600")
      .select("model", "speed", "hd")
      .distinct()
  }
}
