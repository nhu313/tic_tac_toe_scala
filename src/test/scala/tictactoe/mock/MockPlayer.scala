package com.blogspot.nhu313.tictactoe.mock

import com.blogspot.nhu313.tictactoe.{Player, Marker, Board}

class MockPlayer(val name: String, val marker: Marker) extends Player{
  var moves = Iterator[Int]()

  def addMoves(xmoves : Int*){
    moves = xmoves.toIterator
  }

  def move(board: Board): Int = {
    if (moves.isEmpty){
      return 0
    }
    moves.next
  }
}

object MockPlayer{
  def create(marker: Marker) = new MockPlayer("MockPlayer", marker)
}

