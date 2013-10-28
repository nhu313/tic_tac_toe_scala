package com.blogspot.nhu313.tictactoe

import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.matchers.MustMatchers

class GameFactorySpec extends FunSpec with BeforeAndAfter with MustMatchers{

  it("has 4 game types") {
    val expectedTypes = Array(Tuple2("Computer", "Computer"),
                              Tuple2("Computer", "Human"),
                              Tuple2("Human", "Computer"),
                              Tuple2("Human", "Human"))

    GameFactory.types must equal (expectedTypes)
  }
}
