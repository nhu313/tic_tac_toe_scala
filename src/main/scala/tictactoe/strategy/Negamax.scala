package com.blogspot.nhu313.tictactoe.strategy
import com.blogspot.nhu313.tictactoe.Board
import com.blogspot.nhu313.tictactoe.Rules

class Negamax(val marker: Char) {
  val rules = new Rules()

  def move(board: Board): Int = negamax(marker, board, 0)._1

  private def negamax(player: Char, board: Board, depth: Int): Tuple2[Int, Int] = {
    var highestScoreMove = Tuple2(-100, -10000)
    for (x <- board.availableMoves) {
      board.mark(x, player)
      var moveScore = score(player, board, depth)
      if (moveScore > highestScoreMove._2){
        highestScoreMove = Tuple2(x, moveScore)
      }
      board.clear(x)
    }
    return highestScoreMove
  }

  private def score(player: Char, board: Board, depth: Int): Int = {
    if (rules.isGameOver(board)) {
      score(player, rules.winner(board)) - depth
    } else {
      -negamax(opponent(player), board, depth + 1)._2
    }
  }

  private def opponent(player: Char): Char = if (player == 'x') 'o' else 'x'

  def score(player: Char, winner: Option[Char]): Int = winner match {
    case Some(`player`) => 1000
    case None => 0
    case _ => -1000
  }
}
