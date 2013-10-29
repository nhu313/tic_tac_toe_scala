package com.blogspot.nhu313.tictactoe

object Main extends App {
  val gameFactory = new GameFactory
  val tictactoe = new TicTacToe(gameFactory)
  tictactoe.start
}
