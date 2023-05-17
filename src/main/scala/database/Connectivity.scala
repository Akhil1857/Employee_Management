package database

import java.sql.DriverManager

object Connection {
  val url = "jdbc:postgresql://localhost:5432/organizationdetails"
  val username = "postgres"
  val password = "knoldus"

  val connection = DriverManager.getConnection(url, username, password)


}
