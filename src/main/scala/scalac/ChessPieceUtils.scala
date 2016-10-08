package scalac

/**
  * Created by ignacio on 06/09/16.
  */
object ChessPieceUtils {
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
    * @param n number of pieces to be added
    * @param l list in which it will be added
    * @param c ChessPiece to be added
    * @return a new List with n ChessPieces(s) added to it
    */
  def addNPieces(n: Int, l: List[ChessPiece], c: ChessPiece): List[ChessPiece] = {
    l ::: List.fill(n)(c)
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

}
