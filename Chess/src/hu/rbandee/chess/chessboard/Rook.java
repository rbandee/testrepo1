package hu.rbandee.chess.chessboard;

public class Rook extends Piece {

	public Rook(final Field startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WR;
		} else {
			boardValue = BoardValues.BR;
		}
	}

	@Override
	protected boolean isMoveValid(Field field) {
		// TODO Auto-generated method stub
		return false;
	}
}
