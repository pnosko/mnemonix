import android.Keys._

android.Plugin.androidBuild

name := "mnemonix"

scalaVersion := "2.11.1"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "jcenter" at "http://jcenter.bintray.com"
)

proguardCache in Android ++= Seq(
  ProguardCache("org.macroid") % "org.macroid"
)

proguardOptions in Android ++= Seq("-dontobfuscate", "-dontoptimize", "-dontwarn scala.collection.mutable.**", "-ignorewarnings", "-keep class scala.Dynamic")

proguardOptions in Android ++= Seq(
  "-keep class akka.actor.Actor$class { *; }",
  "-keep class akka.actor.LightArrayRevolverScheduler { *; }",
  "-keep class akka.actor.LocalActorRefProvider { *; }",
  "-keep class akka.actor.CreatorFunctionConsumer { *; }",
  "-keep class akka.actor.TypedCreatorFunctionConsumer { *; }",
  "-keep class akka.dispatch.BoundedDequeBasedMessageQueueSemantics { *; }",
  "-keep class akka.dispatch.UnboundedMessageQueueSemantics { *; }",
  "-keep class akka.dispatch.UnboundedDequeBasedMessageQueueSemantics { *; }",
  "-keep class akka.dispatch.DequeBasedMessageQueueSemantics { *; }",
  "-keep class akka.dispatch.MultipleConsumerSemantics { *; }",
  "-keep class akka.actor.LocalActorRefProvider$Guardian { *; }",
  "-keep class akka.actor.LocalActorRefProvider$SystemGuardian { *; }",
  "-keep class akka.dispatch.UnboundedMailbox { *; }",
  "-keep class akka.actor.DefaultSupervisorStrategy { *; }",
  "-keep class macroid.akkafragments.AkkaAndroidLogger { *; }",
  "-keep class akka.event.Logging$LogExt { *; }"
)

libraryDependencies ++= Seq(
  "org.scaloid" %% "scaloid" % "3.4-10",
  "org.macroid" %% "macroid" % "2.0.0-M2",
  "org.macroid" %% "macroid-akka-fragments" % "2.0.0-M2",
  "com.typesafe.akka" %% "akka-actor" % "2.3.3",
  "com.netflix.rxjava" % "rxjava-scala" % "0.19.0",
  compilerPlugin("org.brianmckenna" %% "wartremover" % "0.10")
)

scalacOptions in Compile += "-feature"

run <<= run in Android

install <<= install in Android
