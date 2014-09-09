package hu.rbandee.chess.pieces;

public class King extends Piece {

	public King(String startPositon, Side side) {
		super(startPositon);
		if (side == Side.White)
			boardValue = BoardValues.WK;
		else
			boardValue = BoardValues.BK;
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
