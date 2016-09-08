package scalac

/**
  * Created by ignaciomosca on 9/6/16.
  */
object ChessChallengeSolver {

  def solution(board: Board, pieces: List[ChessPiece], solutions: Set[Board], testedConfigurations: Set[Board]): Set[Board] = {
    if (!pieces.isEmpty) {
      val candidates: List[ChessPiece] = for {
        r <- 1 to board.getM
        c <- 1 to board.getN
        p <- ChessPieceUtils.createPiece(pieces.head, r, c)
        if (board.isSafe(p))
      } yield p

      val candidate = candidates.head
      val b = board.place(candidate)
      if (pieces.size != 1) {
        if(!testedConfigurations.contains(b)){
          solution(b,pieces.tail,solutions,testedConfigurations+b)
        }
      }else{
        if(!solutions.contains(b)){
          solution(b,pieces.tail,solutions+b,testedConfigurations)
        }
      }
    }
    solutions
  }
}

