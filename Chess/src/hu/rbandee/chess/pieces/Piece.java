package hu.rbandee.chess.pieces;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Square> getAvailabeSquares(){
		List<Square> allPossibleSquares = new ArrayList<Square>();
			 
		return allPossibleSquares;
	}

	public void setMyBoard(ChessBoard chessBoard) {
		myBoard = chessBoard;		
	}
	
	public boolean isWhite(){
		return boardValue.equals(BoardValues.WB) || boardValue.equals(BoardValues.WR) || boardValue.equals(BoardValues.WP) || boardValue.equals(BoardValues.WK) || boardValue.equals(BoardValues.WN) || boardValue.equals(BoardValues.WQ);
	}
	
	public boolean isBlack(){
		return boardValue.equals(BoardValues.BB) || boardValue.equals(BoardValues.BR) || boardValue.equals(BoardValues.BP) || boardValue.equals(BoardValues.BK) || boardValue.equals(BoardValues.BN) || boardValue.equals(BoardValues.BQ);
	}
}
