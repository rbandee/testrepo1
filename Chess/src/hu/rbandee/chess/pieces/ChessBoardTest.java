package hu.rbandee.chess.pieces;

import static org.testng.AssertJUnit.assertEquals;

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
}
