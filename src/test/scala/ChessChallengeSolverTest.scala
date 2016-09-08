import org.scalatest.FunSuite

import scalac._

/**
  * To measure performance I ran the 8 queens code with a modified Main class that generated the test from the results.
  * Because the Answer to the 8-Queens problem is already known (92 solutions), I can test if the algorithm is correct for these initial conditions.
  * It is important to remember that the absence of evidence is not evidence of absence, this class does not intend to test for correctness
  * but to measure the impact in performance of different approaches to solving this problem
  * Created by ignacio on 07/09/16.
  */
class ChessChallengeSolverTest extends FunSuite {

  test("3x3 board containing 2 Kings and 1 Rook") {
    assert(ChessChallengeSolver.solution(new Board(3, 3, List()), List(King(0, 0), King(0, 0), Rook(0, 0)), Set(), Set()).size == 4)
  }
  test("4x4 board containing 3 Rooks and 4 Knighs") {
    assert(ChessChallengeSolver.solution(new Board(4, 4, List()), List(Knight(0, 0), Knight(0, 0), Knight(0, 0), Knight(0, 0), Rook(0, 0), Rook(0, 0)), Set(), Set()).size == 8)
  }
  test("8x8 board returns 92 solutions") {
    assert(ChessChallengeSolver.solution(new Board(8, 8, List()), List(Queen(0, 0), Queen(0, 0), Queen(0, 0), Queen(0, 0), Queen(0, 0), Queen(0, 0), Queen(0, 0), Queen(0, 0)), Set(), Set()).size == 92)
  }

}
