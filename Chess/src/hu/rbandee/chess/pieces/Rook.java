package hu.rbandee.chess.pieces;

public class Rook extends Piece {

	public Rook(final Square startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WR;
		} else {
			boardValue = BoardValues.BR;
		}
	}

	@Override
	protected boolean isMoveValid(Square square) {
		// TODO Auto-generated method stub
		return false;
	}
}
