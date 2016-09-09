package scalac

/**
  * Created by ignaciomosca on 9/6/16.
  */
object ChessChallengeSolver {

  /** *
  * @param board                ChessBoard
  * @param pieces               Chess Pieces selected by the user
  * @param solutions            valid solutions to the problem
  * @param testedConfigurations Board configurations to which solutions were not found
  * @return return a list of possible solutions to the problem in the form of a list of filled chess boards
  */
  def solution(board: Board, pieces: List[ChessPiece], solutions: Set[Board], testedConfigurations: Set[Board]): Set[Board] = {
    if (!pieces.isEmpty) {
      val candidateBoard = findCandidatePosition(pieces.head, board, solutions, testedConfigurations)
      val setBoards = (for{
        b <- candidateBoard
      } yield solution(b, pieces.tail, solutions+b, testedConfigurations+b)).foldLeft(Set[Board]())((s,b) => s++b)
      setBoards
    } else {
      board.show()
      Set(board)
    }
  }

  /***
    *
    * @param chessPiece piece to be placed
    * @param board board in which to place the piece
    * @param solutions solutions that were already found
    * @param testedConfigurations configurations that were already tested
    * @return returns a possible board to add to the solutions Set
    */
  private def findCandidatePosition(chessPiece: ChessPiece, board: Board, solutions: Set[Board], testedConfigurations: Set[Board]) = {
    for {
      r <- 1 to board.getM
      c <- 1 to board.getN
      p = ChessPieceUtils.createPiece(chessPiece, r, c)
      b = board.place(p)
      if (board.isSafe(p) && !testedConfigurations.contains(b) && !solutions.contains(b))
    } yield b
  }

}

