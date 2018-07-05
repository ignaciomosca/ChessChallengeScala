package scalac

import scala.io.StdIn
import scala.util.Try
import scalac.ChessUtils.timer
import scalac.ChessUtils.getInput

/**
  * Created by ignacio on 08/10/16.
  */
object Main extends App {

  println("Define M")
  val M = getInput {
    Try(StdIn.readInt())
  }
  println("Define N")
  val N = getInput {
    Try(StdIn.readInt())
  }

  println("How many kings are to be placed on the board?")
  val kings = getInput {
    Try(StdIn.readInt())
  }
  println("How many queens are to be placed on the board?")
  val queens = getInput {
    Try(StdIn.readInt())
  }
  println("How many bishops are to be placed on the board?")
  val bishops = getInput {
    Try(StdIn.readInt())
  }
  println("How many rooks are to be placed on the board?")
  val rooks = getInput {
    Try(StdIn.readInt())
  }
  println("How many knights are to be placed on the board?")
  val knights = getInput {
    Try(StdIn.readInt())
  }

  val pieces = ChessUtils.createListOfPieces(kings, queens, bishops, rooks, knights)
  val totalPieces = pieces.size

  val solutions = timer {
    val board = Board(M, N, Set(), totalPieces)
    ChessChallengeSolver.solution(board, pieces, Set(board))
  }
  println(s"Number of Solutions: ${solutions.size}")
}


