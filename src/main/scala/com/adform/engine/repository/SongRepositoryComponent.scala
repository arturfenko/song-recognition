package com.adform.engine.repository

import com.adform.engine.domain.Song

import scala.collection.mutable

trait SongRepositoryComponent {
  def songLocator : SongLocator
  def songUpdater : SongUpdater

  trait SongLocator {
    def findAll: mutable.Set[Song]
  }

  trait SongUpdater {
    def save(song: Song)
  }
}