package hu.rbandee.chess.chessboard;

public class Pawn extends Piece {

	public Pawn(final Field startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WP;
		} else {
			boardValue = BoardValues.BP;
		}
	}

	@Override
	protected boolean isMoveValid(final Field newField) {
		boolean valid;
		if (getMyBoard().isFieldFree(newField)) {
			if (oneStepAhead(newField) || initialTwoSteps(newField)) {
				valid = true;
			} else {
				valid = false;
			}
		} else if (isOpponent(newField)) {
			if (capture(newField)) {
				valid = true;
			} else {
				valid = false;
			}

		} else {
			valid = false;
		}

		return valid;
	}

	private boolean isOpponent(Field field) {
		boolean result;
		BoardValues bv = getMyBoard().getBoardValue(field.getColumn(),
				field.getRow());
		Side pieceSide;
		if (bv == BoardValues.BK || bv == BoardValues.BB
				|| bv == BoardValues.BQ || bv == BoardValues.BR
				|| bv == BoardValues.BN || bv == BoardValues.BP) {
			pieceSide = Side.Black;
		} else if (bv == BoardValues.WK || bv == BoardValues.WB
				|| bv == BoardValues.WQ || bv == BoardValues.WR
				|| bv == BoardValues.WN || bv == BoardValues.WP) {
			pieceSide = Side.White;
		} else {
			throw new RuntimeException("Unexpected error! There should be a "
					+ bv + " piece on " + field + ", but it seems empty.");
		}
		if (pieceSide == this.getSide()) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	private boolean capture(final Field field) {
		return oneStep(field) && adjacent(field);
	}

	private boolean initialTwoSteps(final Field field) {
		return straightAhead(field) && twoStep(field);
	}

	private boolean oneStepAhead(final Field field) {
		return straightAhead(field) && oneStep(field);
	}

	private boolean twoStep(Field field) {
		return (isWhite() && (getPosition().getRow() == 1) && ((field.getRow() - 2) == getPosition()
				.getRow()))
				|| (isBlack() && (getPosition().getRow() == 6) && ((field
						.getRow() + 2) == getPosition().getRow()));
	}

	private boolean adjacent(Field field) {
		boolean result;
		int col = getPosition().getColumn();
		int toCol = field.getColumn();

		if ((col - 1 >= 0 && col - 1 == toCol)
				|| (col + 1 < 8 && col + 1 == toCol)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	private boolean oneStep(Field field) {
		return (isWhite() && field.getRow() - 1 == getPosition().getRow())
				|| (isBlack() && field.getRow() + 1 == getPosition().getRow());
	}

	private boolean straightAhead(final Field field) {
		return field.getColumn() == getPosition().getColumn();
	}
}
