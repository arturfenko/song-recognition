package com.adform.engine.service

import com.adform.engine.model.SongDataModel

class JaccardIndexService {
  def getIndex(first: SongDataModel, second: SongDataModel) : Double = {
    val intersections = first.tokens.intersect(second.tokens).size.toDouble
    intersections / (first.tokens.size + second.tokens.size - intersections)
  }
}