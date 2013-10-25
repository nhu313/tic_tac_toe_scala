// import org.specs._
//
// object ExampleSpec extends Specification {
//   "Arithmetic" should {
//     "add two numbers" in {
//       1 + 1 mustEqual 2
//     }
//     "add three numbers" in {
//       1 + 1 + 1 mustEqual 3
//     }
//   }
// }
//

import org.scalatest.FunSpec
import scala.collection.mutable.Stack

class ExampleSpec extends FunSpec {

  describe("A Stack") {

    it("should pop values in last-in-first-out order") {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      assert(stack.pop() === 2)
      assert(stack.pop() === 1)
    }

    it("should throw NoSuchElementException if an empty stack is popped") {
      val emptyStack = new Stack[String]
      intercept[NoSuchElementException] {
        emptyStack.pop()
      }
    }
  }
}
