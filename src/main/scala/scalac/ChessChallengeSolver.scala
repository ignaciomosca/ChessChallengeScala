package scalac

import scala.annotation.tailrec

/**
  * Created by ignaciomosca on 9/6/16.
  */
object ChessChallengeSolver {

  /**
  *
  * @param board                ChessBoard
  * @param pieces               Chess Pieces selected by the user
  * @param solutions            valid solutions to the problem
  * @return return a list of possible solutions to the problem in the form of a list of filled chess boards
  */
  @tailrec
  def solution(board: Board, pieces: List[ChessPiece], solutions: Set[Board]):Set[Board] = pieces match{
    case List() => solutions
    case p::ps => {
      val newBoard = findCandidatePosition(p,board,solutions).head
      if(newBoard.done){
        solution(newBoard,List(), solutions + newBoard)
      }else{
        solution(newBoard, ps, solutions)
      }
    }
  }

  /***
    *
    * @param chessPiece piece to be placed
    * @param board board in which to place the piece
    * @param solutions solutions that were already found
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


}

