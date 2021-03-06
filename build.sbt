ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.1"
libraryDependencies += "org.postgresql" % "postgresql" % "42.3.6"


lazy val root = (project in file("."))
  .settings(
    name := "SqlExSpark"
  )
