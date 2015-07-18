package tictactoe

class Cell {
  
  var player = ""
  var index = 0

  def this(index: Int) = {
    this();
    this.index = index;
  }

  def indexMatch(otherIndex: Integer):Boolean = {
    index == otherIndex
  }

  def claim(claimingPlayer: String):Boolean = {
    if (claimed) { return false }
    player = claimingPlayer
    true
  }

  def claimed(): Boolean = {
    player != ""
  }

  def unclaimed(): Boolean = {
    !claimed();
  }

  def claimedBy(targetPlayer: String):Boolean = { player == targetPlayer }

  def row():Int = { ((index-1) / 3).floor.toInt }
  def column():Int = { index % 3 }
}

class TicTacToe {

  var board = (1 to 9).map { x => new Cell(x) }
  var player = "X"
  var winner = ""

  def start() {
  }

  def claim(selection:Int):Boolean = {
    if (cellClaimed(selection)) { return false }

    // Take the cell
    board.find { x => x.indexMatch(selection) }.get.claim(player)
    
    // check if row is a winner
    

    if (isWinningRow || isWinningColumn || isWinningDiagonal) {
      winner = player
    }

    /*
    // check if column is a winner
    var columns = board
      .map{ case x => if (x == player_number) true else false }
      .groupedBy { _ % 3 }

    game_over = (columns.map { _ == List(true,true,true) }.filter{ _ == true }.length > 0)
    if (game_over) {
      winner = player
    }

    // switch user
    
    */

    switchPlayer()
    return true
  }

  def cellClaimed(cell_number:Int):Boolean = {
    getCell(cell_number).claimed
  }

  def getCell(cell_number: Int):Cell = {
    board.find { x => x.indexMatch(cell_number) }.get
  }

  def switchPlayer() = {
    player = if (player == "X") "O" else "X"
  }

  def isWinningRow():Boolean = {
    board
      .groupBy { _.row }
      .exists { 
        row => row._2.forall { 
          cell => cell.claimedBy(player) 
      } 
    }
  }

  def isWinningColumn():Boolean = {
    board.groupBy{ _.column }
    .exists {
      column => column._2.forall {
        cell => cell.claimedBy(player)
      }
    }
  }

  def isWinningDiagonal():Boolean = {
    var right_diagonal = List(3,5,7).map(x => getCell(x))
    var right_result = right_diagonal.forall {
      cell => cell.claimedBy(player)
    }
    var left_diagonal = List(1,5,9).map(x => getCell(x))
    var left_result = left_diagonal.forall {
      cell => cell.claimedBy(player)
    }
    right_result || left_result
  }
}
