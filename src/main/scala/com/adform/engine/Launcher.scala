package com.adform.engine

import com.adform.engine.domain.Song
import com.adform.engine.repository.impl.SongRepositoryInMemoryComponent
import com.adform.engine.service.song.DefaultSongServiceComponent
import com.adform.engine.service.{JaccardIndexService, SongConverter}
import com.adform.engine.utils.FileUtils
import org.slf4j.LoggerFactory

object Launcher {
  val logger = LoggerFactory.getLogger(this.getClass)

  val songServiceComponent = new DefaultSongServiceComponent with SongRepositoryInMemoryComponent {
    var songs = Set()
  }

  val songService = songServiceComponent.songService
  val converter = new SongConverter
  val jaccardIndexService = new JaccardIndexService

  def main(args: Array[String]): Unit = {
    //TODO: get rid of hardcoded reading, replacing it with repository implementation ------------------------------
    val separator = System.getProperties.get("file.separator")
    val singer1 = "Singer1"
    val title1 = "Title1"

    val singer2 = "Singer2"
    val title2 = "Title1"

    val firstFileContent = FileUtils.readFileToString("data" + separator + singer1 + " - " + title1)
    val secondFileContent = FileUtils.readFileToString("data" + separator + singer2 + " - " + title2)
    //--------------------------------------------------------------------------------------------------------------


    val songService = Launcher.songService
    //save some songs via in-memory repository implementation
    songService.save(Song(singer1, title1, firstFileContent.getOrElse("")))
    songService.save(Song(singer2, title2, secondFileContent.getOrElse("")))

    //get songs
    val songs = songService.findAll
    logger.info("Songs: {}", songs)

    //TODO compare songs by jaccard index
/*  val first = converter.convert(Song(singer1, title1, firstFileContent.getOrElse("")))
    val second = converter.convert(Song(singer2, title2, secondFileContent.getOrElse("")))

    println(jaccardIndexService.getIndex(first, second))*/
  }
}