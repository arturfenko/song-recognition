name := "TextRecognitionEngine"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.9",
  "com.typesafe.akka" %% "akka-stream-experimental" % "1.0-RC3"
)