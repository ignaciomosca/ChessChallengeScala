# Chess Challenge

# Problem
The problem is to find all unique configurations of a set of normal chess pieces on a chess board with dimensions MxN where none of the pieces is in a position to take any of the others. Assume the colour of the piece does not matter, and that there are no pawns among the pieces.
Write a program which takes as input:
The dimensions of the board: M, N
The number of pieces of each type (King, Queen, Bishop, Rook and Knight) to try and place on the board.

As output, the program should list all the unique configurations to the console for which all of the pieces can be placed on the board without threatening each other.

When returning your solution, please provide with your answer the total number of unique configurations for a 7x7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight. Also provide the time it took to get the final score. Needless to say, the lower the time, the better.

# The Solution

[I already solved this problem in Java](https://github.com/ignaciomosca/ChessChallenge) so make no mistake, if the solution looks similar it's because it is! The algorithm itself is a little different because it uses tail recursion.
The same testing strategy and good practices were applied, only that because of the benefits of Scala, it looks much more elegant, collections are immutable by default, I have for-comprehensions that allow me to write less code, etc. 
The following solution is based on the [N-Queen Problem](https://developers.google.com/optimization/puzzles/queens) which is a well known optimization problem taught in Computer Science Classes. The proposed solution makes use of a technique called backtracking to find all the solutions to the problem.
Based on experience with previous problems, I reduced the current problem to an N-Queen problem with an 8x8 Board. I figured that after being able to get the solution for that problem, solving the rest of it was a matter of adding more pieces, determining how they moved, and writing unit tests for them.


# Dependencies

* Git
* Scala 2.11.8
* SBT


# Instructions

* git clone https://ignaciomosca@bitbucket.org/ignaciomosca/chesschallengescala.git
* cd chesschallengescala
* sbt compile
* sbt test

To run the program with custom configurations just open a terminal a run

* sbt run `(and then follow the wizard)`
