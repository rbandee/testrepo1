package hu.rbandee.chess.pieces;

import java.util.Arrays;
import java.util.Locale;

public class ChessBoard {
	static final String[] columnLetters = { "1", "2", "3", "4", "5", "6", "7",
			"8" };
	static final String[] rowLetters = { "a", "b", "c", "d", "e", "f", "g", "h" };
	private final Printer printer;

	private final BoardValues[][] currentBoard = new BoardValues[8][8];

	public ChessBoard() {
		initEmptyBoard();

		printer = new Printer(this);
		printer.createBoardLayout();
	}

	private void initEmptyBoard() {
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				initBoardElement(row, column);
			}
		}
	}

	private void initBoardElement(final int row, final int column) {
		final boolean oddRow = row % 2 == 0;
		final boolean oddColumn = column % 2 == 0;
		if (oddRow && oddColumn || !oddRow && !oddColumn) {
			currentBoard[row][column] = BoardValues.EmptyBlack;
		} else {
			currentBoard[row][column] = BoardValues.EmptyWhite;
		}
	}

	public BoardValues getBoardValue(final int row, final int column) {
		return currentBoard[row][column];
	}

	public void printBoard() {
		printer.printBoard();
	}

	public void addPieceToBoard(final Piece piece) {
		final String location = piece.getLocation();
		final int row = Integer.parseInt(location.substring(1)) - 1;
		final int column = getColumnNumber(location.substring(0, 1));

		currentBoard[column][row] = piece.getType();
		printer.createBoardLayout();
	}

	private int getColumnNumber(final String letter) {
		return Arrays.binarySearch(rowLetters,
				letter.toLowerCase(Locale.ENGLISH));
	}

	public String getBoardLayoutInText() {
		return printer.getBoardLayoutInText();
	}

	public static String getRowLetter(final int column) {
		return rowLetters[column];
	}
}
