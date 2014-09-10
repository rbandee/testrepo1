package hu.rbandee.chess.pieces;

public class Pawn extends Piece {

	public Pawn(final String startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WP;
		} else {
			boardValue = BoardValues.BP;
		}
	}

	@Override
	protected boolean isMoveValid(final String square) {
		boolean valid;

		if (isSquareFree(square)) {
			valid = true;
		} else {
			valid = false;
		}

		return valid;
	}

	private boolean isSquareFree(final String square) {
		// TODO --> BOARD or RULES responsibility
		return true;
	}
}
