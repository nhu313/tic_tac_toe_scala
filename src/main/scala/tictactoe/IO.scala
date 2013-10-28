package com.blogspot.nhu313.tictactoe

trait IO {
  def display(content: String)
  def readInteger(): Int
  def readString(): String
}

object IO {
  val io: IO = null

  def apply(): IO = if (io == null) new ConsoleIO() else io
}
