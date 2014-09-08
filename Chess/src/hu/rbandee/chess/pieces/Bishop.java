package hu.rbandee.chess.pieces;

public class Bishop extends Piece {

	public Bishop(String startPositon, Color color) {
		super(startPositon);
		if (color == Color.White)
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
