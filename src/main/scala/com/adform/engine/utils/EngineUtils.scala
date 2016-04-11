package com.adform.engine.utils

object EngineUtils {
  //delete all non-latin symbols, then split the string to the set of tokens
  def convertToTokenSet(text: String) : Set[String] = {
    text.replaceAll("[^A-Za-z]", "").toLowerCase.sliding(Constants.SearchModelDimension, Constants.SearchModelStep).toSet
  }
}