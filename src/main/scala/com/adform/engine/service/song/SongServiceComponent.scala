package com.adform.engine.service.song

import com.adform.engine.domain.Song

trait SongServiceComponent {
  def songService: SongService

  trait SongService {
    def findAll: Set[Song]

    def save(song: Song)
  }
}