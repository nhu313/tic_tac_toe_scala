package com.blogspot.nhu313.tictactoe

import com.blogspot.nhu313.tictactoe.player.{Computer, Human}

object PlayerFactory{

  def create(playerType: String, marker: Char) = playerType match {
    case "Computer" => new Computer("Computer", marker)
    case "Human" => new Human("You", marker)
  }
}

trait Player{
  def marker: Char
  def name: String
  def move(board: Board): Int
}
