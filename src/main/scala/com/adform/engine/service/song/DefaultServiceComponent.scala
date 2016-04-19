package com.adform.engine.service.song

import com.adform.engine.repository.RepositoryComponent

trait DefaultServiceComponent[A] extends ObjectServiceComponent[A] {
    this: RepositoryComponent[A] =>

    def objectService = new DefaultObjectService

    class DefaultObjectService extends ObjectService {
      def findAll = objectLocator.findAll

      def save(item: A) {
        objectUpdater.save(item: A)
      }
    }
}