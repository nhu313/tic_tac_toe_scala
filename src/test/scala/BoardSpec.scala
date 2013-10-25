package com.blogspot.nhu313.tictactoe

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.MustMatchers

class BoardSpec extends FunSpec with BeforeAndAfter with MustMatchers{
  val boardSize = 2
  var board: Board = null

  before {
    board = new Board(boardSize)
  }

  describe("Available squares") {

    it("has all the squares when the board is empty") {
      board.availableMoves must equal (List(0, 1, 2, 3))
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

    // it("when the square is taken")
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

  describe("Sets") {

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
     def mark_board_with_alphabet() {
       for (i <- 'a' until 'j') {
         board.mark(i - 'a', i)
       }
    }
  }

  def markboard(start:Int, end:Int){
    for (i <- start until end) {
      board.mark(i, 'x')
    }
  }

  def squares_size()= {
    boardSize * boardSize
  }
}
