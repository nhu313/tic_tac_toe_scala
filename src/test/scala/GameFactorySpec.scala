package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

import com.blogspot.nhu313.tictactoe.player.{ComputerPlayer, HumanPlayer}

class GameFactorySpec extends FunSpec with BeforeAndAfter with MustMatchers{

  private val gameFactory = new GameFactory

  it("has 4 game types") {
    val expectedTypes = Array(Tuple2("Computer", "Computer"),
                              Tuple2("Computer", "Human"),
                              Tuple2("Human", "Computer"),
                              Tuple2("Human", "Human"))

    gameFactory.types must equal (expectedTypes)
  }

  describe("Create Game"){
    it("creates game with computer vs computer player"){
      val game = gameFactory.create(1)
      assert(game.players(0).isInstanceOf[ComputerPlayer])
      assert(game.players(1).isInstanceOf[ComputerPlayer])
    }

    it("creates game with computer vs human player"){
      val game = gameFactory.create(2)
      assert(game.players(0).isInstanceOf[ComputerPlayer])
      assert(game.players(1).isInstanceOf[HumanPlayer])
    }

    it("creates game with human vs computer player"){
      val game = gameFactory.create(3)
      assert(game.players(0).isInstanceOf[HumanPlayer])
      assert(game.players(1).isInstanceOf[ComputerPlayer])
    }

    it("creates game with human vs human player"){
      val game = gameFactory.create(4)
      assert(game.players(0).isInstanceOf[HumanPlayer])
      assert(game.players(1).isInstanceOf[HumanPlayer])
    }

    it("creates players with different markers"){
      for (x <- 1 to 4){
        var game = gameFactory.create(x)
        game.players(0).marker must not equal (game.players(1).marker)
      }
    }
  }

  describe("Valid type"){
    it("when selection is smaller than the smallest selection"){
      assert(gameFactory.isValidType(0) == false)
    }

    it("when selection is larger than the largest selection"){
      assert(gameFactory.isValidType(5) == false)
    }

    it("when selection is the smallest selection"){
      assert(gameFactory.isValidType(1) == true)
    }

    it("when selection is the largest selection"){
      assert(gameFactory.isValidType(4) == true)
    }
  }
}
