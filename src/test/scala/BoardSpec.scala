package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers
import com.blogspot.nhu313.tictactoe.Marker._

class BoardSpec extends FunSpec with BeforeAndAfter with MustMatchers{
  var board: Board = null
  val playerMarker = X
  val opponentMarker = O

  before {
    board = new Board(2)
  }

  describe("Available squares") {

    it("has all the squares when the board is empty") {
      board.availableMoves must equal (Seq(0, 1, 2, 3))
    }

    it("does not contain the square that is marked"){
      val move = 3
      board.mark(move, playerMarker)
      board.availableMoves must not (contain(move))
    }

    it("is empty when user marks all the squares"){
      markboard(0, squareLength)
      board.availableMoves must equal (List())
    }
  }

  it("marks the board with the value passed in") {
    val move = 3
    board.mark(move, playerMarker)
    board.squares must equal (Array(NONE, NONE, NONE, playerMarker))
  }

  describe("Full board") {
    it("when board is empty"){
      board must not be ('isFull)
    }

    it("is false when one square is marked"){
      board.mark(0, Marker.X)
      board must not be ('isFull)
    }

    it("is false when the board has one empty square") {
      markboard(0, (squareLength - 1))
      board must not be ('isFull)
    }

    it("is true when all the squares are marked"){
      markboard(0, squareLength)
      board must be ('isFull)
    }
  }

  describe("Sets for 2x2 board") {
    it("returns row values") {
      markBoardWithDistinctSetFor2x2
      board.rows must equal (Array(Array(X,     O),
                                   Array(NONE,  O)))
    }

    it("returns values by column"){
      markBoardWithDistinctSetFor2x2
      board.columns must equal (Array(Array(X, NONE),
                                      Array(O, O)))
    }

    it("returns diagonals"){
      markBoardWithDistinctSetFor2x2
      board.diagonals must equal (Array(Array(X, O),
                                        Array(O, NONE)))
    }

    def markBoardWithDistinctSetFor2x2() {
      // X     O
      // NONE  O

      markboard(Array(0), X)
      markboard(Array(1, 3), O)
      markboard(Array(2), NONE)
    }
  }

  describe("Sets for 3x3 board") {
    it("returns row values") {
      board = new Board(3)
      markBoardWithDistinctSetFor3x3
      board.rows must equal (Array(Array(X,     O,   X),
                                   Array(NONE,  O,   X),
                                   Array(O,     X,  NONE)))
    }

    it("returns values by column"){
      board = new Board(3)
      markBoardWithDistinctSetFor3x3
      board.columns must equal (Array(Array(X,  NONE,   O),
                                      Array(O,   O,     X),
                                      Array(X,   X,    NONE)))
    }

    it("returns diagonals"){
      board = new Board(3)
      markBoardWithDistinctSetFor3x3
      board.diagonals must equal (Array(Array(X, O, NONE),
                                        Array(X, O, O)))
    }

    def markBoardWithDistinctSetFor3x3() {
      // X     O     X
      // NONE  O     X
      // O     X     NONE

      markboard(Array(0, 2, 5, 7), X)
      markboard(Array(1, 4, 6), O)
      markboard(Array(3, 8), NONE)
    }
  }

  describe("clone") {
    it("has the same size") {
      board.clone.size must equal (board.size)
    }

    it("squares of the clone are equals") {
      board.mark(0, playerMarker)
      board.mark(1, opponentMarker)
      board.clone.squares must equal (board.squares)
    }

    it("does not change the original squares when clone change") {
      val cloneBoard = board.clone
      cloneBoard.mark(0, playerMarker)
      board.squares(0) must not equal(playerMarker)
    }

  }

  describe("Valid move"){
    it("is valid when square is not mark"){
      assert(board.isValidMove(0))
    }

    it("is invalid when square is mark"){
      val move = 3
      board.mark(move, playerMarker)
      assert(board.isValidMove(move) == false)
    }

    it("is invalid when move is smaller than the first square"){
      assert(board.isValidMove(-1) == false)
    }

    it("is invalid when move is greater than the last square"){
      assert(board.isValidMove(squareLength) == false)
    }
  }

  def markboard(moves: Array[Int], marker: Marker){
    for(i <- moves){
      board.mark(i, marker)
    }
  }

  def markboard(start:Int, end:Int){
    for (i <- start until end) {
      board.mark(i, playerMarker)
    }
  }

  def squareLength = board.squares.length
}
