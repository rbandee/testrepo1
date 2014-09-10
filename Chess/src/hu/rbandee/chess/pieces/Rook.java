package hu.rbandee.chess.pieces;

public class Rook extends Piece {

	public Rook(final String startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WR;
		} else {
			boardValue = BoardValues.BR;
		}
	}

	@Override
	protected boolean isMoveValid(final String square) {
		// TODO Auto-generated method stub
		return false;
	}
}
