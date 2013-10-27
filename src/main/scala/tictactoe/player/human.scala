package com.blogspot.nhu313.tictactoe.player

import com.blogspot.nhu313.tictactoe.{Board, Player, Marker}

class Human(val name: String, val marker: Marker) extends Player {

  def move(board: Board): Int = readInt()
// need to check if move is valid
}
