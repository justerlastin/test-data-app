enablePlugins(GatlingPlugin)

name := "load-tests"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.0.1.1" % "test,it"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.0.1" % "test,it"