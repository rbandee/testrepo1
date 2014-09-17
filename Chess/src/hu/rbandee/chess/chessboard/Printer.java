package hu.rbandee.chess.chessboard;

public class Printer {
	private static final String SEPARATORLINE = " |-------------------------------|";
	private static final String FRAMELINE = " +-------------------------------+";
	private static final String EMPTYWHITESQUARE = " ";
	private static final String EMPTYBLACKSQUARE = ".";
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
		String element;
		switch (myBoard.getBoardValue(row, column)) {
		case EmptyBlack:
			element = EMPTYBLACKSQUARE;
			break;
		case EmptyWhite:
			element = EMPTYWHITESQUARE;
			break;
		case BB:
			element = "B";
			break;
		case BK:
			element = "K";
			break;
		case BN:
			element = "N";
			break;
		case BP:
			element = "P";
			break;
		case BQ:
			element = "Q";
			break;
		case BR:
			element = "R";
			break;
		case WB:
			element = "B";
			break;
		case WK:
			element = "K";
			break;
		case WN:
			element = "N";
			break;
		case WP:
			element = "P";
			break;
		case WQ:
			element = "Q";
			break;
		case WR:
			element = "R";
			break;
		default:
			throw new RuntimeException("Invalid Board Value found in row "
					+ row + ", column " + column + "!");
		}
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
