package scalac

import scala.annotation.tailrec

object ChessChallengeSolver {

  /**
    * @param board     ChessBoard
    * @param pieces    Chess Pieces selected by the user
    * @param solutions Valid solutions to the problem
    * @param steps     Intermediate solutions
    * @return return a list of possible solutions to the problem in the form of a list of filled chess boards
    */
  @tailrec
  def solution(board: Board, pieces: List[ChessPiece], solutions: Set[Board], steps: List[Board]): Set[Board] = pieces match {
    case List() => if (pieces.isEmpty) solutions else solution(steps.head, pieces, solutions, steps.tail)
    case p :: ps => {
      val extraSteps = findCandidatePosition(p, board, solutions)
      solution(steps.head, pieces, solutions, steps.tail ++ extraSteps)
    }
  }

  /**
    * @param chessPiece piece to be placed
    * @param board      board in which to place the piece
    * @param solutions  solutions that were already found
    * @return returns a possible board to add to the solutions Set
    */
  private def findCandidatePosition(chessPiece: ChessPiece, board: Board, solutions: Set[Board]) = {
    for {
      r <- 1 to board.M
      c <- 1 to board.N
      p = ChessPieceUtils.createPiece(chessPiece, r, c)
      b = board.place(p)
      if (board.isSafe(p) && !solutions.contains(b))
    } yield b
  }

  /**
    * @param newBoard candidate board
    * @param solutions list of solutions
    * @return returns a one set element if it's a new solution or an empty list if it's not
    */
  def isSolution(newBoard: Board, solutions: Set[Board]) = {
    if (newBoard.done && !solutions.contains(newBoard)) {
      Set(newBoard)
    } else {
      Set()
    }
  }
}

