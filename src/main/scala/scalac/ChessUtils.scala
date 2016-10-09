package scalac

/**
  * Created by ignacio on 06/09/16.
  */
object ChessUtils {
  /***
    *
    * @param c ChessPiece to be created
    * @param row in the board where the piece will be created
    * @param col in the board where the piece will be created
    * @return a ChessPiece placed in the board coordinates (row,col)
    */
  def createPiece(c: ChessPiece, row: Int, col: Int): ChessPiece = c match {
    case c: King => King(row, col)
    case c: Queen => Queen(row, col)
    case c: Bishop => Bishop(row, col)
    case c: Knight => Knight(row, col)
    case c: Rook => Rook(row, col)
  }

  /***
    *
    * @return a List of ChessPiece(s) based on the numbers of each piece provided by the user
    */
  def createListOfPieces(numberOfKings: Int, numberOfQueens: Int, numberOfBishops: Int, numberOfRooks: Int, numberOfKnights:Int): List[ChessPiece]= {
    val listOfKings = List.fill(numberOfKings)(King(0,0))
    val listOfQueens = List.fill(numberOfQueens)(Queen(0,0))
    val listOfBishops = List.fill(numberOfBishops)(Bishop(0,0))
    val listOfRooks = List.fill(numberOfRooks)(Rook(0,0))
    val listOfKnights = List.fill(numberOfKnights)(Knight(0,0))
    listOfKings:::listOfQueens:::listOfBishops:::listOfRooks:::listOfKnights
  }

  /***
    *
    * @param function a Function to be timed
    * @return prints to console how much it took to execute
    */
  def timer[R](function: => R): R = {
    val start = System.currentTimeMillis()
    val result = function
    val finish = System.currentTimeMillis()
    println(s"Elapsed time: ${finish - start} ms")
    result
  }

  /***
    *
    * @param message message that gets displayed before requesting Input
    * @param function a Function to be executed
    * @return
    */
  def getInput[Int](message:String)(function: => Int): Int = {
    var i: Option[Int] = None
    do {
      println(message)
      i = try { Some(function) } catch { case _ => {println("Invalid Value. Please try again"); None} }
    } while (i == None)
    i.get
  }

}
