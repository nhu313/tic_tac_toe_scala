package com.blogspot.nhu313.tictactoe

import com.blogspot.nhu313.tictactoe.strategy.{Negamax, UserInput}

object PlayerFactory{

  def create(type: String, marker: Char) = type match {
    case "Computer" => new ComputerPlayer(marker)
    case "Human" => new HumanPlayer(marker)
  }
}

private class HumanPlayer(val marker: Char) extends UserInput
private class ComputerPlayer(val marker: Char) extends Negamax

