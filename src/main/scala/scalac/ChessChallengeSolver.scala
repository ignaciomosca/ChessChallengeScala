package scalac

import scala.annotation.tailrec

/**
  * Created by ignaciomosca on 9/6/16.
  */
object ChessChallengeSolver {

  /**
    *
    * @param board  initial Board with no pieces placed
    * @param pieces Chess Pieces selected by the user to be placed
    * @param solutions Set containing possible solutions
    * @return return a list of possible solutions to the problem in the form of a list of filled chess boards
    */
  @tailrec
  def solution(board: Board, pieces: List[Piece], solutions: Set[Board]): Set[Board] = pieces match {
    case p :: ps => solution(board, ps, solutions.flatMap(board => findCandidateSolution(p, board)))
    case Nil => solutions.filter(_.done)
  }

  /**
    *
    * @param candidatePiece possible piece to be placed
    * @param board          board in which it will be placed
    * @return iterate over all possible positions and look for a position in which a new valid board configuration can be created.
    */
  private def findCandidateSolution(candidatePiece: Piece, board: Board): Set[Board] = {
    (for {
      r <- 1 to board.M
      c <- 1 to board.N
      p = ChessUtils.createPiece(candidatePiece, r, c)
      b = board.place(p)
      if board.isSafe(p)
    } yield b).toSet
  }

}