package com.adform.engine

import com.adform.engine.domain.Song
import com.adform.engine.service.{JaccardIndexService, SongConverter}
import com.adform.engine.utils.FileUtils

object Launcher {
  val converter = new SongConverter()
  val jaccardIndexService = new JaccardIndexService()

  def main(args: Array[String]): Unit = {
    val separator = System.getProperties.get("file.separator")

    val fileName1 = "Singer1 - Title1.txt"
    val singer1 = fileName1.split("-")(0).trim
    val title1 = fileName1.split("-")(1).trim

    val fileName2 = "Singer2 - Title2.txt"
    val singer2 = fileName2.split("-")(0).trim
    val title2 = fileName2.split("-")(1).trim

    val firstFileContent = FileUtils.readFileToString("data" + separator + fileName1)
    val secondFileContent = FileUtils.readFileToString("data" + separator + fileName2)

    val first = converter.convert(Song(singer1, title1, firstFileContent.getOrElse("")))
    val second = converter.convert(Song(singer2, title2, secondFileContent.getOrElse("")))

    println(jaccardIndexService.getIndex(first, second))
  }
}