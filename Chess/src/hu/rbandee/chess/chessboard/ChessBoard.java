package hu.rbandee.chess.chessboard;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
	static final String[] rowLetters = { "1", "2", "3", "4", "5", "6", "7", "8" };
	static final String[] columnLetters = { "a", "b", "c", "d", "e", "f", "g",
			"h" };
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
				String keyToSquare = generateKey(row, column);
				Square newSquare = createSquare(row, column);
				if (keyToSquare.equals("a1")){
					newSquare.setPiece(new Rook(newSquare, Side.White));
				}
				if (keyToSquare.equals("A2")){
					newSquare.setPiece(new Bishop(newSquare, Side.White));
				}
				boardMap.put(keyToSquare, newSquare);
			}
		}
		System.out.println("A1: " + boardMap.get("A1"));
		System.out.println("A2: " + boardMap.get("A2"));
		System.out.println("B1: " + boardMap.get("B!"));
	}

	private String generateKey(int row, int column) {
		return columnLetters[column]+ rowLetters[row];
	}

	public void clearBoard() {
		initEmptyBoard();
	}

	private Square createSquare(final int row, final int column) {
		Square newSquare;
		final boolean oddRow = row % 2 == 0;
		final boolean oddColumn = column % 2 == 0;
		if (oddRow && oddColumn || !oddRow && !oddColumn) {
			newSquare = new Square(row, column, Color.Dark);
		} else {
			newSquare = new Square(row,  column, Color.Light);
		}
		return newSquare;
	}

	public Square getSquare(final int row, final int column) {
		return boardMap.get(generateKey(row, column));
	}
	
	public Square getSquare(final String initString) {
		return boardMap.get(initString);
	}

	public void printBoard() {
		printer.printBoard();
	}

	public Piece createNewPiece(final String squareString, final Side side,
			final PieceType pieceType) {
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
			throw new RuntimeException("Chess Piece (" + pieceType
					+ ") couldn't created on square " + square);
		}
		square.setPiece(newPiece);
		return newPiece;
	}

	public String getBoardLayoutInText() {
		return printer.getBoardLayoutInText();
	}

	public static String getRowLetter(final int column) {
		return rowLetters[column];
	}
}
