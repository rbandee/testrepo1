package hu.rbandee.chess.pieces;

import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.chessboard.Square;

public class King extends Piece {

	public King(final Square startPositon, final Side side) {
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
		boolean columnIsOK = Math.abs(newPosition.getColumn() - getPosition().getColumn()) <= 1;
		boolean rowIsOK = Math.abs(newPosition.getRow() - getPosition().getRow()) <= 1;
		return columnIsOK && rowIsOK;
	}

	@Override
	public String toString() {
		return "K";
	}
}
