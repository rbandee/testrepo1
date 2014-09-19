package hu.rbandee.chess.chessboard;

public class Bishop extends Piece {

	public Bishop(final Field startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WB;
		} else {
			boardValue = BoardValues.BB;
		}
	}

	@Override
	protected boolean isMoveValid(final Field newField) {
		// TODO Auto-generated method stub
		return false;
	}
}
