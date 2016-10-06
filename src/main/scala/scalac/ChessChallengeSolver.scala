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
    * @return return a list of possible solutions to the problem in the form of a list of filled chess boards
    */
  def solution(board: Board, pieces: List[ChessPiece]): Set[Board] = obtainSolution(pieces, Set(board)).filter(_.done)


  @tailrec
  private def obtainSolution(pieces: List[ChessPiece], solutions: Set[Board]): Set[Board] = pieces match {
    case p :: ps => obtainSolution(ps, candidateSolution(p, solutions))
    case Nil => solutions
  }

  private def candidateSolution(candidatePiece: ChessPiece, candidateBoards: Set[Board]): Set[Board] = {
    for{
      board <- candidateBoards
      c <- findCandidateSolution(candidatePiece, board)
    }yield c
  }

  /** *
    *
    * @param candidatePiece possible piece to be placed
    * @param board          board in which it will be placed
    * @return iterate over all possible positions and look for a position in which a new board configuration can be created.
    *         If it's a solution add it to solutions list
    */
  private def findCandidateSolution(candidatePiece: ChessPiece, board: Board): Set[Board] = {
    def findCandidateSolutionAux(usedPieces: Set[ChessPiece], solutions: Set[Board]): Set[Board] = {
      if (usedPieces.size != board.numberOfPieces) {
        (for {
          r <- 1 to board.M
          c <- 1 to board.N
          p = ChessPieceUtils.createPiece(candidatePiece, r, c)
          b = board.place(p)
          if (board.isSafe(p) && !solutions.contains(b))
        } yield b) (collection.breakOut)
      } else {
        solutions
      }
    }
    findCandidateSolutionAux(board.usedPieces, Set[Board]())
  }


}
