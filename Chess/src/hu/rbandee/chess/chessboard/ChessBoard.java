package hu.rbandee.chess.chessboard;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ChessBoard {
	static final String[] rowLetters = { "1", "2", "3", "4", "5", "6", "7", "8" };
	static final String[] columnLetters = { "a", "b", "c", "d", "e", "f", "g", "h" };
	private final Printer printer;

	private final Map<String, Square> boardMap = new HashMap<String, Square>();

	public ChessBoard() {
		initEmptyBoard();

		printer = new Printer(this);
		printer.createBoardLayout();
	}

	private void initEmptyBoard() {
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				String keyToSquare = generateKey(column, row);
				Square newSquare = createSquare(column, row);
				boardMap.put(keyToSquare, newSquare);
			}
		}
	}

	private String generateKey(final int column, final int row) {
		return columnLetters[column].toLowerCase(Locale.ENGLISH) + rowLetters[row];
	}

	public void clearBoard() {
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				String keyToSquare = generateKey(column, row);
				Square clearItsPiece = boardMap.get(keyToSquare);
				clearItsPiece.setPiece(null);
			}
		}
	}

	private Square createSquare(final int column, final int row) {
		Square newSquare;
		final boolean oddRow = row % 2 == 0;
		final boolean oddColumn = column % 2 == 0;
		if (oddRow && oddColumn || !oddRow && !oddColumn) {
			newSquare = new Square(column, row, Color.Dark);
		} else {
			newSquare = new Square(column, row, Color.Light);
		}
		return newSquare;
	}

	public Square getSquare(final int column, final int row) {
		return boardMap.get(generateKey(column, row));
	}

	public Square getSquare(final String key) {
		return boardMap.get(key.toLowerCase(Locale.ENGLISH));
	}

	public void printBoard() {
		printer.printBoard();
	}

	public Piece createNewPiece(final String squareString, final Side side, final PieceType pieceType) {
		final Square square = getSquare(squareString);
		Piece newPiece;
		switch (pieceType) {
		case Bishop:
			newPiece = new Bishop(square, side);
			break;
		case King:
			newPiece = new King(square, side);
			break;
		case Knight:
			newPiece = new Knight(square, side);
			break;
		case Pawn:
			newPiece = new Pawn(square, side);
			break;
		case Queen:
			newPiece = new Queen(square, side);
			break;
		case Rook:
			newPiece = new Rook(square, side);
			break;
		default:
			throw new RuntimeException("Chess Piece (" + pieceType + ") couldn't created on square " + square);
		}
		square.setPiece(newPiece);
		return newPiece;
	}

	public String getBoardLayoutInText() {
		return printer.getBoardLayoutInText();
	}

	public static String getRowLetter(final int row) {
		return rowLetters[row];
	}
}
