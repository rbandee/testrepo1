package hu.rbandee.chess.pieces;

public abstract class Piece {
	private Square position;
	protected BoardValues boardValue;
	private ChessBoard myBoard;

	public Piece(final Square startPositon) {
		position = startPositon;
	}

	public void move(final Square square) {
		if (isMoveValid(square)) {
			position = square;
		}
	}

	public Square getPosition() {
		return position;
	}

	public BoardValues getType() {
		return boardValue;
	}

	protected abstract boolean isMoveValid(final Square square);
	public ChessBoard getMyBoard() {
		return myBoard;
	}

	public void setMyBoard(ChessBoard chessBoard) {
		myBoard = chessBoard;		
	}
}
