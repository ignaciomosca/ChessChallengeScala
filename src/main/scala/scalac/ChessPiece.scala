package scalac

/**
  * Represents the ChessPieces, the way they show in the ChessBoard and the way they attack
  * I thought about using a trait and an abstract class, but because a Trait already defines a type, using both was useless
  * Created by ignacio on 05/09/16.
  */
sealed trait ChessPiece {
  def row: Int

  def col: Int

  def attacks(c: ChessPiece): Boolean

  def piece(): Char
}

case class King(row: Int, col: Int) extends ChessPiece {
  val directions = List(-1, 1, 0)
  val moves = for (x <- directions; y <- directions) yield (row + x, col + y)

  override def attacks(c: ChessPiece): Boolean = {
    moves.contains((c.row, c.col))
  }

  override def piece(): Char = 'K'
}

case class Queen(row: Int, col: Int) extends ChessPiece {
  override def attacks(c: ChessPiece): Boolean = c.row == row || c.col == col || Math.abs(c.row - row) == Math.abs(c.col - col)

  override def piece(): Char = 'Q'
}

case class Bishop(row: Int, col: Int) extends ChessPiece {
  override def attacks(c: ChessPiece): Boolean = Math.abs(c.row - row) == Math.abs(c.col - col)

  override def piece(): Char = 'B'
}

case class Knight(row: Int, col: Int) extends ChessPiece {
  val directions = List(-2, -1, 1, 2)
  val moves = for (x <- directions; y <- directions; if (Math.abs(x) != Math.abs(y))) yield (row + x, col + y)

  override def attacks(c: ChessPiece): Boolean = moves.contains((c.row, c.col))

  override def piece(): Char = 'N'
}

case class Rook(row: Int, col: Int) extends ChessPiece {
  override def attacks(c: ChessPiece): Boolean = c.row == row || c.col == col

  override def piece(): Char = 'R'
}



