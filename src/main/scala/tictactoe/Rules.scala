package com.blogspot.nhu313.tictactoe

class Rules {

  def isGameOver(board: Board): Boolean = {
    return winner(board) != None || board.isFull
  }

  def winner(board: Board): Option[Char] = {
    val winning_sets = sets(board)
    val result = winning_sets.find(x =>
      x.forall(marker => marker != board.emptyValue && marker == x.head)
    )
    return if (result == None) None else Some(result.head.head)
  }

  private def sets(board: Board): Array[Array[Char]] = {
    board.rows ++ board.columns ++ board.diagonals
  }
  // val squares = new Array[Char](size*size)
  //   private val emptyValue = 0
  //
  //   def availableMoves(): ListBuffer[Int] = {
  //     val moves = ListBuffer[Int]()
  //     for (i <- 0 until squares.length) {
  //       if (squares(i) == emptyValue) {
  //         moves += i
  //       }
  //     }
  //     return moves
  //   }
  //
  //   def mark(position: Int, marker: Char) {
  //     squares(position) = marker
  //   }
}


// defmodule Rules do
//
//   def game_over?(board) do
//     winner(board) || Board.full?(board)
//   end
//
//   def winner(board) do
//     winning_set = Enum.find(sets(board), &winner_in_set(&1))
//     if winning_set, do: hd(winning_set)
//   end
//
//   defp winner_in_set(set) do
//     Enum.all?(set, &(&1 && &1 == hd(set)))
//   end
//
//   defp sets(board) do
//     Board.rows(board) ++ Board.columns(board) ++ Board.diagonals(board)
//   end
// end
