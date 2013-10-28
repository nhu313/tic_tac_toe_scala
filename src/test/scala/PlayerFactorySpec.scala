package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

import com.blogspot.nhu313.tictactoe.player.{HumanPlayer, ComputerPlayer}

class PlayerFactorySpec extends FunSpec with BeforeAndAfter with MustMatchers{
  private val playerFactory = new PlayerFactory

  it("returns player types") {
    playerFactory.types must equal (Array("Computer", "Human"))
  }

  describe("Human player"){
    it("create a human player"){
      val marker = Marker.X
      val player = playerFactory.create(playerFactory.Human, marker)
      player.isInstanceOf[HumanPlayer] must equal (true)
    }

    it("has the marker passed in"){
      val player = playerFactory.create(playerFactory.Human, Marker.O)
      player.marker must equal (Marker.O)
    }

    it("name is its type"){
      val player = playerFactory.create(playerFactory.Human, Marker.O)
      player.name must equal("Human")
    }
  }

  describe("Computer player"){
    it("create a Computer player"){
      val marker = Marker.O
      val player = playerFactory.create(playerFactory.Computer, marker)
      player.isInstanceOf[ComputerPlayer] must equal (true)
    }

    it("has the marker passed in"){
      val marker = Marker.X
      val player = playerFactory.create(playerFactory.Computer, marker)
      player.marker must equal (marker)
    }

    it("name is its type"){
      val player = playerFactory.create(playerFactory.Computer, Marker.O)
      player.name must equal("Computer")
    }
  }
}
