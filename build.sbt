ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "Office-Management"
  )


libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.4.6",
  "org.scalatest" %% "scalatest" % "3.2.15" % Test,
  "org.scalatestplus" %% "mockito-4-6" % "3.2.15.0" % "test",
  "org.postgresql" % "postgresql" % "42.5.4",
  "com.typesafe" % "config" % "1.4.2"
)

coverageExcludedPackages := "<empty>;/home/knoldus/Scala Assignment-KUP/Office-Management/src/main/scala/com/Nastech/app\\..*"