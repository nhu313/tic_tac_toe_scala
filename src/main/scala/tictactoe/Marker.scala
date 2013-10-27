package com.blogspot.nhu313.tictactoe

class Marker(val value: String){
  override def toString(): String = {
    value
  }

  def opponent = if (this == Marker.X) Marker.O else Marker.X
}

object Marker{
  val X = new Marker("X")
  val O = new Marker("O")
  val NONE = new Marker("")
}
