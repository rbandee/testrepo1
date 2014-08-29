package hu.rbandee.chess.pieces;

public abstract class Piece {
	private String position;

	public void move(String square) {
		if (isMoveValid(square))
			position = square;
	}

	protected abstract boolean isMoveValid(String square);
}
