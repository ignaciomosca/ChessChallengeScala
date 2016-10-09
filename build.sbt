name := "ChessChallengeScala"

version := "1.0"

scalaVersion := "2.11.8"

connectInput in run := true

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test"

javaOptions += "-XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -Xmx4g"
