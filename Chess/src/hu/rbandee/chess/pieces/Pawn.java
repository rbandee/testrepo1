package hu.rbandee.chess.pieces;

public class Pawn extends Piece {

	public Pawn(String startPositon, Color color) {
		super(startPositon);
		if (color == Color.White)
			boardValue = BoardValues.WP;
		else
			boardValue = BoardValues.BP;
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

	@Override
	public String toString() {
		return "P";
	}
}
