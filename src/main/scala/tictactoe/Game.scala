package com.blogspot.nhu313.tictactoe

class Game(val players: Array[Player], val io: IO) {
  private val rules = new Rules
  private val ui = new GameUI(io)
  private var currentPlayer = players(0)
  val board = new Board(3)

  def play() {
    while(!rules.isGameOver(board)){
      ui.displayPlayerTurn(currentPlayer)
      ui.display(board)
      board.mark(currentPlayer.move(board), currentPlayer.marker)
      changePlayer
    }
    ui.display(board)
    displayResult(board)
  }

  private def displayResult(board: Board){
    val winner = rules.winner(board)
    if(winner == None){
      ui.displayDraw()
    } else {
      ui.displayWinner(player(winner.head))
    }
  }

  private def player(marker: Marker): Player = {
    if(marker == players(0).marker) players(0) else players(1)
  }

  private def changePlayer(){
    currentPlayer = if (currentPlayer == players(0)) players(1) else players(0)
  }
}
