package hu.rbandee.chess.pieces;

public class Knight extends Piece {

	public Knight(String startPositon, Color color) {
		super(startPositon);
		if (color == Color.White)
			boardValue = BoardValues.WN;
		else
			boardValue = BoardValues.BN;
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
