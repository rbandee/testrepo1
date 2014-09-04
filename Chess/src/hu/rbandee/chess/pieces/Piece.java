package hu.rbandee.chess.pieces;

public abstract class Piece {
	private String position;

	public Piece(String startPositon) {
		position = startPositon;
	}

	public void move(String square) {
		if (isMoveValid(square))
			position = square;
	}

	public String getLocation() {
		return position;
	}

	public String getMySign() {
		return this.toString();
	}

	protected abstract boolean isMoveValid(String square);
}
