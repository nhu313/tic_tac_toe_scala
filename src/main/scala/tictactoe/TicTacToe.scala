package com.blogspot.nhu313.tictactoe

class TicTacToe {
  private val ui = new TicTacToeUI
  private val gameFactory = new GameFactory
  private val ContinuePlaying = "y"

  def play() {
    ui.displayWelcomeMessage

    var continue = ContinuePlaying
    while (continue == ContinuePlaying){
      var game = gameFactory.create(validGameType)
      game.start
      ui.displayAnotherGame
      continue = ui.userInput.toLowerCase()
    }
  }

  def validGameType(): Int = {
    var gameType = ui.gameType(gameFactory.types)
    while(!gameFactory.isValidType(gameType)){
      ui.displayInvalidGameType
      gameType = ui.gameType(gameFactory.types)
    }
    return gameType
  }
}
