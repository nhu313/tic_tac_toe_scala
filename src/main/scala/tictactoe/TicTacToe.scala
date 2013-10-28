package com.blogspot.nhu313.tictactoe

class TicTacToe {
  private val ui = new TicTacToeUI
  private val gameFactory = new GameFactory
  private val ContinuePlaying = "y"

  def start() {
    ui.displayWelcomeMessage

    var continue = ContinuePlaying
    while (continue == ContinuePlaying){
      var game = gameFactory.create(validGameType)
      game.play
      ui.displayAnotherGame
      continue = ui.userInput.toLowerCase()
    }
  }

  private def validGameType(): Int = {
    var gameType = ui.gameType(gameFactory.types)
    while(!gameFactory.isValidType(gameType)){
      ui.displayInvalidGameType
      gameType = ui.gameType(gameFactory.types)
    }
    return gameType
  }
}
