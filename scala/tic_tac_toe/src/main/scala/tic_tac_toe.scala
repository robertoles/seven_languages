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
    var unclaimed_count = board.count { _  == selection }
    if (unclaimed_count != 0) {
      var player_number = if (player == "X") 10 else 11
      board = board.map { case `selection` => player_number; case x => x }
      player = if (player == "X") "O" else "X"
    }
  }
}
