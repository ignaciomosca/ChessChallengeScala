package scalac

/**
  * Created by ignacio on 05/09/16.
  */
class Board(M: Int, N: Int, usedPieces: List[ChessPiece]) {

  def getM = M
  def getN = N

  def isSafe(c: ChessPiece): Boolean = usedPieces.forall(p => !c.attacks(p) && !p.attacks(c))

  def place(c: ChessPiece) = new Board(M, N, c :: usedPieces)

}
