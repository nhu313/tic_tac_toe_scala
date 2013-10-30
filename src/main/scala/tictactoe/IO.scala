package com.blogspot.nhu313.tictactoe

trait IO {
  def display(content: String)
  def readInteger(): Int
  def readString(): String
}

object IO {
  def apply() = new ConsoleIO
}
