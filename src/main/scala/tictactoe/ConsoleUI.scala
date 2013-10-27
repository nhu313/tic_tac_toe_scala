package com.blogspot.nhu313.tictactoe

class ConsoleUI {

  def display(message: String){
    println(message)
  }

  def display(board: Board){
    println(buildBoard(board))
  }

  def buildBoard(board: Board): String = {
    var string = ""
    val squares = board.squares.zipWithIndex

    for(x <- squares){
      val value = if (x._1 == board.emptyValue) x._2 else x._1

      string = string + " | " + value
      if ((x._2 + 1) % board.size == 0){
        string = string + " |\n"
      }
    }

    return string
  }
}

// def build_board(board)
//   result = ""
//   board.squares.each_with_index do |value, index|
//      result << "| #{value || index} "
//      result << "|\n" if (index + 1) % board.size == 0
//   end
//   result
// end
