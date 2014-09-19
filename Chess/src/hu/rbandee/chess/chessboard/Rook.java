package hu.rbandee.chess.chessboard;

public class Rook extends Piece {

	public Rook(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(Square newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "R";
	}
}
