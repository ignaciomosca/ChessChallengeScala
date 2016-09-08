package scalac

/**
  * Created by ignacio on 05/09/16.
  */
class Board(M: Int, N: Int, usedPieces: List[ChessPiece]) {

  def getM = M
  def getN = N

  def isSafe(c: ChessPiece): Boolean = usedPieces.forall(p => !c.attacks(p) && !p.attacks(c))

  def place(c: ChessPiece) = new Board(M, N, c :: usedPieces)

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

}
