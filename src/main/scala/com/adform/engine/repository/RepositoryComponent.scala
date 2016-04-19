package com.adform.engine.repository

trait RepositoryComponent[A] {
  def objectLocator : ObjectLocator
  def objectUpdater : ObjectUpdater

  trait ObjectLocator {
    def findAll: Seq[A]
  }

  trait ObjectUpdater {
    def save(item: A)
  }
}