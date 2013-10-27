package com.blogspot.nhu313.tictactoe

class GameFactory {

  def types() = {
    for {
      x <- PlayerFactory.playerTypes
      y <- PlayerFactory.playerTypes
    } yield Tuple2(x, y)
  }

  def create(gameType: Int): Game = {
    val playerTypes = types()(gameType - 1)
    val player1 = PlayerFactory.create(playerTypes._1, Marker.X)
    val player2 = PlayerFactory.create(playerTypes._2, Marker.O)
    new Game(Array(player1, player2))
  }
}
