package scalac

import scala.io.StdIn
import scala.util.Try
import zio._
import zio.console._
import java.io.IOException

/**
  * Created by ignacio on 08/10/16.
  */
object Main extends App {

  private def inputNumber(number: String) = {
    ZIO
    .effect(number.toInt)
    .filterOrFail(_>=0)(new IOException("Invalid input"))
  }

  private def getInput(message: String):ZIO[Console, IOException, Int] = (for {
    _ <- putStrLn(message)
    input <- getStrLn
    number <- inputNumber(input)
  } yield number) orElse (putStrLn("Invalid Input") *> getInput(message))

  def run(args: List[String]) = (for {
    m <- getInput("Define M")
    n <- getInput("Define N")
    kings <- getInput("How many kings are to be placed on the board?")
    queens <- getInput("How many queens are to be placed on the board?")
    bishops <- getInput("How many bishops are to be placed on the board?")
    rooks <- getInput("How many rooks are to be placed on the board?")
    knights <- getInput("How many knights are to be placed on the board?")
    pieces = ChessUtils.createListOfPieces(kings, queens, bishops, rooks, knights)
    totalPieces = pieces.size
    board = Board(m,n, Set(), totalPieces)
    start = System.currentTimeMillis()
    solutions = ChessChallengeSolver.solution(board, pieces, Set(board))
    val finish = System.currentTimeMillis()
    _ <- putStrLn(s"Number of Solutions: ${solutions.size}. Elapsed time: ${finish - start} ms")
  } yield ()).run *> IO.succeed(0)


}