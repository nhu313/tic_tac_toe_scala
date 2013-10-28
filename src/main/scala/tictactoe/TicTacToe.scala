package com.blogspot.nhu313.tictactoe

class TicTacToe(val gameFactory: GameFactory, val ui: UI){

  def play() {
    ui.displayWelcomeMessage

    var continue = "y"
    while (continue == "y"){
      continue = "n"
      var game = gameFactory.create(validGameType)
      game.start
      ui.displayAnotherGame
      continue = readLine().toLowerCase()
    }
  }

  def validGameType(): Int = {
    var gameType = ui.gameType
    while(!gameFactory.isValidType(gameType)){
      ui.displayInvalidGameType
      gameType = ui.gameType
    }
    return gameType
  }
}
