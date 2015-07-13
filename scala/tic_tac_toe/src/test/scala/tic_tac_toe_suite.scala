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

    test("Claiming an unselected cell sets a X") {
        var game = new TicTacToe()
        game.claim(1)
        assert(game.board === List(10, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    test("Claiming an unselected cell switches the player") {
        var game = new TicTacToe()
        assert(game.player === "X")
        game.claim(1)
        assert(game.player === "O")
    }

}