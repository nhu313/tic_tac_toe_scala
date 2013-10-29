package com.blogspot.nhu313.tictactoe.mock

import com.blogspot.nhu313.tictactoe.{Game, GameFactory}
import scala.collection.mutable.ListBuffer

class MockGameFactory(val game: Game) extends GameFactory {
  val gameTypes = ListBuffer[Int]()

  override def create(gameType: Int): Game = {
    gameTypes += gameType
    return game
  }
}
