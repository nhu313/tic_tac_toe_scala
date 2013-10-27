package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

class ConsoleUISpec extends FunSpec with BeforeAndAfter with MustMatchers{

  var ui = new ConsoleUI

  describe("displays the board"){
    // it("shows numbers for all unmarked squares"){
    //   val expected_display = "| 0 | 1 |\n| 2 | 3 |\n"
    //   ui.buildBoard(new Board(2)) must equal (expected_display)
    // }

  //   it "shows the player value on the marked square" do
  //     @board.mark(0, "X")
  //     expected_display = "| X | 1 |\n| 2 | 3 |\n"
  //     @output.should_receive(:puts).with(expected_display)
  //     @console.display_board(@board)
  //   end
  //
  //   it "shows the player values when all the squares are marked" do
  //     (0...@size**2).each {|value| @board.mark(value, "O")}
  //     expected_display = "| O | O |\n| O | O |\n"
  //     @output.should_receive(:puts).with(expected_display)
  //     @console.display_board(@board)
  //   end
  //
  //   it "displays a 3x3 board" do
  //     @board = TicTacToe::Board.new(3)
  //     @console = TicTacToe::Console.new(@input, @output)
  //     expected_display = "| 0 | 1 | 2 |\n| 3 | 4 | 5 |\n| 6 | 7 | 8 |\n"
  //     @output.should_receive(:puts).with(expected_display)
  //     @console.display_board(@board)
  //   end
  // end
  }
}
