package hu.rbandee.chess.pieces;

import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.chessboard.Square;

public class Bishop extends Piece {

	public Bishop(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(final Square newPosition) {
		boolean valid;
		if (newPosition.isFree() || isOpponent(newPosition)) {
			if (validStep(newPosition) && noBlock(newPosition)) {
				valid = true;
			} else {
				valid = false;
			}
		} else {
			valid = false;
		}
		return valid;
	}

	private boolean noBlock(Square newPosition) {
		return true;//TODO
	}

	private boolean validStep(Square newPosition) {
		boolean valid;
		if (Math.abs(newPosition.getColumn() - getPosition().getColumn()) == Math.abs(newPosition.getRow()
				- getPosition().getRow())) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	@Override
	public String toString() {
		return "B";
	}
}
