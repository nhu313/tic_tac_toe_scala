package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

class BoardSpec extends FunSpec with BeforeAndAfter with MustMatchers{
  var board: Board = null

  before {
    board = new Board(2)
  }

  describe("Available squares") {

    it("has all the squares when the board is empty") {
      board.availableMoves must equal (Seq(0, 1, 2, 3))
    }

    it("does not contain the square that is marked"){
      val move = 3
      board.mark(move, 'x')
      board.availableMoves must not (contain(move))
    }

    it("is empty when user marks all the squares"){
      markboard(0, squares_size)
      board.availableMoves must equal (List())
    }
  }

  describe("Marking the board") {

    it("marks the board with the value when the square is empty") {
      val move = 3
      board.mark(move, 'x')
      board.squares must equal (Array(0, 0, 0, 'x'))
    }

    // it("when the square is taken"){
    //   val move = 3
    //   board.mark(move, 'x') must throws(IllegalArgumentException)
    // }
    //it("when the move is under the lower bound limit")
    //it("when the move is over the greater bound limit")
  }

  describe("Full board") {
    it("when board is empty"){
      board must not be ('isFull)
    }

    it("is false when one square is marked"){
      board.mark(0, 'x')
      board must not be ('isFull)
    }

    it("is false when the board has one empty square") {
      markboard(0, (squares_size - 1))
      board must not be ('isFull)
    }

    it("is true when all the squares are marked"){
      markboard(0, squares_size)
      board must be ('isFull)
    }
  }

  describe("Sets for 2x2 board") {
    it("returns row values") {
      mark_board_with_alphabet
      board.rows must equal (Array(Array('a', 'b'),
                                   Array('c', 'd')))
    }

    it("returns values by column"){
      mark_board_with_alphabet
      board.columns must equal (Array(Array('a', 'c'),
                                      Array('b', 'd')))
    }

    it("returns diagonals"){
      mark_board_with_alphabet
      board.diagonals must equal (Array(Array('a', 'd'),
                                        Array('b', 'c')))
    }
  }

  describe("Sets for 3x3 board") {
    it("returns row values") {
      board = new Board(3)
      mark_board_with_alphabet
      board.rows must equal (Array(Array('a', 'b', 'c'),
                                   Array('d', 'e', 'f'),
                                   Array('g', 'h', 'i')))
    }

    it("returns values by column"){
      board = new Board(3)
      mark_board_with_alphabet
      board.columns must equal (Array(Array('a', 'd', 'g'),
                                      Array('b', 'e', 'h'),
                                      Array('c', 'f', 'i')))
    }

    it("returns diagonals"){
      board = new Board(3)
      mark_board_with_alphabet
      board.diagonals must equal (Array(Array('a', 'e', 'i'),
                                        Array('c', 'e', 'g')))
    }
  }

  describe("clone") {
    it("has the same size") {
      board.clone.size must equal (board.size)
    }

    it("squares of the clone are equals") {
      mark_board_with_alphabet
      board.clone.squares must equal (board.squares)
    }

    it("does not change the original squares when clone change") {
      val clone_board = board.clone
      clone_board.mark(0, 'x')
      board.squares(0) must not equal('x')
    }

  }

  def mark_board_with_alphabet() {
   for (i <- 0 until board.squares.length) {
     board.mark(i, (i + 'a').toChar)
   }
  }

  def markboard(start:Int, end:Int){
    for (i <- start until end) {
      board.mark(i, 'x')
    }
  }

  def squares_size()= {
    board.size * board.size
  }
}
