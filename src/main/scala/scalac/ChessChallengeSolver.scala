package scalac

/**
  * Created by ignaciomosca on 9/6/16.
  */
object ChessChallengeSolver {

  /**
    *
    * @param board     ChessBoard
    * @param pieces    Chess Pieces selected by the user
    * @param solutions valid solutions to the problem
    * @return return a list of possible solutions to the problem in the form of a list of filled chess boards
    */
  def solution(board: Board, pieces: List[ChessPiece], solutions: Set[Board]): Set[Board] = {
    if (!pieces.isEmpty) {
      (for {
        r <- 1 to board.M
        c <- 1 to board.N
        p = ChessPieceUtils.createPiece(pieces.head, r, c)
        b = board.place(p)
        if (board.isSafe(p) && !solutions.contains(b))
      } yield solution(b, pieces.tail, solutions + b)).foldLeft(Set[Board]())((s, b) => s ++ b)
    } else {
      Set(board)
    }
  }
}


