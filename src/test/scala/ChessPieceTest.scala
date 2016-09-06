import org.scalatest.FunSuite

import scalac.{Bishop, King, Rook, Knight, Queen}

/**
  * Created by ignacio on 05/09/16.
  */

class ChessPieceTest extends FunSuite {

  test("test King movements") {
    assert(new King(5, 5).attacks(new King(5, 6)))
    assert(new King(5, 5).attacks(new King(6, 4)))
    assert(new King(5, 5).attacks(new King(5, 4)))
    assert(new King(5, 5).attacks(new King(4, 4)))
    assert(new King(5, 5).attacks(new King(4, 5)))
    assert(new King(5, 5).attacks(new King(4, 6)))
    assert(new King(5, 5).attacks(new King(5, 6)))
    assert(new King(5, 5).attacks(new King(6, 6)))
    assert(!new King(5, 5).attacks(new King(8, 8)))
  }

  test("test Bishop movements") {
    assert(new Bishop(5, 5).attacks(new Bishop(7, 7)))
    assert(new Bishop(5, 5).attacks(new Bishop(6, 6)))
    assert(new Bishop(5, 5).attacks(new Bishop(4, 6)))
    assert(new Bishop(5, 5).attacks(new Bishop(3, 7)))
    assert(new Bishop(5, 5).attacks(new Bishop(7, 3)))
    assert(new Bishop(5, 5).attacks(new Bishop(6, 4)))
    assert(new Bishop(5, 5).attacks(new Bishop(4, 4)))
    assert(new Bishop(5, 5).attacks(new Bishop(3, 3)))
    assert(!new Bishop(5, 5).attacks(new Bishop(8, 1)))
  }

  test("test Knight movements") {
    assert(new Knight(5, 5).attacks(new Knight(7, 6)))
    assert(new Knight(5, 5).attacks(new Knight(6, 7)))
    assert(new Knight(5, 5).attacks(new Knight(4, 7)))
    assert(new Knight(5, 5).attacks(new Knight(3, 6)))
    assert(new Knight(5, 5).attacks(new Knight(3, 4)))
    assert(new Knight(5, 5).attacks(new Knight(3, 4)))
    assert(new Knight(5, 5).attacks(new Knight(4, 3)))
    assert(new Knight(5, 5).attacks(new Knight(6, 3)))
    assert(!new Knight(5, 5).attacks(new Knight(8, 1)))
  }

  test("test Queen movements") {
    assert(new Queen(5, 5).attacks(new Queen(7, 7)))
    assert(new Queen(5, 5).attacks(new Queen(6, 6)))
    assert(new Queen(5, 5).attacks(new Queen(4, 6)))
    assert(new Queen(5, 5).attacks(new Queen(3, 7)))
    assert(new Queen(5, 5).attacks(new Queen(7, 3)))
    assert(new Queen(5, 5).attacks(new Queen(6, 4)))
    assert(new Queen(5, 5).attacks(new Queen(4, 4)))
    assert(new Queen(5, 5).attacks(new Queen(3, 3)))
    assert(new Queen(5, 5).attacks(new Queen(6, 5)))
    assert(new Queen(5, 5).attacks(new Queen(7, 5)))
    assert(new Queen(5, 5).attacks(new Queen(4, 5)))
    assert(new Queen(5, 5).attacks(new Queen(3, 5)))
    assert(new Queen(5, 5).attacks(new Queen(5, 6)))
    assert(new Queen(5, 5).attacks(new Queen(5, 7)))
    assert(new Queen(5, 5).attacks(new Queen(5, 4)))
    assert(new Queen(5, 5).attacks(new Queen(5, 3)))
    assert(!new Queen(1, 1).attacks(new Queen(3, 4)))
  }

  test("test Rook movements") {
    assert(new Rook(5, 5).attacks(new Rook(6, 5)))
    assert(new Rook(5, 5).attacks(new Rook(7, 5)))
    assert(new Rook(5, 5).attacks(new Rook(4, 5)))
    assert(new Rook(5, 5).attacks(new Rook(3, 5)))
    assert(new Rook(5, 5).attacks(new Rook(5, 6)))
    assert(new Rook(5, 5).attacks(new Rook(5, 7)))
    assert(new Rook(5, 5).attacks(new Rook(5, 4)))
    assert(new Rook(5, 5).attacks(new Rook(5, 3)))
    assert(!new Rook(5, 5).attacks(new Rook(7, 2)))
  }
}
