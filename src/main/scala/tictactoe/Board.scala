package com.blogspot.nhu313.tictactoe

import scala.collection.mutable.ListBuffer

class Board(val size: Int) {
	val squares = new Array[Char](size*size)
  val emptyValue = 0.toChar

  override def clone(): Board = {
    val board = new Board(size)
    val clone_squares = board.squares
    for (i <- 0 until squares.length) {
      clone_squares(i) = squares(i)
    }
    return board
  }

  def clear(position: Int) {
    squares(position) = emptyValue
  }

  def availableMoves(): ListBuffer[Int] = {
    val moves = ListBuffer[Int]()
    for (i <- 0 until squares.length) {
      if (squares(i) == emptyValue) {
        moves += i
      }
    }
    return moves
  }

  def mark(position: Int, marker: Char) {
    squares(position) = marker
  }

  def isFull(): Boolean = {
    !squares.contains(emptyValue)
  }

  def rows(): Array[Array[Char]] = {
    squares.grouped(size).toArray
  }

  def columns(): Array[Array[Char]] = {
    val last_index = squares.length - 1
    0.to(size - 1).map(col =>
      col.to(last_index, size).map(row => squares(row)).toArray
    ).toArray
  }

  def diagonals(): Array[Array[Char]] = {
    Array(topLeftDiagonal, topRightDiagonal)
  }

  private def topLeftDiagonal(): Array[Char] = {
    0.to(squares.size, size + 1).map(squares(_)).toArray
  }

  private def topRightDiagonal(): Array[Char] = {
    val last_col_index = size - 1
    val diagonal_indexes = last_col_index.to(last_col_index * size, last_col_index)
    diagonal_indexes.map(squares(_)).toArray
  }
}
