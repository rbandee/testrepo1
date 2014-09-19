package hu.rbandee.chess.other;

import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.chessboard.Piece;
import hu.rbandee.chess.chessboard.PieceType;
import hu.rbandee.chess.chessboard.Side;

public class Game {
	private final Player white;
	private final Player black;
	private final ChessBoard board;

	public Game(final User whiteUser, final User blackUser) {
		this.white = new Player(whiteUser, Side.White);
		this.black = new Player(blackUser, Side.Black);

		board = new ChessBoard();
	}

	public void printBoard() {
		board.printBoard();
	}

	public void initBoard() {
		initWhiteSide();
		initBlackSide();
	}

	private void initBlackSide() {
		black.addPiece(board.createNewPiece("H1", Side.Black, PieceType.Rook));
		black.addPiece(board.createNewPiece("H2", Side.Black, PieceType.Knight));
		black.addPiece(board.createNewPiece("H3", Side.Black, PieceType.Bishop));
		black.addPiece(board.createNewPiece("H4", Side.Black, PieceType.Queen));
		black.addPiece(board.createNewPiece("H5", Side.Black, PieceType.King));
		black.addPiece(board.createNewPiece("H6", Side.Black, PieceType.Bishop));
		black.addPiece(board.createNewPiece("H7", Side.Black, PieceType.Knight));
		black.addPiece(board.createNewPiece("H8", Side.Black, PieceType.Rook));
		black.addPiece(board.createNewPiece("G1", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("G2", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("G3", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("G4", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("G5", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("G6", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("G7", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("G8", Side.Black, PieceType.Pawn));
	}
	
	private void initWhiteSide() {
		white.addPiece(board.createNewPiece("A1", Side.White, PieceType.Rook));
		white.addPiece(board.createNewPiece("A2", Side.White, PieceType.Knight));
		white.addPiece(board.createNewPiece("A3", Side.White, PieceType.Bishop));
		white.addPiece(board.createNewPiece("A4", Side.White, PieceType.Queen));
		white.addPiece(board.createNewPiece("A5", Side.White, PieceType.King));
		white.addPiece(board.createNewPiece("A6", Side.White, PieceType.Bishop));
		white.addPiece(board.createNewPiece("A7", Side.White, PieceType.Knight));
		white.addPiece(board.createNewPiece("A8", Side.White, PieceType.Rook));
		white.addPiece(board.createNewPiece("B1", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("B2", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("B3", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("B4", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("B5", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("B6", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("B7", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("B8", Side.White, PieceType.Pawn));
	}
}
