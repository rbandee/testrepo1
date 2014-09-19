package hu.rbandee.chess.chessboard;

public class King extends Piece {

	public King(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(final Square newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "K";
	}
}
