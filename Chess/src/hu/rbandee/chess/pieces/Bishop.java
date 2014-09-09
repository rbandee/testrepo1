package hu.rbandee.chess.pieces;

public class Bishop extends Piece {

	public Bishop(String startPositon, Side side) {
		super(startPositon);
		if (side == Side.White)
			boardValue = BoardValues.WB;
		else
			boardValue = BoardValues.BB;
	}

	@Override
	protected boolean isMoveValid(String square) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "B";
	}
}
