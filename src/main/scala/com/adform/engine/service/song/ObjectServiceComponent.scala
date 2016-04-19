package com.adform.engine.service.song

trait ObjectServiceComponent[A] {
  def objectService: ObjectService

  trait ObjectService {
    def findAll: Seq[A]
    def save(item: A)
  }
}