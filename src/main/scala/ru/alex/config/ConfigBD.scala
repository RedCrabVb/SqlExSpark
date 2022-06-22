package ru.alex.config

trait ConfigBD {
  val user = "username"
  val password = "password"
  val dbName = "computer"
  val format = "jdbc"
  val drive  = "org.postgresql.Driver"
  val url = "jdbc:postgresql://localhost:5432/computer"
}
