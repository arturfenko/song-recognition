package com.adform.engine.repository

import com.adform.engine.domain.Song

trait SongRepositoryComponent {
  def songLocator : SongLocator
  def songUpdater : SongUpdater

  trait SongLocator {
    def findAll: Set[Song]
  }

  trait SongUpdater {
    def save(song: Song)
  }
}