package com.blogspot.nhu313.tictactoe.player

import com.blogspot.nhu313.tictactoe.{Board, Player}

class Human(val name: String, val marker: Char) extends Player {

  def move(board: Board): Int = readInt()

}
