package com.adform.engine

import com.adform.engine.domain.Song
import com.adform.engine.repository.impl.RepositoryInMemoryComponent
import com.adform.engine.repository.storage.InMemoryStorage
import com.adform.engine.service.song.DefaultServiceComponent
import org.slf4j.LoggerFactory

object Launcher {
  val logger = LoggerFactory.getLogger(this.getClass)

  //create a component instance
  val songServiceComponent = new DefaultServiceComponent[Song] with RepositoryInMemoryComponent[Song] {
    val storage = new InMemoryStorage[Song]()
  }

  val songService = songServiceComponent.objectService

  def main(args: Array[String]): Unit = {
    val separator = System.getProperties.get("file.separator")

    //in-memory repository test
    val songService = Launcher.songService
    //save some songs via in-memory repository implementation
    songService.save(Song("singer1", "title1", "lyric1"))
    songService.save(Song("singer1", "title1", "lyric1"))
    //get songs
    val songs = songService.findAll
    logger.info("Songs: {}", songs)

    //----------------------------------------------------

  }
}