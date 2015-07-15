import org.scalatest._
import tictactoe._

class TicTacToeSuite extends FunSuite {

    test("Starting a game displays welcome message") {
        var game = new TicTacToe()
        game.start()
        var board = game.draw()
        assert(board.indexOf("1 2 3") === 0)
        assert(board.indexOf("4 5 6") === 1)
        assert(board.indexOf("7 8 9") === 2)
    }

    test("Claiming an unselected cell with X the cell number is replaced with X=10") {
        var game = new TicTacToe()
        game.player = "X"
        game.claim(1)
        assert(game.board === List(10, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    test("Claiming an unselected cell with O the cell number is replaced with O=11") {
        var game = new TicTacToe()
        game.player = "O"
        game.claim(2)
        assert(game.board === List(1, 11, 3, 4, 5, 6, 7, 8, 9))
    }

    test("Claiming an unselected cell which doesnt result in a win doensnt set the winner") {
        var game = new TicTacToe()
        game.board = List(1, 2, 3, 4, 5, 6, 7, 10, 9)
        game.player = "X"
        assert(game.winner === "")
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
        game.board = List(10, 2, 3, 4, 5, 6, 7, 8, 9)
        game.player = "O"
        game.claim(1)
        assert(game.board === List(10, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    test("When claiming a selected cell the current player doesnt change") {
        var game = new TicTacToe()
        game.board = List(10, 2, 3, 4, 5, 6, 7, 8, 9)
        game.player = "O"
        game.claim(1)
        assert(game.player === "O")
    }

    test("When X claims the top row the winner is set to X") {
        var game = new TicTacToe()
        game.board = List(10, 10, 3, 4, 5, 6, 7, 8, 9)
        game.player = "X"
        assert(game.winner === "")
        game.claim(3)
        assert(game.winner === "X")
    }

    test("When O claims the top row the winner is set to O") {
        var game = new TicTacToe()
        game.board = List(11, 11, 3, 4, 5, 6, 7, 8, 9)
        game.player = "O"
        assert(game.winner === "")
        game.claim(3)
        assert(game.winner === "O")
    }

    test("When X claims the middle row the winner is set to X") {
        var game = new TicTacToe()
        game.board = List(1, 2, 3, 10, 10, 6, 7, 8, 9)
        game.player = "X"
        assert(game.winner === "")
        game.claim(6)
        assert(game.winner === "X")
    }

    test("When X claims the bottom row the winner is set to X") {
        var game = new TicTacToe()
        game.board = List(1, 2, 3, 4, 5, 6, 10, 10, 9)
        game.player = "X"
        assert(game.winner === "")
        game.claim(9)
        assert(game.winner === "X")
    }

}