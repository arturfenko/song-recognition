package com.adform.engine.utils

import org.slf4j.LoggerFactory

import scala.io.Source

object FileUtils {
  val logger = LoggerFactory.getLogger(this.getClass)

  def readFileToString(filename: String) : Option[String] = {
    val file = Source.fromFile(filename)
    try {
      Some(file.mkString)
    } catch {
      case e: Exception =>
        logger.error("Unable to read the file", e)
        None
    } finally {
      file.close()
    }
  }
}