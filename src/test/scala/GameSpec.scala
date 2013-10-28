package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

import com.blogspot.nhu313.tictactoe.player.MockPlayer

class GameSpec extends FunSpec with BeforeAndAfter with MustMatchers{
  var io: MockIO = null
  var game: Game = null
  var board: Board = null
  val player1 = MockPlayer.create(Marker.X)
  val player2 = MockPlayer.create(Marker.O)

  before{
    io = new MockIO
    IO.io = io
    game = new Game(Array[Player](player1, player2))
    board = game.board
  }

  describe("Game over"){
    it("displays winner when there is one"){
      BoardStateHelper.setWinner(board, player1)
      game.play
      io.contents must include ("MockPlayer(X) wins!")
    }

    it("displays the board when the game ends"){
      BoardStateHelper.setWinner(board, player1)
      val expectedBoard = " | X | X | X |\n | 3 | 4 | 5 |\n | 6 | 7 | 8 |\n"
      game.play
      io.contents must include (expectedBoard)
    }

    it("displays draw when there is no winner"){
      BoardStateHelper.setDraw(board)
      game.play
      io.contents must include ("Draw")
    }
  }

  describe("Play game"){
    it("asks player1 to make a move"){
      addMovesToEndGame
      game.play
      io.contents must include ("MockPlayer(X), please select a square:")
    }

    it("asks player2 to make a move"){
      addMovesToEndGame
      game.play
      io.contents must include ("MockPlayer(O), please select a square:")
    }

    it("asks player2 to move after player one"){
      val player1TurnContent = "MockPlayer(X), please select a square:"
      val player2TurnContent = "MockPlayer(O), please select a square:"
      addMovesToEndGame
      game.play
      assert(io.contents.indexOf(player2TurnContent) > io.contents.indexOf(player1TurnContent))
    }

    it("displays an empty board"){
      val expectedBoard = " | 0 | 1 | 2 |\n | 3 | 4 | 5 |\n | 6 | 7 | 8 |\n"
      addMovesToEndGame
      game.play
      io.contents must include (expectedBoard)
    }

    it("displays marked board"){
      val expectedBoard = " | X | X | X |\n | O | O | 5 |\n | 6 | 7 | 8 |\n"
      addMovesToEndGame
      game.play
      io.contents must include (expectedBoard)
    }

    def addMovesToEndGame(){
      player1.addMoves(0, 1, 2)
      player2.addMoves(3, 4)
    }
  }
}
