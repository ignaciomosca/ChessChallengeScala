package scalac

/**
  * Created by ignaciomosca on 9/6/16.
  */
object ChessChallengeSolver {

  /**
    * @param board     ChessBoard
    * @param pieces    Chess Pieces selected by the user
    * @param solutions valid solutions to the problem
    * @return return a list of possible solutions to the problem in the form of a list of filled chess boards
    */
  def solution(board: Board, pieces: List[ChessPiece], solutions: Set[Board]): Set[Board] = {
    (for {
      r <- 1 to board.M
      c <- 1 to board.N
      chessPiece <- pieces.map(p => ChessPieceUtils.createPiece(p,r,c))
      b = board.place(chessPiece)
      s <- solution(b, removePieces(chessPiece, pieces), solutions ++ isSolution(b, solutions))
    } yield s) (collection.breakOut)
  }

  /***
    *
    * @param chessPiece chessPiece to be removed
    * @param pieces list of remaining pieces to be placed
    * @return a list of pieces without the one that was used
    */
  def removePieces(chessPiece: ChessPiece, pieces: List[ChessPiece]): List[ChessPiece] = pieces match{
    case List() => List()
    case p::ps => if(p.toString.equals(chessPiece.toString)) ps else p::removePieces(chessPiece,ps)
  }

  /**
    * @param board candidate board
    * @param solutions
    * @return returns a set containing a new board configuration
    */
  def isSolution(board: Board, solutions: Set[Board]): Set[Board] = {
    if (board.done && !solutions.contains(board)) {
      Set(board)
    } else {
      Set()
    }
  }

}
