package hu.rbandee.chess.chessboard;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import org.testng.annotations.Test;

public class ChessBoardTest {

	@Test
	public void empty_chessboard() {
		final ChessBoard board = new ChessBoard();

		final String emptyChessBoard = "   1   2   3   4   5   6   7   8"
				+ " +-------------------------------+"
				+ "H|   | . |   | . |   | . |   | . |"
				+ " |-------------------------------|"
				+ "G| . |   | . |   | . |   | . |   |"
				+ " |-------------------------------|"
				+ "F|   | . |   | . |   | . |   | . |"
				+ " |-------------------------------|"
				+ "E| . |   | . |   | . |   | . |   |"
				+ " |-------------------------------|"
				+ "D|   | . |   | . |   | . |   | . |"
				+ " |-------------------------------|"
				+ "C| . |   | . |   | . |   | . |   |"
				+ " |-------------------------------|"
				+ "B|   | . |   | . |   | . |   | . |"
				+ " |-------------------------------|"
				+ "A| . |   | . |   | . |   | . |   |"
				+ " +-------------------------------+"
				+ "   1   2   3   4   5   6   7   8";

		assertEquals(emptyChessBoard, board.getBoardLayoutInText());
	}
	
	@Test
	public void after_creating_chessboard_squares_are_initialized(){
		final ChessBoard board = new ChessBoard();
		Square firstSquare = board.getSquare("A2");
		assertNotNull(firstSquare);
	}
	
	@Test
	public void first_square_is_dark(){
		final ChessBoard board = new ChessBoard();
		Square firstSquare = board.getSquare("A2");
		assertEquals(firstSquare.getColor(), Color.Dark);
	}
}
