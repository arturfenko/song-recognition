package com.adform.engine.model

import com.adform.engine.domain.Song

import scala.collection.mutable

class InMemoryList {
  val songs = new mutable.HashSet[Song]
  def add(song: Song) = songs += song
  def findAll() : mutable.HashSet[Song] = songs
}