package com.blogspot.nhu313.tictactoe

object Main extends App {
  // val gameFactory = new GameFactory
  val game = GameFactory.create(3)
  game.start
}
