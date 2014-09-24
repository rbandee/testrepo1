package hu.rbandee.chess.other;

import hu.rbandee.chess.chessboard.ChessBoard;
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
		black.addPiece(board.createNewPiece("H8", Side.Black, PieceType.Rook));
		black.addPiece(board.createNewPiece("G8", Side.Black, PieceType.Knight));
		black.addPiece(board.createNewPiece("F8", Side.Black, PieceType.Bishop));
		black.addPiece(board.createNewPiece("E8", Side.Black, PieceType.Queen));
		black.addPiece(board.createNewPiece("D8", Side.Black, PieceType.King));
		black.addPiece(board.createNewPiece("C8", Side.Black, PieceType.Bishop));
		black.addPiece(board.createNewPiece("B8", Side.Black, PieceType.Knight));
		black.addPiece(board.createNewPiece("A8", Side.Black, PieceType.Rook));
		black.addPiece(board.createNewPiece("H7", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("G7", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("F7", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("E7", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("D7", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("C7", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("B7", Side.Black, PieceType.Pawn));
		black.addPiece(board.createNewPiece("A7", Side.Black, PieceType.Pawn));
	}

	private void initWhiteSide() {
		white.addPiece(board.createNewPiece("A1", Side.White, PieceType.Rook));
		white.addPiece(board.createNewPiece("B1", Side.White, PieceType.Knight));
		white.addPiece(board.createNewPiece("C1", Side.White, PieceType.Bishop));
		white.addPiece(board.createNewPiece("D1", Side.White, PieceType.Queen));
		white.addPiece(board.createNewPiece("E1", Side.White, PieceType.King));
		white.addPiece(board.createNewPiece("F1", Side.White, PieceType.Bishop));
		white.addPiece(board.createNewPiece("G1", Side.White, PieceType.Knight));
		white.addPiece(board.createNewPiece("H1", Side.White, PieceType.Rook));
		white.addPiece(board.createNewPiece("A2", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("B2", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("C2", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("D2", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("E2", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("F2", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("G2", Side.White, PieceType.Pawn));
		white.addPiece(board.createNewPiece("H2", Side.White, PieceType.Pawn));
	}
}
