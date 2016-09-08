package scalac

/**
  * Created by ignacio on 06/09/16.
  */
object ChessPieceUtils {
  def createPiece(c: ChessPiece, row: Int, col: Int): ChessPiece = c match {
    case c: King => King(row, col)
    case c: Queen => Queen(row, col)
    case c: Bishop => Bishop(row, col)
    case c: Knight => Knight(row, col)
    case c: Rook => Rook(row, col)
  }
}
