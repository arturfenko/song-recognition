package com.adform.engine.service.song

import com.adform.engine.domain.Song
import com.adform.engine.repository.SongRepositoryComponent

trait DefaultSongServiceComponent extends SongServiceComponent {
    this: SongRepositoryComponent =>

    def songService = new DefaultSongService

    class DefaultSongService extends SongService {
      def findAll = songLocator.findAll

      def save(song: Song) {
        songUpdater.save(song: Song)
      }
    }
}