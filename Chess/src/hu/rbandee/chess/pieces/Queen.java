package hu.rbandee.chess.pieces;

public class Queen extends Piece {

	public Queen(final Square startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WQ;
		} else {
			boardValue = BoardValues.BQ;
		}
	}

	@Override
	protected boolean isMoveValid(Square square) {
		// TODO Auto-generated method stub
		return false;
	}
}
