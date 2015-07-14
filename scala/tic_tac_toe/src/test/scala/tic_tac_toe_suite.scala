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
        assert(game.board == List(10, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    test("When claiming a selected cell the current player doesnt change") {
        var game = new TicTacToe()
        game.board = List(10, 2, 3, 4, 5, 6, 7, 8, 9)
        game.player = "O"
        game.claim(1)
        assert(game.player == "O")
    }

}