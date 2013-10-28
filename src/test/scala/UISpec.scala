package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

class ConsoleUISpec extends FunSpec with BeforeAndAfter with MustMatchers{
  var io: MockIO = null
  var board: Board = null
  var ui: UI = null

  before {
    board = new Board(2)
    io = new MockIO
    ui = new UI(io)
  }

  it("displays welcome message"){
    ui.displayWelcomeMessage
    io.contents must equal ("Let's play some Tic Tac Toe!\n")
  }

  it("displays the player turn") {
    val player = PlayerFactory.create("Human", Marker.X)
    ui.displayPlayerTurn(player)
    io.contents must equal ("Player(X), please select a square:")
  }

  it("displays winner"){
    val player = PlayerFactory.create("Human", Marker.X)
    ui.displayWinner(player)
    io.contents must equal ("Player(X) wins!")
  }

  it("displays draw"){
    ui.displayDraw()
    io.contents must equal("Draw!")
  }

  it("displays invalid move"){
    ui.displayInvalidMove()
    io.contents must equal("Invalid move. Please enter another move.")
  }

  describe("Game type"){
    it("displays invalid game type"){
      ui.displayInvalidGameType()
      io.contents must equal ("Invalid selection. Please select a type from the list")
    }

    it("reads the user selection for game type"){
      var userSelection = 9
      io.addInputInteger(userSelection)
      ui.gameType must equal (userSelection)
    }

    it("displays the game type"){
      var gameTypeContent = "1 - Computer vs Computer\n2 - Computer vs Human\n3 - Human vs Computer\n4 - Human vs Human\n"
      ui.gameType
      io.hasContent(gameTypeContent) must equal(true)
    }

    it("asks user to select a game type"){
      ui.gameType
      io.hasContent("Please enter a game type from the list.") must equal (true)
    }
  }

  describe("displays the board"){
    it("shows numbers for all unmarked squares"){
      ui.display(board)
      io.contents must equal (" | 0 | 1 |\n | 2 | 3 |\n")
    }

    it("shows the player value on the marked square"){
      board.mark(0, Marker.X)
      board.mark(2, Marker.O)
      ui.display(board)
      io.contents must equal (" | X | 1 |\n | O | 3 |\n")
    }

    it("displays a 3x3 board"){
      board = new Board(3)
      val expectedContent = " | 0 | 1 | 2 |\n | 3 | 4 | 5 |\n | 6 | 7 | 8 |\n"
      ui.display(board)
      io.contents must equal (expectedContent)
    }
  }
}
