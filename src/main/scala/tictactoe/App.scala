package com.blogspot.nhu313.tictactoe

object Main extends App {
  val io = new ConsoleIO
  val gameFactory = new GameFactory(io)
  val tictactoe = new TicTacToe(gameFactory, io)
  tictactoe.start
}
