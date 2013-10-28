package com.blogspot.nhu313.tictactoe.player

import com.blogspot.nhu313.tictactoe.{Board, Player, Marker, ConsoleIO}

class Human(val name: String, val marker: Marker) extends Player {
  private val io = new ConsoleIO()

  def move(board: Board): Int = io.readInteger()
// need to check if move is valid
}
