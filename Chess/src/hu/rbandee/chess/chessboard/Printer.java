package hu.rbandee.chess.chessboard;

public class Printer {
	private static final String SEPARATORLINE = " |-------------------------------|";
	private static final String FRAMELINE = " +-------------------------------+";
	private static final String NEWLINE = System.getProperty("line.separator");

	private final ChessBoard myBoard;
	private final StringBuilder boardLayout = new StringBuilder(700);

	public Printer(final ChessBoard board) {
		myBoard = board;
	}

	public void createBoardLayout() {
		addEmptylineToLayout();
		addBoardHeaderToLayout();
		addRowToLayout();
		addBoardFooterToLayout();
	}

	private void addEmptylineToLayout() {
		boardLayout.append(NEWLINE);
	}

	private void addRowToLayout() {
		for (int row = 7; row >= 0; row--) {
			boardLayout.append(ChessBoard.getRowLetter(row)).append('|');
			addSquaresInRowToLayout(row);
			boardLayout.append(ChessBoard.getRowLetter(row));
			addEmptylineToLayout();
			if (notTheLast(row)) {
				boardLayout.append(SEPARATORLINE).append(NEWLINE);
			}
		}
	}

	private boolean notTheLast(final int row) {
		return row != 0;
	}

	private void addSquaresInRowToLayout(final int row) {
		for (int column = 0; column < 8; column++) {
			boardLayout.append(' ');
			addElementToLayout(row, column);
			boardLayout.append(" |");
		}
	}

	private void addElementToLayout(final int row, final int column) {
		String element = myBoard.getSquare(row, column).toString();
		boardLayout.append(element);
	}

	private void addBoardHeaderToLayout() {
		boardLayout.append(getColumnLine());
		addEmptylineToLayout();
		boardLayout.append(FRAMELINE);
		addEmptylineToLayout();
	}

	private String getColumnLine() {
		String line = " ";
		for (final String columnLetter : ChessBoard.columnLetters) {
			line += "  " + columnLetter + " ";
		}
		return line;
	}

	private void addBoardFooterToLayout() {
		boardLayout.append(FRAMELINE);
		addEmptylineToLayout();
		boardLayout.append(getColumnLine());
		addEmptylineToLayout();
	}

	public void printBoard() {
		System.out.println(boardLayout.toString());
	}

	public String getBoardLayoutInText() {
		return boardLayout.toString();
	}

	public void updateBoardLayout() {
		//TODO rewrite this to onli update not regenereate the whole board
		createBoardLayout();
	}
}
