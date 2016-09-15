import org.scalatest.FunSuite

import scalac.{Bishop, King, Rook, Knight, Queen}

/**
  * Tests the valid and invalid movements of each ChessPiece
  * Created by ignacio on 05/09/16.
  */

class ChessPieceTest extends FunSuite {

  test("test King movements") {
    assert(King(5, 5).attacks(King(5, 6)))
    assert(King(5, 5).attacks(King(6, 4)))
    assert(King(5, 5).attacks(King(5, 4)))
    assert(King(5, 5).attacks(King(4, 4)))
    assert(King(5, 5).attacks(King(4, 5)))
    assert(King(5, 5).attacks(King(4, 6)))
    assert(King(5, 5).attacks(King(5, 6)))
    assert(King(5, 5).attacks(King(6, 6)))
    assert(!King(5, 5).attacks(King(8, 8)))
  }

  test("test Bishop movements") {
    assert(Bishop(5, 5).attacks(Bishop(7, 7)))
    assert(Bishop(5, 5).attacks(Bishop(6, 6)))
    assert(Bishop(5, 5).attacks(Bishop(4, 6)))
    assert(Bishop(5, 5).attacks(Bishop(3, 7)))
    assert(Bishop(5, 5).attacks(Bishop(7, 3)))
    assert(Bishop(5, 5).attacks(Bishop(6, 4)))
    assert(Bishop(5, 5).attacks(Bishop(4, 4)))
    assert(Bishop(5, 5).attacks(Bishop(3, 3)))
    assert(!Bishop(5, 5).attacks(Bishop(8, 1)))
  }

  test("test Knight movements") {
    assert(Knight(5, 5).attacks(Knight(7, 6)))
    assert(Knight(5, 5).attacks(Knight(6, 7)))
    assert(Knight(5, 5).attacks(Knight(4, 7)))
    assert(Knight(5, 5).attacks(Knight(3, 6)))
    assert(Knight(5, 5).attacks(Knight(3, 4)))
    assert(Knight(5, 5).attacks(Knight(3, 4)))
    assert(Knight(5, 5).attacks(Knight(4, 3)))
    assert(Knight(5, 5).attacks(Knight(6, 3)))
    assert(!Knight(5, 5).attacks(Knight(8, 1)))
  }

  test("test Queen movements") {
    assert(Queen(5, 5).attacks(Queen(7, 7)))
    assert(Queen(5, 5).attacks(Queen(6, 6)))
    assert(Queen(5, 5).attacks(Queen(4, 6)))
    assert(Queen(5, 5).attacks(Queen(3, 7)))
    assert(Queen(5, 5).attacks(Queen(7, 3)))
    assert(Queen(5, 5).attacks(Queen(6, 4)))
    assert(Queen(5, 5).attacks(Queen(4, 4)))
    assert(Queen(5, 5).attacks(Queen(3, 3)))
    assert(Queen(5, 5).attacks(Queen(6, 5)))
    assert(Queen(5, 5).attacks(Queen(7, 5)))
    assert(Queen(5, 5).attacks(Queen(4, 5)))
    assert(Queen(5, 5).attacks(Queen(3, 5)))
    assert(Queen(5, 5).attacks(Queen(5, 6)))
    assert(Queen(5, 5).attacks(Queen(5, 7)))
    assert(Queen(5, 5).attacks(Queen(5, 4)))
    assert(Queen(5, 5).attacks(Queen(5, 3)))
    assert(!Queen(1, 1).attacks(Queen(3, 4)))
  }

  test("test Rook movements") {
    assert(Rook(5, 5).attacks(Rook(6, 5)))
    assert(Rook(5, 5).attacks(Rook(7, 5)))
    assert(Rook(5, 5).attacks(Rook(4, 5)))
    assert(Rook(5, 5).attacks(Rook(3, 5)))
    assert(Rook(5, 5).attacks(Rook(5, 6)))
    assert(Rook(5, 5).attacks(Rook(5, 7)))
    assert(Rook(5, 5).attacks(Rook(5, 4)))
    assert(Rook(5, 5).attacks(Rook(5, 3)))
    assert(!Rook(5, 5).attacks(Rook(7, 2)))
  }
}
