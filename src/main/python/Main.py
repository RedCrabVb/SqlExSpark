from pyspark.sql import SparkSession

spark = SparkSession.builder \
        .appName("SqlExSparkPy") \
        .getOrCreate()

print(spark)
rdd = spark.sparkContext.parallelize([1,2,3,45])
print("count rdd")
print(rdd.count()) 

