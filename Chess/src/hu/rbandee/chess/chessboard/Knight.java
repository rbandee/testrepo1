package hu.rbandee.chess.chessboard;

public class Knight extends Piece {

	public Knight(final Field startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WN;
		} else {
			boardValue = BoardValues.BN;
		}
	}

	@Override
	protected boolean isMoveValid(final Field field) {
		// TODO Auto-generated method stub
		return false;
	}
}
