package tictactoe

class TicTacToe {

  var board = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  var player = "X"

  def start() {
  }

  def draw() = {
    List("1 2 3", "4 5 6", "7 8 9")
  }

  def claim(selection:Int) {
    board = board.map { case `selection` => 10; case x => x }
    player = "O"
  }


}