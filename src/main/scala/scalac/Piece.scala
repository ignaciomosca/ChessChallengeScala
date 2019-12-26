package scalac

sealed trait Piece
case object KingPiece extends Piece
case object QueenPiece extends Piece
case object BishopPiece extends Piece
case object RookPiece extends Piece
case object KnightPiece extends Piece    