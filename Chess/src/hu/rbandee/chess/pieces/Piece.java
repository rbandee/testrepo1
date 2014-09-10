package hu.rbandee.chess.pieces;

public abstract class Piece {
	private String position;
	protected BoardValues boardValue;

	public Piece(final String startPositon) {
		position = startPositon;
	}

	public void move(final String square) {
		if (isMoveValid(square)) {
			position = square;
		}
	}

	public String getLocation() {
		return position;
	}

	public BoardValues getType() {
		return boardValue;
	}

	protected abstract boolean isMoveValid(final String square);
}
