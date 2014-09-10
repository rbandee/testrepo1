package hu.rbandee.chess.pieces;

public class King extends Piece {

	public King(final String startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WK;
		} else {
			boardValue = BoardValues.BK;
		}
	}

	@Override
	protected boolean isMoveValid(final String square) {
		// TODO Auto-generated method stub
		return false;
	}
}
