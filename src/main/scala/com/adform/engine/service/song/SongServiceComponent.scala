package com.adform.engine.service.song

import com.adform.engine.domain.Song
import scala.collection.mutable

trait SongServiceComponent {
  def songService: SongService

  trait SongService {
    def findAll: mutable.Set[Song]

    def save(song: Song)
  }
}