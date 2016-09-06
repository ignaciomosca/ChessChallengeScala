#Chess Challenge

Below you will find the description of the problem. Using the agreed upon language (no special libraries are needed but you can use external ones if you feel such need), please provide an answer for the question at the end. You should be able to finish the assessment within one week. If you cannot find the solution, please do not worry; it’s not an easy task and we would like to see your thinking and problem solving abilities more than an accurate answer.

Please commit your code changes to Git repository (Github, Bitbucket, it's up to you. We would like to view the code afterwards in a browser and clone it to run it). By seeing your commits we grasp the way you work and by reviewing your code we learn more about your technical skills.

Afterwards you will receive solid feedback about your code and if everything is fine, you will be invited to the next stage. Please note that in case we are all good and ready to propose you to the best IT companies we work with, the code you will ship for this assessment will be presented to them too. That's why it's really important you will put your heart into it. Should you have any questions or concerns regarding the assessment, please do get in touch.

# Problem
The problem is to find all unique configurations of a set of normal chess pieces on a chess board with dimensions M×N where none of the pieces is in a position to take any of the others. Assume the colour of the piece does not matter, and that there are no pawns among the pieces.
Write a program which takes as input:
The dimensions of the board: M, N
The number of pieces of each type (King, Queen, Bishop, Rook and Knight) to try and place on the board.

As output, the program should list all the unique configurations to the console for which all of the pieces can be placed on the board without threatening each other.

When returning your solution, please provide with your answer the total number of unique configurations for a 7×7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight. Also provide the time it took to get the final score. Needless to say, the lower the time, the better.

# The Solution

I already solved this problem in [Java](https://github.com/ignaciomosca/ChessChallenge) so make no mistake, if the solution looks similar it's because it is!
The same approach, testing strategy and good practices were applied, only that because of the benefits of Scala, it looks much more elegant, collections are immutable by default, I have for-comprehensions that allow me to write less code, etc. 
The following solution is based on the [N-Queen Problem](https://developers.google.com/optimization/puzzles/queens) which is a well known optimization problem taught in Computer Science Classes. The proposed solution makes use of a technique called backtracking to find all the solutions to the problem.
Based on experience with previous problems, I reduced the current problem to an N-Queen problem with an 8x8 Board. I figured that after being able to get the solution for that problem, solving the rest of it was a matter of adding more pieces, determining how they moved, and writing unit tests for them.


# Dependencies

* Git
* Scala 2.11.8
* SBT


# Instructions

* git clone https://github.com/ignaciomosca/ChessChallenge.git
* cd ChessChallenge
* sbt compile
