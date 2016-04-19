package com.adform.engine.repository.impl

import com.adform.engine.domain.Song
import com.adform.engine.model.InMemoryList
import com.adform.engine.repository.SongRepositoryComponent

trait SongRepositoryInMemoryComponent extends SongRepositoryComponent {
  val list: InMemoryList
  def songLocator = new InMemorySongLocator(list)
  def songUpdater = new InMemorySongUpdater(list)

  class InMemorySongLocator(list: InMemoryList) extends SongLocator {
    def findAll = list.findAll()
  }

  class InMemorySongUpdater(list: InMemoryList) extends SongUpdater {
    def save(song: Song) = list.add(song)
  }
}