package com.blogspot.nhu313.tictactoe

class Board(val size: Int) {
	val squares = Array.fill(size*size){Marker.NONE}
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

  def isValidMove(move: Int): Boolean = {
    if (move < 0 || move >= squares.length){
      return false
    }
    return squares(move) == Marker.NONE
  }

  def clear(position: Int) {
    squares(position) = Marker.NONE
  }

  def availableMoves(): Seq[Int] = {
    for {
      i <- 0 to last_square
      if squares(i) == Marker.NONE
    } yield i
  }

  def mark(position: Int, marker: Marker) {
    squares(position) = marker
  }

  def isFull(): Boolean = {
    !squares.contains(Marker.NONE)
  }

  def rows(): Array[Array[Marker]] = {
    squares.grouped(size).toArray
  }

  def columns(): Array[Array[Marker]] = {
    0.to(last_column).map(col =>
      col.to(last_square, size).map(row => squares(row)).toArray
    ).toArray
  }

  def diagonals(): Array[Array[Marker]] = {
    Array(topLeftDiagonal, topRightDiagonal)
  }

  private def topLeftDiagonal(): Array[Marker] = {
    0.to(squares.size, size + 1).map(squares(_)).toArray
  }

  private def topRightDiagonal(): Array[Marker] = {
    val diagonal_indexes = last_column.to(last_column * size, last_column)
    diagonal_indexes.map(squares(_)).toArray
  }

}
