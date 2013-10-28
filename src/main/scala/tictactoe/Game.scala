package com.blogspot.nhu313.tictactoe

class Game(val players: Array[Player]) {
  val rules = new Rules
  val ui = new UI(new ConsoleIO)
  var currentPlayer = players(0)

  def start() {
    val board = new Board(3)

    while(!rules.isGameOver(board)){
      ui.displayPlayerTurn(currentPlayer)
      ui.display(board)
      board.mark(currentPlayer.move(board), currentPlayer.marker)
      changePlayer
    }
    displayResult(board)
    ui.display(board)
  }

  def displayResult(board: Board){
    val winner = rules.winner(board)
    if(winner == None){
      ui.displayDraw()
    } else {
      ui.displayWinner(player(winner.head))
    }
  }

  def player(marker: Marker): Player = {
    changePlayer
    currentPlayer
  }

  def changePlayer(){
    currentPlayer = if (currentPlayer == players(0)) players(1) else players(0)
  }
}
