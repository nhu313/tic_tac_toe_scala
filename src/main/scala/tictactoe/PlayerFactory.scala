package com.blogspot.nhu313.tictactoe

import com.blogspot.nhu313.tictactoe.player.{Computer, Human}

class PlayerFactory {

  private val Computer = "Computer"
  private val Human = "Human"

  val playerTypes = Array(Computer, Human)

  def create(playerType: String, marker: Marker) = playerType match {
    case Computer => new Computer(Computer, marker)
    case Human => new Human(Human, marker)
  }
}

trait Player{
  def marker: Marker
  def name: String
  def move(board: Board): Int
}
