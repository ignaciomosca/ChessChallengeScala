package scalac

/**
  * Created by ignaciomosca on 9/6/16.
  */
object ChessChallengeSolver {

  def solution(board: Board, pieces: List[ChessPiece], solutions: Set[Board], testedConfigurations: Set[Board]): Set[Board] = {
    if (!pieces.isEmpty) {
      val candidateBoard = findCandidatePosition(pieces.head, board, testedConfigurations)
      val setBoards = (for{
        b <- candidateBoard
      } yield solution(b, pieces.tail, Set(), Set())).foldLeft(Set[Board]())((s,b) => s++b)
      setBoards
    } else {
      Set(board)
    }
  }

  private def findCandidatePosition(chessPiece: ChessPiece, board: Board, testedConfigurations: Set[Board]) = {
    for {
      r <- 1 to board.getM
      c <- 1 to board.getN
      p = ChessPieceUtils.createPiece(chessPiece, r, c)
      b = board.place(p)
      if (board.isSafe(p) && !testedConfigurations.contains(b))
    } yield b
  }

}

