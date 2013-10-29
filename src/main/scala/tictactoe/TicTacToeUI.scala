package com.blogspot.nhu313.tictactoe

class TicTacToeUI {
  private val io = IO()

  def displayWelcomeMessage() {
    io.display("Let's play some Tic Tac Toe!\n")
  }

  def displayAnotherGame(){
    io.display("Would you like to play another game? (y/n)")
  }

  def gameType(gameTypes: Array[Tuple2[String, String]]): Int = {
    io.display("Please enter a game type from the list.")
    io.display(buildGameTypes(gameTypes))
    io.readInteger()
  }

  def userInput() = io.readString()

  private def buildGameTypes(gameTypes: Array[Tuple2[String, String]]): String = {
    var content = new StringBuilder
    for(i <- 0 until gameTypes.length){
      var playerTypes = gameTypes(i)
      content.append((i + 1) + " - ")
      content.append(playerTypes._1 + " vs " + playerTypes._2 + "\n")
    }
    return content.toString()
  }

  def displayInvalidGameType(){
    io.display("Invalid selection. Please select a type from the list")
  }
}
