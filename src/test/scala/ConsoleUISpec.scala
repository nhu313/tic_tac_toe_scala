package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

class ConsoleUISpec extends FunSpec with BeforeAndAfter with MustMatchers{

  var ui = new ConsoleUI
  var board: Board = null

  before {
    board = new Board(2)
  }

  describe("displays the board"){
    it("shows numbers for all unmarked squares"){
      val expected_display = " | 0 | 1 |\n | 2 | 3 |\n"
      ui.buildBoard(board) must equal (expected_display)
    }

    it("shows the player value on the marked square"){
      board.mark(0, Marker.X)
      board.mark(2, Marker.O)
      val expected_display = " | X | 1 |\n | O | 3 |\n"
      ui.buildBoard(board) must equal (expected_display)
    }

    it("displays a 3x3 board"){
      board = new Board(3)
      val expected_display = " | 0 | 1 | 2 |\n | 3 | 4 | 5 |\n | 6 | 7 | 8 |\n"
      ui.buildBoard(board) must equal (expected_display)
    }
  }
}
