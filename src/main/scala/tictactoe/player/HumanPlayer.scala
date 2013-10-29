package com.blogspot.nhu313.tictactoe.player

import com.blogspot.nhu313.tictactoe.{Board, Player, Marker, IO}

class HumanPlayer(val name: String, val marker: Marker) extends Player {
  private val io = IO()

  def move(board: Board): Int = {
    var move = io.readInteger()
    while (!board.isValidMove(move)){
      io.display("Invalid move. Please select another move.")
      move = io.readInteger()
    }
    return move
  }
}
