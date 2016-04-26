package com.adform.engine.utils.files

import java.io.File

import akka.actor.ActorSystem
import akka.stream.ActorFlowMaterializer
import akka.stream.io._
import akka.stream.scaladsl._

object BigDataProcessor {
  implicit val system = ActorSystem("Sys")
  implicit val materializer = ActorFlowMaterializer()

  def processFile(file: File, chunkSize: Int, process: String => Unit): Unit = {
    val fileSource = SynchronousFileSource(file, chunkSize)
    val flow = fileSource.map(chunk => chunk.utf8String)
    flow.to(Sink.foreach(process(_))).run
  }
}