package com.blogspot.nhu313.tictactoe

object BoardStateHelper {

  def setWinner(board: Board, player: Player){
    markBoard(board, Array(0, 1, 2), player.marker)
  }

  def setDraw(board: Board){
    // o, x, o,
    // o, x, o,
    // x, o, x
    markBoard(board, Array(0, 2, 3, 5, 7), Marker.X)
    markBoard(board, Array(1, 4, 6, 8), Marker.O)
  }

  private def markBoard(board: Board, moves: Array[Int], marker: Marker){
    moves.foreach(board.mark(_, marker))
  }
}
