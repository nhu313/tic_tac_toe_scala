package com.blogspot.nhu313.tictactoe.strategy

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.MustMatchers

import com.blogspot.nhu313.tictactoe.Board

class NegamaxSpec extends FunSpec with BeforeAndAfter with MustMatchers{
  var board: Board = null
  val o = 'o'
  val x = 'x'
  var strategy = new Negamax(o)

  before {
    board = new Board(3)
  }

  it("returns the last move") {
    //  x  o  o
    //  o  x  x
    //  x  _  o

    markboard(Array(0, 4, 5, 6), x)
    markboard(Array(1, 2, 3, 8), o)

    strategy.move(board) must equal (7)
  }

  it("returns winning move when there is one winning and one losing move") {
    // _  o  x
    // x  o  o
    // x  _  x
    markboard(Array(2, 3, 6, 8), x)
    markboard(Array(1, 4, 5), o)

    strategy.move(board) must equal (7)
  }

  it("returns winning move when there is one winning and one draw move") {
    // _  x  o
    // x  o  o
    // x  o  _
    markboard(Array(1, 3, 6), x)
    markboard(Array(2, 4, 5, 7), o)

    strategy.move(board) must equal (8)
  }

  it("returns winning move when there is a winning moves when there are 3 moves available") {
    // _  x  o
    // _  o  x
    // _  o  x
    markboard(Array(1, 5, 8), x)
    markboard(Array(2, 4, 7), o)

    strategy.move(board) must equal (6)
  }

  it("returns blocking move when there is a blocking move when there are 3 moves available") {
    // _  x  o
    // _  o  o
    // x  o  _
    markboard(Array(1, 6), x)
    markboard(Array(2, 4, 5, 7), o)

    strategy.move(board) must equal (3)
  }

  it("when the best option is a draw") {
    // x  o  x
    // _  o  x
    // _  x  _
    markboard(Array(0, 2, 5, 7), x)
    markboard(Array(1, 4), o)

    strategy.move(board) must equal (8)
  }

  it("when there is a winning moves available") {
    // x  o  _
    // _  o  _
    // _  _  _
    markboard(Array(0), x)
    markboard(Array(1, 4), o)

    strategy.move(board) must equal (7)
  }

  it("returns winning move when there is winning and blocking move") {
    // x  _  o
    // x  _  o
    // _  _  _
    markboard(Array(1, 3), x)
    markboard(Array(2, 5), o)

    strategy.move(board) must equal (8)
  }

  it("chooses a move that creates 2 winning moves") {
    // o  x  _
    // x  _  x
    // o  _  _
    markboard(Array(1, 3, 5), x)
    markboard(Array(0, 6), o)

    strategy.move(board) must equal (4)
  }

  it("chooses blocking move when there is no winning move") {
    // _  x  o
    // _  x  _
    // _  _  _
    markboard(Array(1, 4), x)
    markboard(Array(2), o)

    strategy.move(board) must equal (7)
  }

  def markboard(moves: Array[Int], marker: Char){
    moves.foreach{
      board.mark(_ , marker)
    }
  }
}
