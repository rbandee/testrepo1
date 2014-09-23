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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		if (color != other.color)
			return false;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
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
