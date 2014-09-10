package hu.rbandee.chess.pieces;

public class Queen extends Piece {

	public Queen(final String startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WQ;
		} else {
			boardValue = BoardValues.BQ;
		}
	}

	@Override
	protected boolean isMoveValid(final String square) {
		// TODO Auto-generated method stub
		return false;
	}
}
