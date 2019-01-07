package hu.rbandee.chess.pieces;

import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.chessboard.Square;

public class Pawn extends Piece {

	public Pawn(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(final Square newPosititon) {
		boolean valid;
		if (newPosititon.isFree()) {
			if (oneStepAhead(newPosititon) || initialTwoSteps(newPosititon)) {
				valid = true;
			} else {
				valid = false;
			}
		} else if (isOpponent(newPosititon)) {
			if (capture(newPosititon)) {
				valid = true;
			} else {
				valid = false;
			}

		} else {
			valid = false;
		}

		return valid;
	}

	private boolean capture(final Square newPosition) {
		return oneStep(newPosition) && adjacent(newPosition);
	}

	private boolean initialTwoSteps(final Square newPosition) {
		return straightAhead(newPosition) && twoStep(newPosition);
	}

	private boolean oneStepAhead(final Square newPosition) {
		return straightAhead(newPosition) && oneStep(newPosition);
	}

	private boolean twoStep(Square newPosition) {
		return (isWhite() && (getPosition().getRow() == 1) && ((newPosition.getRow() - 2) == getPosition()
				.getRow()))
				|| (isBlack() && (getPosition().getRow() == 6) && ((newPosition
						.getRow() + 2) == getPosition().getRow()));
	}

	private boolean adjacent(Square newPosition) {
		boolean result;
		int col = getPosition().getColumn();
		int toCol = newPosition.getColumn();

		if ((col - 1 >= 0 && col - 1 == toCol)
				|| (col + 1 < 8 && col + 1 == toCol)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	private boolean oneStep(Square newPosition) {
		return (isWhite() && newPosition.getRow() - 1 == getPosition().getRow())
				|| (isBlack() && newPosition.getRow() + 1 == getPosition().getRow());
	}

	private boolean straightAhead(final Square newPosition) {
		return newPosition.getColumn() == getPosition().getColumn();
	}

	@Override
	public String toString() {
		return "P";
	}
}
