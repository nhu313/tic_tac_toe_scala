package com.blogspot.nhu313.tictactoe

object Main extends App {
  val gameFactory = new GameFactory
  val game = gameFactory.create(1)
  game.start
}
