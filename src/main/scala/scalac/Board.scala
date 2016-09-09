package scalac

/**
  * Created by ignacio on 05/09/16.
  */
class Board(M: Int, N: Int, usedPieces: Set[ChessPiece]) {

  def getM = M
  def getN = N
  def getUsedPieces = usedPieces;

  def isSafe(c: ChessPiece): Boolean = usedPieces.forall(p => !c.attacks(p) && !p.attacks(c))

  def place(c: ChessPiece) = new Board(M, N, usedPieces+c)

  def findChessPiece(row: Int, col: Int):Char = usedPieces.find(p => p.row==row && p.col==col).map(p => p.piece()).getOrElse('_')

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
    val prime = 31
    var result = 1
    result = prime * result + this.getUsedPieces.hashCode();
    return result
  }

}
