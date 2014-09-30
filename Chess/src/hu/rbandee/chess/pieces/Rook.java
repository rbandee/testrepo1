package hu.rbandee.chess.pieces;

import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.chessboard.Square;

public class Rook extends Piece {

	public Rook(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(Square newPosition) {
		boolean valid;
		if (newPosition.isFree() || isOpponent(newPosition)) {
			if (validVerticalStep(newPosition) || validHorizontalStep(newPosition)) {
				valid = true;
			} else {
				valid = false;
			}
		} else {
			valid = false;
		}
		return valid;
	}

	private boolean validHorizontalStep(Square newPosition) {
		boolean valid;
		if (isHorizontal(newPosition) && noHorizontalBlock(newPosition)) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	private boolean noHorizontalBlock(Square newPosition) {
		boolean noBlock = true;
		int row = getPosition().getRow();
		int startColumn = getPosition().getColumn();
		int newColumn = newPosition.getColumn();
		int step = (newColumn - startColumn > 0) ? 1 : -1;
		int checkedColumn = startColumn + step;
		for (int i = getPosition().getColumn() + step; i < newPosition.getColumn(); i = i + step) {
			if (!getChessBoard().getSquare(i, row).isFree()) {
				noBlock = false;
				break;
			}
		}
		while (limitReached(startColumn, newColumn, checkedColumn)) {
			if (!getChessBoard().getSquare(checkedColumn, row).isFree()) {
				noBlock = false;
				break;
			}
			checkedColumn = checkedColumn + step;
		}
		return noBlock;
	}

	private boolean isHorizontal(Square newPosition) {
		boolean horizontal;
		if (newPosition.getRow() == getPosition().getRow()) {
			horizontal = true;
		} else {
			horizontal = false;
		}
		return horizontal;
	}

	private boolean validVerticalStep(Square newPosition) {
		boolean valid;
		if (isVertical(newPosition) && noVerticalBlock(newPosition)) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	private boolean noVerticalBlock(Square newPosition) {
		boolean noBlock = true;
		int column = getPosition().getColumn();
		int startRow = getPosition().getRow();
		int newRow = newPosition.getRow();
		int step = (newRow - startRow > 0) ? 1 : -1;
		int checkedRow = startRow + step;
		while (limitReached(startRow, newRow, checkedRow)) {
			if (!getChessBoard().getSquare(column, checkedRow).isFree()) {
				noBlock = false;
				break;
			}
			checkedRow = checkedRow + step;
		}
		return noBlock;
	}

	private boolean limitReached(int startRow, int newRow, int checkedRow) {//TODO: rename parameters
		boolean result;
		if (newRow - startRow > 0) {
			result = checkedRow < newRow;
		} else {
			result = checkedRow > newRow;
		}
		return result;
	}

	private boolean isVertical(Square newPosition) {
		boolean vertical;
		if (newPosition.getColumn() == getPosition().getColumn()) {
			vertical = true;
		} else {
			vertical = false;
		}
		return vertical;
	}

	@Override
	public String toString() {
		return "R";
	}
}
