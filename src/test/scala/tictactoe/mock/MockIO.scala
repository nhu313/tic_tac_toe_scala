package com.blogspot.nhu313.tictactoe.mock

import scala.collection.mutable.ListBuffer
import com.blogspot.nhu313.tictactoe.IO

class MockIO extends IO {
  private var _contents = new StringBuilder()
  var inputInteger = ListBuffer[Int]()
  var inputString = ListBuffer[String]()

  def display(content: String){
    _contents.append(content)
  }

  def contents = _contents.toString()

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

  def addInputInteger(number: Int){
    inputInteger += number
  }

  def addInputString(value: String){
    inputString += value
  }
}
