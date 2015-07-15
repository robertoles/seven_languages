package tictactoe

class TicTacToe {

  var board = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  var player = "X"
  var winner = ""

  def start() {
  }

  def draw() = {
    List("1 2 3", "4 5 6", "7 8 9")
  }

  def claim(selection:Int):Boolean = {
    var unclaimed_count = board.count { _  == selection }
    if (unclaimed_count == 0) { return false }

    // Take the cell
    var player_number = if (player == "X") 10 else 11
    board = board.map { case `selection` => player_number; case x => x }
    
    // check if first row is a winner
    var rows = board
      .map{ case x => if (x == player_number) true else false }
      .grouped(3)

    var game_over = rows.map { _ == List(true,true,true) }.filter{ _ == true }.length > 0
    if (game_over) {
      winner = player
    }

    // switch user
    player = if (player == "X") "O" else "X"
    return true
  }
}
