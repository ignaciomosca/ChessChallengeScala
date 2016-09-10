package scalac

/**
  * Represents a ChessBoard
  * Created by ignacio on 05/09/16.
  */
class Board(M: Int, N: Int, usedPieces: Set[ChessPiece]) {

  def getM = M
  def getN = N
  def getUsedPieces = usedPieces;

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
  def place(c: ChessPiece) = new Board(M, N, usedPieces+c)

  /***
    *
    * @param row
    * @param col
    * @return displays which piece is in position (row,col) if the position is empty it displays '_'
    */
  def findChessPiece(row: Int, col: Int):Char = usedPieces.find(p => p.row==row && p.col==col).map(p => p.piece()).getOrElse('_')

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

  override def equals(that: Any): Boolean =
    that match {
      case that: Board => that.getUsedPieces.equals(this.getUsedPieces)
      case _ => false
    }
  override def hashCode: Int = {
    31 * this.getUsedPieces.hashCode();
  }

}
