package hu.rbandee.chess.pieces;

public class Pawn extends Piece {

	public Pawn(String startPositon) {
		super(startPositon);
	}

	@Override
	protected boolean isMoveValid(String square) {
		boolean valid = false;

		if (isSquareFree(square))
			valid = true;
		else
			valid = false;

		return valid;
	}

	private boolean isSquareFree(String square) {
		// TODO --> BOARD or RULES responsibility
		return true;
	}

}
