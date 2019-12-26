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
    val pieces = List(KingPiece, KingPiece, RookPiece)
    val board = Board(3, 3, Set(), pieces.length)
    val solutions = ChessChallengeSolver.solution(board, pieces, Set(board))
    assert(solutions.size == 4)
  }

  test("4x4 board containing 3 Rooks and 4 Knights") {
    val pieces = List(KnightPiece, KnightPiece, KnightPiece, KnightPiece, RookPiece, RookPiece)
    val board = Board(4, 4, Set(), pieces.length)
    val solutions = ChessChallengeSolver.solution(board, pieces, Set(board))
    assert(solutions.size == 8)
  }

  test("8x8 board with 8 Queens returns 92 solutions") {
    val pieces = List(QueenPiece, QueenPiece, QueenPiece, QueenPiece, QueenPiece, QueenPiece, QueenPiece, QueenPiece)
    val board = Board(8, 8, Set(), pieces.length)
    val solutions = ChessChallengeSolver.solution(board, pieces, Set(board))
    assert(solutions.size == 92)
  }

  test("Print Board") {
    val pieces = List(KnightPiece, KnightPiece, KnightPiece, KnightPiece, RookPiece, RookPiece)
    val board = Board(8, 8, Set(), pieces.length)
    val solutions = ChessChallengeSolver.solution(board, pieces, Set(board))
    solutions.map(_.show).foreach(println(_))
  }

  /*test("7x7 board with 2 Kings, 2 Queens, 2 Bishops and a Knight returns 3063828 solutions") {
    val pieces = List(KingPiece, KingPiece, QueenPiece, QueenPiece, Bishop(0, 0), Bishop(0, 0), KnightPiece)
    val board = Board(7, 7, Set(), pieces.length)
    val solutions = ChessChallengeSolver.solution(board, pieces, Set(board))      
    assert(solutions.size == 3063828)
  }*/

}
