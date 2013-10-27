package com.blogspot.nhu313.tictactoe

class Rules {

  def isGameOver(board: Board): Boolean = {
    return winner(board) != None || board.isFull
  }

  def winner(board: Board): Option[Marker] = {
    val winning_sets = sets(board)
    val result = winning_sets.find(x =>
      x.forall(marker => marker != Marker.NONE && marker == x.head)
    )
    return if (result == None) None else Some(result.head.head)
  }

  private def sets(board: Board): Array[Array[Marker]] = {
    board.rows ++ board.columns ++ board.diagonals
  }
}
