package com.blogspot.nhu313.tictactoe

class TicTacToe(val gameFactory: GameFactory) {
  private val ui = new TicTacToeUI
  private val ContinuePlaying = "y"
  var continue = ContinuePlaying

  def start() {
    ui.displayWelcomeMessage

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
