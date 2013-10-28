package com.blogspot.nhu313.tictactoe

import com.blogspot.nhu313.tictactoe.player.{ComputerPlayer, HumanPlayer}

class PlayerFactory {

  val Computer = "Computer"
  val Human = "Human"

  val types = Array(Computer, Human)

  def create(playerType: String, marker: Marker) = playerType match {
    case Computer => new ComputerPlayer(Computer, marker)
    case Human => new HumanPlayer(Human, marker)
  }
}

trait Player{
  def marker: Marker
  def name: String
  def move(board: Board): Int
}
