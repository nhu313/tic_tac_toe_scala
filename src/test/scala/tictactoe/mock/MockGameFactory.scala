package com.blogspot.nhu313.tictactoe.mock

import scala.collection.mutable.ListBuffer

import com.blogspot.nhu313.tictactoe.{Game, GameFactory}

class MockGameFactory(val game: Game) extends GameFactory {
  val gameTypes = ListBuffer[Int]()

  override def create(gameType: Int): Game = {
    gameTypes += gameType
    return game
  }
}
