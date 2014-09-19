package hu.rbandee.chess.chessboard;

public class ChessBoard {
	static final String[] rowLetters = { "1", "2", "3", "4", "5", "6", "7", "8" };
	static final String[] columnLetters = { "a", "b", "c", "d", "e", "f", "g",
			"h" };
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

	public void clearBoard() {
		initEmptyBoard();
	}

	private void initBoardElement(final int row, final int column) {
		final boolean oddRow = row % 2 == 0;
		final boolean oddColumn = column % 2 == 0;
		if (oddRow && oddColumn || !oddRow && !oddColumn) {
			currentBoard[column][row] = BoardValues.EmptyBlack;
		} else {
			currentBoard[column][row] = BoardValues.EmptyWhite;
		}
	}

	public BoardValues getBoardValue(final int column, final int row) {
		return currentBoard[column][row];
	}

	public void printBoard() {
		printer.printBoard();
	}

	public void addPieceToBoard(final Piece newPiece) {
		newPiece.setMyBoard(this);
		final int column = newPiece.getPosition().getColumn();
		final int row = newPiece.getPosition().getRow();
		currentBoard[column][row] = newPiece.getType();
		printer.updateBoardLayout();
	}

	public Piece createNewPiece(final String fieldString, final Side side,
			final PieceType pieceType) {
		final Field field = new Field(fieldString);
		Piece newPiece;
		switch (pieceType) {
		case Bishop:
			newPiece = new Bishop(field, side);
			break;
		case King:
			newPiece = new King(field, side);
			break;
		case Knight:
			newPiece = new Knight(field, side);
			break;
		case Pawn:
			newPiece = new Pawn(field, side);
			break;
		case Queen:
			newPiece = new Queen(field, side);
			break;
		case Rook:
			newPiece = new Rook(field, side);
			break;
		default:
			throw new RuntimeException("Chess Piece (" + pieceType
					+ ") couldn't created on field " + field);
		}
		return newPiece;
	}

	public String getBoardLayoutInText() {
		return printer.getBoardLayoutInText();
	}

	public static String getRowLetter(final int column) {
		return rowLetters[column];
	}

	public boolean isFieldFree(final Field field) {
		boolean free;
		BoardValues value = currentBoard[field.getColumn()][field.getRow()];
		if (value == BoardValues.EmptyBlack || value == BoardValues.EmptyWhite) {
			free = true;
		} else {
			free = false;
		}
		return free;
	}
}
