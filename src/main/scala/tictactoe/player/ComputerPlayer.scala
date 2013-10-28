package com.blogspot.nhu313.tictactoe.player

import com.blogspot.nhu313.tictactoe.{Board, Rules, Player, Marker}

class ComputerPlayer(val name: String, val marker: Marker) extends Player {

  private val rules = new Rules()

  def move(board: Board): Int = negamax(marker, board, 0)._1

  private def negamax(player: Marker, board: Board, depth: Int): Tuple2[Int, Int] = {
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

  private def score(player: Marker, board: Board, depth: Int): Int = {
    if (rules.isGameOver(board)) {
      score(player, rules.winner(board)) - depth
    } else {
      -negamax(player.opponent, board, depth + 1)._2
    }
  }

  private def score(player: Marker, winner: Option[Marker]): Int = winner match {
    case Some(`player`) => 1000
    case None => 0
    case _ => -1000
  }
}
