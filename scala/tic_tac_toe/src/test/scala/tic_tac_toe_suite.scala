import org.scalatest._
import tictactoe._

class TicTacToeSuite extends FunSuite {

    test("Claiming an unselected cell with X the cell number sets the cell player to X") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(1)
        var cell = game.getCell(1)
        assert(cell.claimed == true)
        assert(cell.player == "X")
        (2 to 9).foreach { x => assert(game.cellClaimed(x) === false) }
    }

    test("Claiming an unselected cell with O the cell number sets the cell player to O") {
        var game = new TicTacToe()
        game.player = "O"
        game.claim(2)
        var cell = game.getCell(2)
        assert(cell.claimed == true)
        assert(cell.player == "O")
    }

    test("Claiming an unselected cell which doesnt result in a win doensnt set the winner") {
        var game = new TicTacToe()
        game.player = "X"
        assert(game.winner === "")
        game.claim(8)
        game.claim(9)
        assert(game.winner === "")
    }

    test("When current player is X, claiming an unselected cell switches current player to O") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(1)
        assert(game.player === "O")
    }

    
    test("When current player is O, claiming an unselected cell switches current player to X") {
        var game = new TicTacToe()
        game.player = "O"
        game.claim(1)
        assert(game.player === "X")
    }


    test("When claiming a selected cell the board doesnt change") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(1)
        game.player = "O"
        game.claim(1)
        var cell = game.getCell(1)
        assert(cell.claimed == true)
        assert(cell.player == "X")
        assert(game.player == "O")
    }

    
    test("When claiming a selected cell the current player doesnt change") {
        var game = new TicTacToe()
        game.player = "O"
        game.claim(1)
        game.player = "O"
        game.claim(1)
        assert(game.player === "O")
    }

    
    test("When X claims the top row the winner is set to X") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(1)
        game.player = "X"
        game.claim(2)
        game.player = "X"
        assert(game.winner === "")
        game.claim(3)
        assert(game.winner === "X")
    }

    test("When O claims the top row the winner is set to O") {
        var game = new TicTacToe()
        game.player = "O"
        game.claim(1)
        game.player = "O"
        game.claim(2)
        game.player = "O"
        assert(game.winner === "")
        game.claim(3)
        assert(game.winner === "O")
    }

    test("When X claims the middle row the winner is set to X") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(4)
        game.player = "X"
        game.claim(5)
        game.player = "X"
        assert(game.winner === "")
        game.claim(6)
        assert(game.winner === "X")
    }

    test("When X claims the bottom row the winner is set to X") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(7)
        game.player = "X"
        game.claim(8)
        game.player = "X"
        assert(game.winner === "")
        game.claim(9)
        assert(game.winner === "X")
    }

    test("When X claims the first column the winner is set to X") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(1)
        game.player = "X"
        game.claim(4)
        game.player = "X"
        assert(game.winner === "")
        game.claim(7)
        assert(game.winner === "X")
    }

    test("When X claims the second column the winner is set to X") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(2)
        game.player = "X"
        game.claim(5)
        game.player = "X"
        assert(game.winner === "")
        game.claim(8)
        assert(game.winner === "X")
    }

    test("When X claims the third column the winner is set to X") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(3)
        game.player = "X"
        game.claim(6)
        game.player = "X"
        assert(game.winner === "")
        game.claim(9)
        assert(game.winner === "X")
    }
}