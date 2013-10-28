package com.blogspot.nhu313.tictactoe

class ConsoleIO extends IO {
  def display(content: String){
    println(content)
  }

  def readInteger(): Int = {
    try{
      readInt()
    } catch {
      case e: NumberFormatException =>
        println("Unable to process the number. Please try again.")
        readInteger()
    }
  }

  def readString(): String = readLine()
}
