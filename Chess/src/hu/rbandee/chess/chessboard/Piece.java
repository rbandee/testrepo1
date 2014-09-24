package hu.rbandee.chess.chessboard;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
	private Square position;
	private final Side side;

	public Piece(final Square startPositon, Side side) {
		position = startPositon;
		this.side = side;
	}

	public void move(final Square newPosition) {
		if (isMoveValid(newPosition)) {
			position = newPosition;
		}
	}

	public Square getPosition() {
		return position;
	}

	protected abstract boolean isMoveValid(final Square newPosition);

	public List<Square> getAvailabeSquares() {
		List<Square> allPossibleSquares = new ArrayList<Square>();

		return allPossibleSquares;
	}

	public Side getSide() {
		Side side;
		if (isWhite()) {
			side = Side.White;
		} else {
			side = Side.Black;
		}
		return side;
	}

	public boolean isWhite() {
		return side == Side.White;
	}

	public boolean isBlack() {
		return side == Side.Black;
	}

	@Override
	public abstract String toString();
}
