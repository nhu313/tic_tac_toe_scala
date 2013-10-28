package com.blogspot.nhu313.tictactoe

class UI(private val io: IO) {

  def displayWelcomeMessage() {
    io.display("Let's play some Tic Tac Toe!\n")
  }

  def displayPlayerTurn(player: Player){
    io.display(playerInfo(player) + ", please select a square:")
  }

  def gameType(): Int = {
    io.display("Please enter a game type from the list.")
    io.display(buildGameTypes())
    io.readInteger()
  }

  private def buildGameTypes(): String = {
    val gameTypes = GameFactory.types
    var content = ""
    for(i <- 0 until gameTypes.length){
      var playerTypes = gameTypes(i)
      content = content + (i + 1) + " - " + playerTypes._1 + " vs " + playerTypes._2 + "\n"
    }
    return content
  }

  def displayInvalidGameType(){
    io.display("Invalid selection. Please select a type from the list")
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
