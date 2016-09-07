package scalac

/**
  * Created by ignacio on 05/09/16.
  */
class Board(M: Int, N: Int, pieces: List[ChessPiece], usedPieces: List[ChessPiece]) {

  def getM = M
  def getN = N

  def isSafe(c: ChessPiece): Boolean = usedPieces.foldLeft(true)((acc, p) => !c.attacks(p) && !p.attacks(c) && acc)

  def place(c: ChessPiece) = new Board(M, N, pieces, c :: usedPieces)

}
