package scalac

import scala.io.StdIn
import scalac.ChessPieceUtils.timer

/**
  * Created by ignacio on 08/10/16.
  */
object Main extends App {

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

  val pieces = ChessPieceUtils.createListOfPieces(kings, queens, bishops, rooks, knights)

  val totalPieces = pieces.size

  val solutions = timer {
    ChessChallengeSolver.solution(Board(M, N, Set(), totalPieces), pieces)
  }

  solutions.map(_.show())
}


