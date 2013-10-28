package com.blogspot.nhu313.tictactoe

class GameUI {

  private val io = IO()

  def displayPlayerTurn(player: Player){
    io.display(playerInfo(player) + ", please select a square:")
  }

  def displayWinner(winner: Player){
    io.display(playerInfo(winner) + " wins!")
  }

  def displayDraw(){
    io.display("Draw!")
  }

  def displayInvalidMove(){
    io.display("Invalid move. Please enter another move.")
  }

  def display(board: Board){
    io.display(buildBoard(board))
  }

  private def buildBoard(board: Board): String = {
    var string = ""
    val squares = board.squares.zipWithIndex

    for(x <- squares){
      val value = if (x._1 == Marker.NONE) x._2 else x._1

      string = string + " | " + value
      if ((x._2 + 1) % board.size == 0){
        string = string + " |\n"
      }
    }

    return string
  }

  private def playerInfo(player: Player): String = {
    player.name + "(" + player.marker + ")"
  }
}
