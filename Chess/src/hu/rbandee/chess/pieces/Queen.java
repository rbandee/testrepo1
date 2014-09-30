package hu.rbandee.chess.pieces;

import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.chessboard.Square;

public class Queen extends Piece {

	public Queen(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(Square newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Q";
	}
}
