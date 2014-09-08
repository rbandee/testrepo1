package hu.rbandee.chess.pieces;

public class Rook extends Piece {

	public Rook(String startPositon, Color color) {
		super(startPositon);
		if (color == Color.White)
			boardValue = BoardValues.WR;
		else
			boardValue = BoardValues.BR;
	}

	@Override
	protected boolean isMoveValid(String square) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "R";
	}
}
