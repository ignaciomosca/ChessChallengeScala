package scalac

import scala.io.StdIn

/**
  * Created by ignacio on 08/10/16.
  */
object Main extends App {

  def addNPieces(n: Int, l: List[ChessPiece], c: ChessPiece): List[ChessPiece] = {
    l ::: List.fill(n)(c)
  }

  println("Define M")
  val M = StdIn.readInt()
  println("Define N")
  val N = StdIn.readInt()

  println("How many kings are to be placed on the board?")
  val kings = StdIn.readInt();
  println("How many queens are to be placed on the board?")
  val queens = StdIn.readInt();
  println("How many bishops are to be placed on the board?")
  val bishops = StdIn.readInt();
  println("How many rooks are to be placed on the board?")
  val rooks = StdIn.readInt();
  println("How many knights are to be placed on the board?")
  val knights = StdIn.readInt();

  var pieces = List[ChessPiece]()
  pieces = addNPieces(kings, pieces, King(0, 0))
  pieces = addNPieces(queens, pieces, Queen(0, 0))
  pieces = addNPieces(bishops, pieces, Bishop(0, 0))
  pieces = addNPieces(rooks, pieces, Rook(0, 0))
  pieces = addNPieces(knights, pieces, Knight(0, 0))

  val totalPieces = pieces.size

  val solutions = ChessChallengeSolver.solution(Board(M, N, Set(), totalPieces), pieces)

  solutions.map(_.show())
}


