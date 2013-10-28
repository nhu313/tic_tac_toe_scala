package com.blogspot.nhu313.tictactoe.player

import com.blogspot.nhu313.tictactoe.{Board, Player, Marker, IO}

class HumanPlayer(val name: String, val marker: Marker) extends Player {
  private val io = IO()

  def move(board: Board): Int = io.readInteger()
// need to check if move is valid
}
