package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

class RulesSpec extends FunSpec with BeforeAndAfter with MustMatchers{
  var board: Board = null
  val rules = new Rules()
  val player = Marker.X
  val opponent = Marker.O

  before {
    board = new Board(2)
  }

  describe("Winner") {
    describe("no winner") {
      it("when board is empty") {
        rules.winner(board) must equal (None)
      }

      it("when the board is partially mark"){
        board.mark(0, player)
        rules.winner(board) must equal (None)
      }

      it("when player missed one square"){
        // x  x  0
        // x  0  x
        // 0  x  x

        board = new Board(3)
        markBoard(Array(0, 1, 3, 5, 7, 8), player)
        rules.winner(board) must equal (None)
      }

      it("when it's a draw"){
        board = new Board(3)
        BoardStateHelper.setDraw(board)
        rules.winner(board) must equal (None)
      }
    }

    describe("has a winner"){
      it("when player marks the first row"){
        markBoard(Array(0, 1), player)
        rules.winner(board) must equal (Some(player))
      }

      it("when player marks the last row"){
        markBoard(Array(2, 3), player)
        rules.winner(board) must equal (Some(player))
      }

      it("when player marks the first column"){
        markBoard(Array(0, 2), player)
        rules.winner(board) must equal (Some(player))
      }

      it("when player marks the last column"){
        markBoard(Array(1, 3), player)
        rules.winner(board) must equal (Some(player))
      }

      it("when player marks the diagonal from top left to right"){
        markBoard(Array(0, 3), player)
        rules.winner(board) must equal (Some(player))
      }

      it("when player marks the diagonal from right to left"){
        markBoard(Array(1, 2), player)
        rules.winner(board) must equal (Some(player))
      }
    }
  }

  describe("Game over") {
    it("is not over when the board is empty") {
      rules.isGameOver(board) must be (false)
    }

    it("is not over when there is a mark on the board"){
      board.mark(0, player)
      rules.isGameOver(board) must be (false)
    }

    it("is over when there is a winner"){
      markBoard(Array(0, 1), opponent)
      rules.isGameOver(board) must be (true)
    }

    it("is over when it's a draw"){
      board = new Board(3)
      BoardStateHelper.setDraw(board)
      rules.isGameOver(board) must be (true)
    }
  }

  private def markBoard(moves: Array[Int], marker: Marker){
    moves.foreach(board.mark(_, marker))
  }
}
