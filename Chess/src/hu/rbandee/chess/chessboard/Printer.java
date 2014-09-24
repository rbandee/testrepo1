package hu.rbandee.chess.chessboard;

public class Printer {
	private static final String SEPARATORLINE = " |-------------------------------|";
	private static final String FRAMELINE = " +-------------------------------+";
	private static final String NEWLINE = System.getProperty("line.separator");
	private static final String EMPTYWHITESQUARE = " ";
	private static final String EMPTYBLACKSQUARE = ".";

	private final ChessBoard myBoard;
	private StringBuilder boardLayout = new StringBuilder(700);

	public Printer(final ChessBoard board) {
		myBoard = board;
	}

	public void createBoardLayout() {
		addEmptyline();
		addHeader();
		addRow();
		addFooter();
	}

	private void addEmptyline() {
		boardLayout.append(NEWLINE);
	}

	private void addRow() {
		for (int row = 7; row >= 0; row--) {
			boardLayout.append(ChessBoard.getRowLetter(row)).append('|');
			addSquaresInRow(row);
			boardLayout.append(ChessBoard.getRowLetter(row));
			addEmptyline();
			if (notTheLast(row)) {
				boardLayout.append(SEPARATORLINE).append(NEWLINE);
			}
		}
	}

	private boolean notTheLast(final int row) {
		return row != 0;
	}

	private void addSquaresInRow(final int row) {
		for (int column = 0; column < 8; column++) {
			boardLayout.append(' ');
			addElement(column, row);
			boardLayout.append(" |");
		}
	}

	private void addElement(final int column, final int row) {
		Square square = myBoard.getSquare(column, row);
		String element = getSignOfPiece(square);
		boardLayout.append(element);
	}

	private String getSignOfPiece(Square square) {
		String s = "";
		if (square.isFree() && square.getColor() == Color.Dark) {
			s = EMPTYBLACKSQUARE;
		} else if (square.isFree() && square.getColor() == Color.Light) {
			s = EMPTYWHITESQUARE;
		} else {
			s = square.getPiece().toString();
		}
		return s;
	}

	private void addHeader() {
		boardLayout.append(getColumnLine());
		addEmptyline();
		boardLayout.append(FRAMELINE);
		addEmptyline();
	}

	private String getColumnLine() {
		String line = " ";
		for (final String columnLetter : ChessBoard.columnLetters) {
			line += "  " + columnLetter + " ";
		}
		return line;
	}

	private void addFooter() {
		boardLayout.append(FRAMELINE);
		addEmptyline();
		boardLayout.append(getColumnLine());
		addEmptyline();
	}

	public void printBoard() {
		refreshLayout();
		System.out.println(boardLayout.toString());
	}

	public String getBoardLayoutInText() {
		return boardLayout.toString();
	}

	public void refreshLayout() {
		boardLayout = new StringBuilder(700);
		createBoardLayout();
	}

	public void updateBoardLayout() {
		//TODO rewrite this to only update not regenereate the whole board
		createBoardLayout();
	}
}
