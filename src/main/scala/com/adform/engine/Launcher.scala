package com.adform.engine

import com.adform.engine.domain.Song
import com.adform.engine.model.InMemoryStorage
import com.adform.engine.repository.impl.RepositoryInMemoryComponent
import com.adform.engine.service.song.DefaultServiceComponent
import com.adform.engine.service.{JaccardIndexService, SongConverter}
import com.adform.engine.utils.FileUtils
import org.slf4j.LoggerFactory

object Launcher {
  val logger = LoggerFactory.getLogger(this.getClass)

  val songServiceComponent = new DefaultServiceComponent[Song] with RepositoryInMemoryComponent[Song] {
    val storage = new InMemoryStorage[Song]()
  }

  val songService = songServiceComponent.objectService
  val converter = new SongConverter
  val jaccardIndexService = new JaccardIndexService

  def main(args: Array[String]): Unit = {
    //TODO: get rid of hardcoded reading, replacing it with repository implementation ------------------------------
    val separator = System.getProperties.get("file.separator")
    val singer1 = "Singer1"
    val title1 = "Title1"

    val singer2 = "Singer2"
    val title2 = "Title2"

    val firstFileContent = FileUtils.readFileToString("data" + separator + singer1 + " - " + title1 + ".txt")
    val secondFileContent = FileUtils.readFileToString("data" + separator + singer2 + " - " + title2 + ".txt")
    //--------------------------------------------------------------------------------------------------------------


    val songService = Launcher.songService
    //save some songs via in-memory repository implementation
    songService.save(Song(singer1, title1, firstFileContent.getOrElse("")))
    songService.save(Song(singer2, title2, secondFileContent.getOrElse("")))

    //get songs
    val songs = songService.findAll
    logger.info("Songs: {}", songs)

    //TODO compare songs by jaccard index
    val first = converter.convert(Song(singer1, title1, firstFileContent.getOrElse("")))
    val second = converter.convert(Song(singer2, title2, secondFileContent.getOrElse("")))

    logger.info("jaccard index: {}", jaccardIndexService.getIndex(first, second))
  }
}