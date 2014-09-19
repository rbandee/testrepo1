package hu.rbandee.chess.chessboard;

public class Square {
	private int row; //rank
	private int column; //file
	private Piece piece = null;
	private final Color color;

	private static final String EMPTYWHITESQUARE = " ";
	private static final String EMPTYBLACKSQUARE = ".";

	public Square(final String initString, final Color color){
		this.color = color;
	}

	public Square(final int row, final int column, final Color color){
		this.color = color;
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Color getColor() {
		return color;
	}

	public boolean isFree() {
		if (piece == null){
			return true;
		}else {
			return false;
		}
	}

	public Side getPieceSide() {
		return piece.getSide();
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	@Override
	public String toString() {
		String s = "";
		if (isFree() && color == Color.Dark){
			s = EMPTYBLACKSQUARE;
		} else if (isFree() && color == Color.Light){
			s = EMPTYWHITESQUARE;
		} else {
			s = piece.toString();
		}
		return s;
	}
}
