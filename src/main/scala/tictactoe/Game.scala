package com.blogspot.nhu313.tictactoe

class Game {

  def start() {
    val ui = new ConsoleUI
    val board = new Board(2)

    val player1 = PlayerFactory.create("Human", Marker.X)
    val player2 = PlayerFactory.create("Computer", Marker.O)

    println("Let's play some Tic Tac Toe!")
    println("Please select a square")
    ui.display(board)
    board.mark(player1.move(board), player1.marker)
    ui.display(board)
    board.mark(player2.move(board), player2.marker)
    ui.display(board)
    board.mark(player1.move(board), player1.marker)


  }

}
