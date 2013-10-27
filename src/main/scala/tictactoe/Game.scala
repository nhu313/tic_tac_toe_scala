package com.blogspot.nhu313.tictactoe

class Game(val players: Array[Player]) {
  val rules = new Rules
  val ui = new ConsoleUI
  var currentPlayer = players(0)

  def start() {
    val board = new Board(3)

    println("Let's play some Tic Tac Toe!")
    while(!rules.isGameOver(board)){
      println(currentPlayer.name + "(" + currentPlayer.marker + "), please select a square")
      ui.display(board)
      board.mark(currentPlayer.move(board), currentPlayer.marker)
      changePlayer
    }
    ui.display(board)
  }

  def changePlayer(){
    currentPlayer = if (currentPlayer == players(0)) players(1) else players(0)
  }
}
