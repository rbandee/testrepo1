package hu.rbandee.chess.pieces;

public class ChessBoard {
	private static final String rowNumbers = "   1   2   3   4   5   6   7   8";
	private static final String[] columnNumbers = { "a", "b", "c", "d", "e",
			"f", "g", "h" };
	private static final String separatorLine = " |-------------------------------|";
	private static final String topLine = " +-------------------------------+";
	private static final String emptyWhiteSquare = " ";
	private static final String emptyBlackSquare = ".";

	private final BoardValues[][] currentBoard = new BoardValues[8][8];

	private final StringBuilder boardLayoutInTextBuilder = new StringBuilder(
			700);

	public ChessBoard() {
		initEmptyBoard();
		createBoardLayoutInText();
	}

	private void initEmptyBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				boolean oddRow = (i % 2 == 0);
				boolean oddColumn = (j % 2 == 0);

				if (oddRow && oddColumn || !oddRow && !oddColumn) {
					currentBoard[i][j] = BoardValues.EmptyBlack;
				} else {
					currentBoard[i][j] = BoardValues.EmptyWhite;
				}
			}
		}
	}

	public void printBoard() {
		System.out.println(boardLayoutInTextBuilder.toString());
	}

	public void createBoardLayoutInText() {
		addEmptylineToLayout();
		addtBoardHeaderToLayout();
		addRowToLayout();
		addBoardFooterToLayout();
	}

	private void addEmptylineToLayout() {
		boardLayoutInTextBuilder.append("\n");
	}

	private void addRowToLayout() {
		for (int row = 7; row >= 0; row--) {
			boardLayoutInTextBuilder.append(columnNumbers[row]).append("|");
			addSquaresInRowToLayout(row);
			boardLayoutInTextBuilder.append(columnNumbers[row]);
			addEmptylineToLayout();
			if (row != 0)
				boardLayoutInTextBuilder.append(separatorLine).append("\n");
		}
	}

	private void addSquaresInRowToLayout(int row) {
		for (int column = 0; column < 8; column++) {
			boardLayoutInTextBuilder.append(" ");
			addElementToLayout(row, column);
			boardLayoutInTextBuilder.append(" |");
		}
	}

	private void addElementToLayout(int row, int column) {
		String element = "";
		switch (currentBoard[row][column]) {
		case EmptyBlack:
			element = emptyBlackSquare;
			break;
		case EmptyWhite:
			element = emptyWhiteSquare;
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
		}
		boardLayoutInTextBuilder.append(element);
	}

	private void addtBoardHeaderToLayout() {
		boardLayoutInTextBuilder.append(rowNumbers);
		addEmptylineToLayout();
		boardLayoutInTextBuilder.append(topLine);
		addEmptylineToLayout();
	}

	private void addBoardFooterToLayout() {
		boardLayoutInTextBuilder.append(topLine);
		addEmptylineToLayout();
		boardLayoutInTextBuilder.append(rowNumbers);
		addEmptylineToLayout();
	}

	public void addPieceToBoard(Piece piece) {
		String location = piece.getLocation();
		String columnString = location.substring(0, 1);
		String rowString = location.substring(1);

		int row = Integer.parseInt(rowString) - 1;
		int column = getColumnNumberFromLetter(columnString.toLowerCase());

		currentBoard[column][row] = piece.getType();
		createBoardLayoutInText();
	}

	private int getColumnNumberFromLetter(String letter) {
		int column = 0;
		for (int i = 0; i < columnNumbers.length; i++) {
			if (columnNumbers[i].equals(letter)) {
				column = i;
				break;
			}
		}

		return column;
	}

	public String getBoardLayoutInText() {
		return boardLayoutInTextBuilder.toString();
	}
}
