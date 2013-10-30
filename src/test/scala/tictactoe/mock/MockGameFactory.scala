package com.blogspot.nhu313.tictactoe.mock

import scala.collection.mutable.ListBuffer

import com.blogspot.nhu313.tictactoe.{Game, GameFactory, IO}

class MockGameFactory(val game: Game, override val io: IO = new MockIO) extends GameFactory(io) {
  val gameTypes = ListBuffer[Int]()

  override def create(gameType: Int): Game = {
    gameTypes += gameType
    return game
  }
}
