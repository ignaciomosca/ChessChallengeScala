package scalac

import scala.io.StdIn
import scalac.ChessUtils.timer
import scalac.ChessUtils.getInput

/**
  * Created by ignacio on 08/10/16.
  */
object Main extends App {

  val M = getInput("Define M") {StdIn.readInt()}
  val N = getInput("Define N") {StdIn.readInt()}

  val kings = getInput("How many kings are to be placed on the board?") {StdIn.readInt()}
  val queens = getInput("How many queens are to be placed on the board?") {StdIn.readInt()}
  val bishops = getInput("How many bishops are to be placed on the board?") {StdIn.readInt()}
  val rooks = getInput("How many rooks are to be placed on the board?") {StdIn.readInt()}
  val knights = getInput("How many knights are to be placed on the board?") {StdIn.readInt()}

  val pieces = ChessUtils.createListOfPieces(kings, queens, bishops, rooks, knights)
  val totalPieces = pieces.size

  val solutions = timer {
    ChessChallengeSolver.solution(Board(M, N, Set(), totalPieces), pieces)
  }
  println(s"Number of Solutions: ${solutions.size}")
}


