ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "Office-Management"
  )


libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
libraryDependencies += "org.scalatestplus" %% "mockito-4-6" % "3.2.15.0" % "test"

libraryDependencies += "org.postgresql" % "postgresql" % "42.5.4"

libraryDependencies += "com.typesafe" % "config" % "1.4.2"