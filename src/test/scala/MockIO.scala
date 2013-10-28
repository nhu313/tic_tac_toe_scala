package com.blogspot.nhu313.tictactoe

import scala.collection.mutable.ListBuffer

class MockIO extends IO {
  var contents = ""
  var inputInteger = ListBuffer[Int]()

  def display(content: String){
    contents = contents + content
  }

  def readInteger(): Int = {
    if (inputInteger.isEmpty){
      inputInteger += 1
    }
    inputInteger.remove(0)
  }

  def hasContent(content: String): Boolean = {
    contents.indexOf(content) != -1
  }

  def addInputInteger(number: Int){
    inputInteger += number
  }
}
