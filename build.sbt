name := """scala-blog"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

retrieveManaged := true

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0-RC1" % Test,
  "info.cukes" % "cucumber-scala_2.11" % "1.2.4" % "test"
)


libraryDependencies += "pl.newicom" % "sbt-cucumber-integration_2.11" % "1.0.0"

libraryDependencies += "info.cukes" % "cucumber-junit" % "1.2.3"
libraryDependencies += "junit" % "junit" % "4.12"

libraryDependencies += "org.webjars.bower" % "semantic-ui" % "2.1.8"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
