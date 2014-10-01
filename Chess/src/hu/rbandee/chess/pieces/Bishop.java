package hu.rbandee.chess.pieces;

import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.chessboard.Square;

public class Bishop extends Piece {

	public Bishop(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(final Square newPosition) {
		boolean valid;
		if (newPosition.isFree() || isOpponent(newPosition)) {
			if (validStep(newPosition) && noBlock(newPosition)) {
				valid = true;
			} else {
				valid = false;
			}
		} else {
			valid = false;
		}
		return valid;
	}

	private boolean noBlock(Square newPosition) {
		boolean noBlock = true;
		int startRow = getPosition().getRow();
		int startColumn = getPosition().getColumn();
		int newRow = newPosition.getRow();
		int newColumn = newPosition.getColumn();

		int deltaRow = newRow > startRow ? 1 : -1;
		int deltaColumn = newColumn > startColumn ? 1 : -1;

		int checkedRow = startRow;
		int checkedColumn = startColumn;
		int limit = Math.abs(startRow - newRow) - 1;
		for (int i = 0; i < limit; i++) {
			checkedColumn += deltaColumn;
			checkedRow += deltaRow;
			if (!getChessBoard().getSquare(checkedColumn, checkedRow).isFree()) {
				noBlock = false;
				break;
			}

		}
		return noBlock;
	}

	private boolean validStep(Square newPosition) {
		int deltaColumn = Math.abs(newPosition.getColumn() - getPosition().getColumn());
		int deltaRow = Math.abs(newPosition.getRow() - getPosition().getRow());
		return deltaColumn == deltaRow;
	}

	@Override
	public String toString() {
		return "B";
	}
}
