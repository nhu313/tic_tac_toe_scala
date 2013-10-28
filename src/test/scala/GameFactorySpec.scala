package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

class GameFactorySpec extends FunSpec with BeforeAndAfter with MustMatchers{

  private val gameFactory = new GameFactory

  it("has 4 game types") {
    val expectedTypes = Array(Tuple2("Computer", "Computer"),
                              Tuple2("Computer", "Human"),
                              Tuple2("Human", "Computer"),
                              Tuple2("Human", "Human"))

    gameFactory.types must equal (expectedTypes)
  }
}
