package com.blogspot.nhu313.tictactoe

class GameUI(val io: IO) {

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
    var string = new StringBuilder()
    val squares = board.squares.zipWithIndex

    for(x <- squares){
      val value = if (x._1 == Marker.NONE) x._2 else x._1
      string.append(" | " + value)
      addRowSeparator(x._2, board.size, string)
    }

    return string.toString()
  }

  private def addRowSeparator(index: Int, boardSize: Int, string: StringBuilder){
    if ((index + 1) % boardSize == 0){
      string.append(" |\n")
    }
  }

  private def playerInfo(player: Player): String = {
    player.name + "(" + player.marker + ")"
  }
}
