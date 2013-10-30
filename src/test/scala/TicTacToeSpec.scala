package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers
import org.scalatest.mock.EasyMockSugar

import com.blogspot.nhu313.tictactoe.mock.{MockIO, MockGameFactory}

class TicTacToeSpec extends FunSpec with EasyMockSugar with BeforeAndAfter with MustMatchers{
  var io: MockIO = null
  var mockGame: Game = null
  var mockGameFactory: MockGameFactory = null
  var ticTacToe: TicTacToe = null

  before{
    mockGame = mock[Game]
    mockGameFactory = new MockGameFactory(mockGame)
    io = new MockIO
    ticTacToe = new TicTacToe(mockGameFactory, io)
  }

  it("displays a welcome message"){
    ticTacToe.continue = "n"
    ticTacToe.start
    io.contents must include ("Let's play some Tic Tac Toe!")
  }

  describe("Game Types"){
    it("displays the game types"){
      io.addInputString("n")
      var gameTypeContent = "1 - Computer vs Computer\n2 - Computer vs Human\n3 - Human vs Computer\n4 - Human vs Human\n"
      ticTacToe.start
      io.contents must include (gameTypeContent)
    }

    it("informs user when the game type is invalid"){
      io.addInputInteger(-1)
      ticTacToe.start
      io.contents must include ("Invalid selection. Please select a type from the list")
    }

    it("asks for another game type if input is invalid"){
      val validType = 1
      io.addInputInteger(-1)
      io.addInputInteger(validType)
      ticTacToe.start
      mockGameFactory.gameTypes must (contain(validType))
    }
  }

  describe("Another Game"){
    it("asks if user wants to play another game"){
      io.addInputString("n")
      ticTacToe.start
      io.contents must include ("Would you like to play another game? (y/n)")
    }

    it("loads another game when user say yes"){
      io.addInputString("y")
      io.addInputString("n")
      ticTacToe.start
      mockGameFactory.gameTypes.size must equal (2)
    }

    it("doesn't load another game when user say no"){
      io.addInputString("n")
      ticTacToe.start
      mockGameFactory.gameTypes.size must equal (1)
    }
  }

  it("starts the game"){
    // mockGame.play
    // expectLastCall.atLeastOnce()
    // replay(mockGame)
    expecting {
      mockGame.play
      lastCall.times(1)
    }
    whenExecuting(mockGame) {
      ticTacToe.start
   }
   // verify(mockGame)
  }
}
