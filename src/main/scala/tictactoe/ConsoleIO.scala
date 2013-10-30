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
        println("Please enter a number.")
        readInteger()
    }
  }

  def readString(): String = readLine()
}
