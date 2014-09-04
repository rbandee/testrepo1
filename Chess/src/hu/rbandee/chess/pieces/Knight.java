package hu.rbandee.chess.pieces;

public class Knight extends Piece {

	public Knight(String startPositon) {
		super(startPositon);
	}

	@Override
	protected boolean isMoveValid(String square) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "L";
	}
}
