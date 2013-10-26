package com.blogspot.nhu313.tictactoe

class Board(val size: Int) {
	val squares = new Array[Char](size*size)
  val emptyValue = 0.toChar
  private val last_square = squares.length - 1
  private val last_column = size - 1

  override def clone(): Board = {
    val board = new Board(size)
    copySquareValues(board)
    return board
  }

  private def copySquareValues(cloneBoard : Board) {
    for (i <- 0 until squares.length) {
      cloneBoard.squares(i) = squares(i)
    }
  }

  def clear(position: Int) {
    squares(position) = emptyValue
  }

  def availableMoves(): Seq[Int] = {
    for {
      i <- 0 to last_square
      if squares(i) == emptyValue
    } yield i
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
    0.to(last_column).map(col =>
      col.to(last_square, size).map(row => squares(row)).toArray
    ).toArray
  }

  def diagonals(): Array[Array[Char]] = {
    Array(topLeftDiagonal, topRightDiagonal)
  }

  private def topLeftDiagonal(): Array[Char] = {
    0.to(squares.size, size + 1).map(squares(_)).toArray
  }

  private def topRightDiagonal(): Array[Char] = {
    val diagonal_indexes = last_column.to(last_column * size, last_column)
    diagonal_indexes.map(squares(_)).toArray
  }

}
