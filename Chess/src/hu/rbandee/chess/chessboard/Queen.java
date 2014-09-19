package hu.rbandee.chess.chessboard;

public class Queen extends Piece {

	public Queen(final Field startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WQ;
		} else {
			boardValue = BoardValues.BQ;
		}
	}

	@Override
	protected boolean isMoveValid(Field field) {
		// TODO Auto-generated method stub
		return false;
	}
}
