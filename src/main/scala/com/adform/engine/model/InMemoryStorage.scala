package com.adform.engine.model

import scala.collection.mutable.ListBuffer

class InMemoryStorage[A] {
  var items = ListBuffer[A]()
  def add(item: A) = items += item
  def findAll() : Seq[A] = items
}