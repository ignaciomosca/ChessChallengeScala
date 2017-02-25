package scalac

/**
  * Represents a ChessBoard
  * Created by ignacio on 05/09/16.
  */
case class Board(M: Int, N: Int, usedPieces: Set[ChessPiece], numberOfPieces: Int) {

  /** *
    *
    * @param c ChessPiece to be placed in the board
    * @return true if
    */
  def isSafe(c: ChessPiece): Boolean = usedPieces.forall(p => !c.attacks(p) && !p.attacks(c))

  /** *
    *
    * @param c ChessPiece to be placed in the board
    * @return a Board with ChessPiece c placed
    */
  def place(c: ChessPiece): Board = Board(M, N, usedPieces + c, numberOfPieces)

  private def findChessPiece(row: Int, col: Int): String = usedPieces.find(p => p.row == row && p.col == col).map(_.toString()).getOrElse("_")

  /** *
    *
    * @return true if the chessboard is complete
    */
  def done = usedPieces.size == numberOfPieces

  /** *
    * Displays the current ChessBoard
    */
  def show(): String = {
    val rows = (for {
      x <- 1 to M
      y <- 1 to N
    } yield findChessPiece(x, y)).grouped(N).toList
    val board = for {
      row <- rows
    } yield row.mkString ++ "\n"
    board.flatten.mkString
  }

}
