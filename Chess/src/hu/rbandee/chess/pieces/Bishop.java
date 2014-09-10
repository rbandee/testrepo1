package hu.rbandee.chess.pieces;

public class Bishop extends Piece {

	public Bishop(final String startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WB;
		} else {
			boardValue = BoardValues.BB;
		}
	}

	@Override
	protected boolean isMoveValid(final String square) {
		// TODO Auto-generated method stub
		return false;
	}
}
