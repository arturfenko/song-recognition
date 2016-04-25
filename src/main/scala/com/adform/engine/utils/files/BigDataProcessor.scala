package com.adform.engine.utils.files

import java.io.File

import akka.actor.ActorSystem
import akka.stream.ActorFlowMaterializer
import akka.stream.io._
import akka.stream.scaladsl._

/*USAGE

val file = new File("data\\mxm_dataset_train.txt")
BigDataProcessor.processFile(file, SynchronousFileSource.DefaultChunkSize)
*/

object BigDataProcessor {
  implicit val system = ActorSystem("Sys")
  implicit val materializer = ActorFlowMaterializer()

  def processFile(file: File, chunkSize: Int): Unit = {
    val fileSource = SynchronousFileSource(file, chunkSize)
    val flow = fileSource.map(chunk => chunk.utf8String)
    flow.to(Sink.foreach(processChunk(_))).run
  }

  //TODO implement chunk processing
  var counter = 0
  def processChunk(chunk: String): Unit = {
    counter = counter + 1
    println(counter)
  }
}