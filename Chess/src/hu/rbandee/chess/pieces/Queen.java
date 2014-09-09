package hu.rbandee.chess.pieces;

public class Queen extends Piece {

	public Queen(String startPositon, Side side) {
		super(startPositon);
		if (side == Side.White)
			boardValue = BoardValues.WQ;
		else
			boardValue = BoardValues.BQ;
	}

	@Override
	protected boolean isMoveValid(String square) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Q";
	}
}
