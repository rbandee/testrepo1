package hu.rbandee.chess.pieces;

public class Queen extends Piece {

	public Queen(String startPositon, Color color) {
		super(startPositon);
		if (color == Color.White)
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
