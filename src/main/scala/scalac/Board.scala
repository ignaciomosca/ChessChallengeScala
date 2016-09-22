package scalac

/**
  * Represents a ChessBoard
  * Created by ignacio on 05/09/16.
  */
case class Board(M: Int, N: Int, usedPieces: Set[ChessPiece], numberOfPieces: Int) {

  /***
    *
    * @param c ChessPiece to be placed in the board
    * @return true if
    */
  def isSafe(c: ChessPiece): Boolean = usedPieces.forall(p => !c.attacks(p) && !p.attacks(c))

  /***
    *
    * @param c ChessPiece to be placed in the board
    * @return a Board with ChessPiece c placed
    */
  def place(c: ChessPiece) = new Board(M, N, usedPieces+c, numberOfPieces)

  /***
    *
    * @param row
    * @param col
    * @return displays which piece is in position (row,col) if the position is empty it displays '_'
    */
  def findChessPiece(row: Int, col: Int):String = usedPieces.find(p => p.row==row && p.col==col).map(p => p.toString()).getOrElse("_")

  /***
    *
    * @return returns true if the chessboard is complete
    */
  def done = usedPieces.size == numberOfPieces

  /***
    * Displays the current ChessBoard
    */
  def show() = {
    for(x <- 1 to M){
      for(y <- 1 to N){
        print(findChessPiece(x,y))
      }
      println()
    }
    println()
  }

}
