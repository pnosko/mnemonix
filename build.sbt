import android.Keys._

android.Plugin.androidBuild

name := "mnemonix"

scalaVersion := "2.11.0"

proguardCache in Android ++= Seq(
  ProguardCache("org.scaloid") % "org.scaloid"
)

proguardOptions in Android ++= Seq("-dontobfuscate", "-dontoptimize", "-dontwarn scala.collection.mutable.**")

libraryDependencies ++= Seq(
  "org.scaloid" %% "scaloid" % "3.4-10",
  "com.netflix.rxjava" % "rxjava-scala" % "0.19.0"
)

scalacOptions in Compile += "-feature"

run <<= run in Android

install <<= install in Android
