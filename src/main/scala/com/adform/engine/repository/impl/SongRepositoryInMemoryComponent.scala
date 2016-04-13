package com.adform.engine.repository.impl

import com.adform.engine.domain.Song
import com.adform.engine.repository.SongRepositoryComponent

trait SongRepositoryInMemoryComponent extends SongRepositoryComponent {
  val songs: Set[Song]
  def songLocator = new InMemorySongLocator(songs)
  def songUpdater = new InMemorySongUpdater(songs)

  class InMemorySongLocator(val songs: Set[Song]) extends SongLocator {
    def findAll = songs
  }

  class InMemorySongUpdater(var songs: Set[Song]) extends SongUpdater {
    def save(song: Song) = songs += song
  }
}