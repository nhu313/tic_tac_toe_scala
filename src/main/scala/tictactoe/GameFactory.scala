package com.blogspot.nhu313.tictactoe

class GameFactory {

  private val playerFactory = new PlayerFactory

  def isValidType(selection: Int) = selection > 0 && selection <= types.length

  def types() = {
    for {
      x <- playerFactory.playerTypes
      y <- playerFactory.playerTypes
    } yield Tuple2(x, y)
  }

  def create(gameType: Int): Game = {
    val playerTypes = types()(gameType - 1)
    val player1 = playerFactory.create(playerTypes._1, Marker.X)
    val player2 = playerFactory.create(playerTypes._2, Marker.O)
    new Game(Array(player1, player2))
  }
}
