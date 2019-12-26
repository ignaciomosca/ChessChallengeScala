package scalac

import scala.util.{Failure, Success, Try}
import zio.UIO

/**
  * Created by ignacio on 06/09/16.
  */
object ChessUtils {
  /** *
    *
    * @param c   ChessPiece to be created
    * @param row in the board where the piece will be created
    * @param col in the board where the piece will be created
    * @return a ChessPiece placed in the board coordinates (row,col)
    */
  def createPiece(c: Piece, row: Int, col: Int): ChessPiece = c match {
    case KingPiece => King(row, col)
    case QueenPiece => Queen(row, col)
    case BishopPiece => Bishop(row, col)
    case KnightPiece => Knight(row, col)
    case RookPiece => Rook(row, col)
  }

  /** *
    *
    * @return a List of ChessPiece(s) based on the numbers of each piece provided by the user
    */
  def createListOfPieces(numberOfKings: Int, numberOfQueens: Int, numberOfBishops: Int, numberOfRooks: Int, numberOfKnights: Int): UIO[List[Piece]] = {
    val listOfKings = List.fill(numberOfKings)(KingPiece)
    val listOfQueens = List.fill(numberOfQueens)(QueenPiece)
    val listOfBishops = List.fill(numberOfBishops)(BishopPiece)
    val listOfRooks = List.fill(numberOfRooks)(RookPiece)
    val listOfKnights = List.fill(numberOfKnights)(KnightPiece)
    UIO.effectTotal(listOfKings ::: listOfQueens ::: listOfBishops ::: listOfRooks ::: listOfKnights)
  }
}
