package com.blogspot.nhu313.tictactoe

import com.blogspot.nhu313.tictactoe.player.{Computer, Human}

object PlayerFactory{

  def create(playerType: String, marker: Marker) = playerType match {
    case "Computer" => new Computer("Computer", marker)
    case "Human" => new Human("You", marker)
  }
}

trait Player{
  def marker: Marker
  def name: String
  def move(board: Board): Int
}
