package com.blogspot.nhu313.tictactoe.mock

import scala.collection.mutable.ListBuffer
import com.blogspot.nhu313.tictactoe.IO

class MockIO extends IO {
  var contents = ""
  var inputInteger = ListBuffer[Int]()
  var inputString = ListBuffer[String]()

  def display(content: String){
    contents = contents + content
  }

  def readString(): String = {
    if (inputString.isEmpty){
      inputString += ""
    }
    inputString.remove(0)
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

  def addInputString(value: String){
    inputString += value
  }
}
