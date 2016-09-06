package scalac

/**
  * Created by ignaciomosca on 9/6/16.
  */
class ChessChallengeSolver {

  def solution(board: Board, pieces: List[ChessPiece], solutions: Set[Board], testedConfigurations: Set[Board]):Set[Board] = pieces match {
    case List() => solutions
    case p :: ps => {
      for {
        r <- 1 to board.getM
        c <- 1 to board.getN
        candidatePiece <- board.createPiece(p, r, c)
        if (board.isSafe(candidatePiece) && !solutions.contains(board.place(candidatePiece)))
      } yield (solution(board, ps, solutions + board.place(candidatePiece) , testedConfigurations))
    }
  }


}