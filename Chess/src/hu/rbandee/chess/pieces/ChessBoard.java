package hu.rbandee.chess.pieces;

public class ChessBoard {
	public final String[] defaultRow = new String[8];
	public final String rowNumbers = "   1   2   3   4   5   6   7   8";
	public final String[] colmumnNumbers = { "a", "b", "c", "d", "e", "f", "g",
			"h" };
	public final String separatorLine = " |-------------------------------|";
	public final String topLine = " +-------------------------------+";
	public final String emptyWhiteSquare = " ";
	public final String emptyBlackSquare = ".";

	private final BoardValues[][] currentBoard = new BoardValues[8][8];

	public ChessBoard() {
		initEmptyBoard();
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
		printEmptyline();
		printBoardHeader();
		printRow();
		printBoardFooter();
	}

	private void printEmptyline() {
		System.out.println();
	}

	private void printRow() {
		for (int row = 7; row >= 0; row--) {
			System.out.print(colmumnNumbers[row] + "|");
			printSquaresInRow(row);
			System.out.print(colmumnNumbers[row]);
			System.out.println();
			if (row != 0)
				System.out.println(separatorLine);
		}
	}

	private void printSquaresInRow(int row) {
		for (int column = 0; column < 8; column++) {
			System.out.print(" ");
			printElement(row, column);
			System.out.print(" |");
		}
	}

	private void printElement(int row, int column) {
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
		System.out.print(element);
	}

	private void printBoardHeader() {
		System.out.println(rowNumbers);
		System.out.println(topLine);
	}

	private void printBoardFooter() {
		System.out.println(topLine);
		System.out.println(rowNumbers);
	}

	public void addPieceToBoard(Piece piece) {
		String location = piece.getLocation();
		String name = piece.getMySign();
	}

	public Object getBoard() {
		return currentBoard;
	}
}
