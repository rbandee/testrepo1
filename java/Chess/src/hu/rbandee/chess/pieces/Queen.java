package hu.rbandee.chess.pieces;

import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.chessboard.Square;

public class Queen extends Piece {

	public Queen(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(Square newPosition) {
		boolean valid;
		if (newPosition.isFree() || isOpponent(newPosition)) {
			if (validStep(newPosition)) {
				valid = true;
			} else {
				valid = false;
			}
		} else {
			valid = false;
		}
		return valid;
	}

	private boolean validStep(Square newPosition) {
		return validStepAsBishop(newPosition) || validStepAsRook(newPosition);
	}

	private boolean noBlockAsRook(Square newPosition) {
		int startRow = getPosition().getRow();
		int startColumn = getPosition().getColumn();
		int newRow = newPosition.getRow();
		int newColumn = newPosition.getColumn();

		int limit = 0;
		int deltaRow = 0;
		int deltaColumn = 0;
		if (isHorizontal(newPosition)) {
			limit = Math.abs(startColumn - newColumn) - 1;
			deltaColumn = newColumn > startColumn ? 1 : -1;
		} else if (isVertical(newPosition)) {
			limit = Math.abs(startRow - newRow) - 1;
			deltaRow = (newRow > startRow) ? 1 : -1;
		}
		return checkBlock(limit, deltaRow, deltaColumn);
	}

	private boolean checkBlock(int limit, int deltaRow, int deltaColumn) {
		boolean noBlock = true;
		int checkedRow = getPosition().getRow();
		int checkedColumn = getPosition().getColumn();
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

	private boolean validStepAsRook(Square newPosition) {
		return (isHorizontal(newPosition) || isVertical(newPosition)) && noBlockAsRook(newPosition);
	}

	private boolean isHorizontal(Square newPosition) {
		return newPosition.getRow() == getPosition().getRow();
	}

	private boolean isVertical(Square newPosition) {
		return newPosition.getColumn() == getPosition().getColumn();
	}

	private boolean validStepAsBishop(Square newPosition) {
		int deltaColumn = Math.abs(newPosition.getColumn() - getPosition().getColumn());
		int deltaRow = Math.abs(newPosition.getRow() - getPosition().getRow());
		return deltaColumn == deltaRow && noBlockAsBishop(newPosition);
	}

	private boolean noBlockAsBishop(Square newPosition) {
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

	@Override
	public String toString() {
		return "Q";
	}
}
