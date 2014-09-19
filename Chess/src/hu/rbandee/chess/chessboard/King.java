package hu.rbandee.chess.chessboard;

public class King extends Piece {

	public King(final Field startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WK;
		} else {
			boardValue = BoardValues.BK;
		}
	}

	@Override
	protected boolean isMoveValid(final Field field) {
		// TODO Auto-generated method stub
		return false;
	}
}
