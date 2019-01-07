package hu.rbandee.chess.pieces;

import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.chessboard.Square;

public class Knight extends Piece {

	public Knight(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(final Square newPosition) {
		boolean valid;
		if (newPosition.isFree() || isOpponent(newPosition)) {
			if (validStep(newPosition)) {
				valid = true;
			} else {
				valid = false;
			}
		} else {
			valid = false;
		}
		return valid;
	}

	private boolean validStep(Square newPosition) {
		int deltaColumn = Math.abs(newPosition.getColumn() - getPosition().getColumn());
		int deltaRow = Math.abs(newPosition.getRow() - getPosition().getRow());
		return (deltaColumn == 2 && deltaRow == 1) || (deltaColumn == 1 && deltaRow == 2);
	}

	@Override
	public String toString() {
		return "N";
	}
}
