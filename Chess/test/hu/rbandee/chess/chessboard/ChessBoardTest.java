package hu.rbandee.chess.chessboard;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import org.testng.annotations.Test;

public class ChessBoardTest {

	@Test
	public void empty_chessboard() {
		final ChessBoard board = new ChessBoard();

		final String emptyChessBoard = "\n   a   b   c   d   e   f   g   h \n" + " +-------------------------------+\n"
				+ "8|   | . |   | . |   | . |   | . |8\n" + " |-------------------------------|\n"
				+ "7| . |   | . |   | . |   | . |   |7\n" + " |-------------------------------|\n"
				+ "6|   | . |   | . |   | . |   | . |6\n" + " |-------------------------------|\n"
				+ "5| . |   | . |   | . |   | . |   |5\n" + " |-------------------------------|\n"
				+ "4|   | . |   | . |   | . |   | . |4\n" + " |-------------------------------|\n"
				+ "3| . |   | . |   | . |   | . |   |3\n" + " |-------------------------------|\n"
				+ "2|   | . |   | . |   | . |   | . |2\n" + " |-------------------------------|\n"
				+ "1| . |   | . |   | . |   | . |   |1\n" + " +-------------------------------+\n"
				+ "   a   b   c   d   e   f   g   h \n";

		assertEquals(emptyChessBoard, board.getBoardLayoutInText());
	}

	@Test
	public void after_creating_chessboard_squares_are_initialized() {
		final ChessBoard board = new ChessBoard();
		Square firstSquare = board.getSquare("A1");
		assertNotNull(firstSquare);
		Square lastSquare = board.getSquare("H8");
		assertNotNull(lastSquare);
	}

	@Test
	public void first_square_is_dark() {
		final ChessBoard board = new ChessBoard();
		Square firstSquare = board.getSquare("A1");
		assertEquals(Color.Dark, firstSquare.getColor());
	}

	@Test
	public void second_square_is_light() {
		final ChessBoard board = new ChessBoard();
		Square firstSquare = board.getSquare("B1");
		assertEquals(Color.Light, firstSquare.getColor());
	}

	@Test
	public void both_getSquare_methods_gives_the_same_result() {
		final ChessBoard board = new ChessBoard();
		board.createNewPiece("E1", Side.White, PieceType.King);
		assertEquals(board.getSquare(4, 0), board.getSquare("E1"));
	}
}
