package com.blogspot.nhu313.tictactoe

class ConsoleIO extends IO {
  def display(message: String){
    println(message)
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
}
