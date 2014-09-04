package hu.rbandee.chess.pieces;

public class King extends Piece {

	public King(String startPositon) {
		super(startPositon);
	}

	@Override
	protected boolean isMoveValid(String square) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "K";
	}
}
