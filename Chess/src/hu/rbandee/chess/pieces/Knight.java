package hu.rbandee.chess.pieces;

public class Knight extends Piece {

	public Knight(final String startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WN;
		} else {
			boardValue = BoardValues.BN;
		}
	}

	@Override
	protected boolean isMoveValid(final String square) {
		// TODO Auto-generated method stub
		return false;
	}
}
