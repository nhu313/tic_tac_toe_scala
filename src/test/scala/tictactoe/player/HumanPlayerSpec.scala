package com.blogspot.nhu313.tictactoe.player

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers
import com.blogspot.nhu313.tictactoe.{Marker, Board, IO, MockIO}

class HumanPlayerSpec extends FunSpec with BeforeAndAfter with MustMatchers{

  var player: HumanPlayer = null
  val board = new Board(2)
  var io: MockIO = null
  val validMove = 1

  before {
    io = new MockIO
    IO.io = io
    player = new HumanPlayer("Human", Marker.X)
  }

  it("returns moves when input is valid"){
    io.addInputInteger(validMove)
    player.move(board) must equal (validMove)
  }

  it("asks the player for another move when the move is invalid"){
    io.addInputInteger(-1)
    io.addInputInteger(validMove)
    player.move(board)
    io.contents must include ("Invalid move. Please select another move.")
  }
}
