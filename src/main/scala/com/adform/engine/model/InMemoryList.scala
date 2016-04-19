package com.adform.engine.model

import com.adform.engine.domain.Song

import scala.collection.immutable.HashSet

class InMemoryList {
  var songs = new HashSet[Song]
  def add(song: Song) = songs += song
  def findAll() : Set[Song] = songs
}