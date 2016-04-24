package com.adform.engine.repository.impl

import com.adform.engine.repository.RepositoryComponent
import com.adform.engine.repository.storage.InMemoryStorage

trait RepositoryInMemoryComponent[A] extends RepositoryComponent[A] {
  val storage: InMemoryStorage[A]
  def objectLocator = new InMemoryObjectLocator(storage)
  def objectUpdater = new InMemoryObjectUpdater(storage)

  class InMemoryObjectLocator(storage: InMemoryStorage[A]) extends ObjectLocator {
    def findAll = storage.findAll()
  }

  class InMemoryObjectUpdater(storage: InMemoryStorage[A]) extends ObjectUpdater {
    def save(item: A) = storage.add(item)
  }
}