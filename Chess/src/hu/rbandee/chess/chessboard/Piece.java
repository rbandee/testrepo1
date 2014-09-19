package hu.rbandee.chess.chessboard;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
	private Field position;
	protected BoardValues boardValue;
	private ChessBoard myBoard;

	public Piece(final Field startPositon) {
		position = startPositon;
	}

	public void move(final Field field) {
		if (isMoveValid(field)) {
			position = field;
		}
	}

	public Field getPosition() {
		return position;
	}

	public BoardValues getType() {
		return boardValue;
	}

	protected abstract boolean isMoveValid(final Field field);

	public ChessBoard getMyBoard() {
		return myBoard;
	}

	public List<Field> getAvailabeFields() {
		List<Field> allPossibleFields = new ArrayList<Field>();

		return allPossibleFields;
	}

	public void setMyBoard(ChessBoard chessBoard) {
		myBoard = chessBoard;
	}

	public Side getSide() {
		Side side;
		if (isWhite()) {
			side = Side.White;
		} else {
			side = Side.Black;
		}
		return side;
	}

	public boolean isWhite() {
		return boardValue.equals(BoardValues.WB)
				|| boardValue.equals(BoardValues.WR)
				|| boardValue.equals(BoardValues.WP)
				|| boardValue.equals(BoardValues.WK)
				|| boardValue.equals(BoardValues.WN)
				|| boardValue.equals(BoardValues.WQ);
	}

	public boolean isBlack() {
		return boardValue.equals(BoardValues.BB)
				|| boardValue.equals(BoardValues.BR)
				|| boardValue.equals(BoardValues.BP)
				|| boardValue.equals(BoardValues.BK)
				|| boardValue.equals(BoardValues.BN)
				|| boardValue.equals(BoardValues.BQ);
	}
}
