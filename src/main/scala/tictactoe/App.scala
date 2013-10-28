package com.blogspot.nhu313.tictactoe

object Main extends App {
  val ui = new UI(new ConsoleIO)
  val tictactoe = new TicTacToe(new GameFactory(), ui)
  tictactoe.play
}
