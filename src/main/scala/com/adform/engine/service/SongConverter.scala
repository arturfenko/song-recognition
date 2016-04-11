package com.adform.engine.service

import com.adform.engine.domain.Song
import com.adform.engine.model.SongDataModel
import com.adform.engine.utils.EngineUtils

class SongConverter {
  def convert(song: Song) : SongDataModel = {
    SongDataModel(song.singer, song.title, EngineUtils.convertToTokenSet(song.lyric))
  }
}