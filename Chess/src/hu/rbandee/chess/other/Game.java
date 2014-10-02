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
		getBoard().printBoard();
	}

	public void initBoard() {
		initWhiteSide();
		initBlackSide();
	}

	private void initBlackSide() {
		black.addPiece(getBoard().createNewPiece("H8", Side.Black, PieceType.Rook));
		black.addPiece(getBoard().createNewPiece("G8", Side.Black, PieceType.Knight));
		black.addPiece(getBoard().createNewPiece("F8", Side.Black, PieceType.Bishop));
		black.addPiece(getBoard().createNewPiece("E8", Side.Black, PieceType.Queen));
		black.addPiece(getBoard().createNewPiece("D8", Side.Black, PieceType.King));
		black.addPiece(getBoard().createNewPiece("C8", Side.Black, PieceType.Bishop));
		black.addPiece(getBoard().createNewPiece("B8", Side.Black, PieceType.Knight));
		black.addPiece(getBoard().createNewPiece("A8", Side.Black, PieceType.Rook));
		black.addPiece(getBoard().createNewPiece("H7", Side.Black, PieceType.Pawn));
		black.addPiece(getBoard().createNewPiece("G7", Side.Black, PieceType.Pawn));
		black.addPiece(getBoard().createNewPiece("F7", Side.Black, PieceType.Pawn));
		black.addPiece(getBoard().createNewPiece("E7", Side.Black, PieceType.Pawn));
		black.addPiece(getBoard().createNewPiece("D7", Side.Black, PieceType.Pawn));
		black.addPiece(getBoard().createNewPiece("C7", Side.Black, PieceType.Pawn));
		black.addPiece(getBoard().createNewPiece("B7", Side.Black, PieceType.Pawn));
		black.addPiece(getBoard().createNewPiece("A7", Side.Black, PieceType.Pawn));
	}

	private void initWhiteSide() {
		white.addPiece(getBoard().createNewPiece("A1", Side.White, PieceType.Rook));
		white.addPiece(getBoard().createNewPiece("B1", Side.White, PieceType.Knight));
		white.addPiece(getBoard().createNewPiece("C1", Side.White, PieceType.Bishop));
		white.addPiece(getBoard().createNewPiece("D1", Side.White, PieceType.Queen));
		white.addPiece(getBoard().createNewPiece("E1", Side.White, PieceType.King));
		white.addPiece(getBoard().createNewPiece("F1", Side.White, PieceType.Bishop));
		white.addPiece(getBoard().createNewPiece("G1", Side.White, PieceType.Knight));
		white.addPiece(getBoard().createNewPiece("H1", Side.White, PieceType.Rook));
		white.addPiece(getBoard().createNewPiece("A2", Side.White, PieceType.Pawn));
		white.addPiece(getBoard().createNewPiece("B2", Side.White, PieceType.Pawn));
		white.addPiece(getBoard().createNewPiece("C2", Side.White, PieceType.Pawn));
		white.addPiece(getBoard().createNewPiece("D2", Side.White, PieceType.Pawn));
		white.addPiece(getBoard().createNewPiece("E2", Side.White, PieceType.Pawn));
		white.addPiece(getBoard().createNewPiece("F2", Side.White, PieceType.Pawn));
		white.addPiece(getBoard().createNewPiece("G2", Side.White, PieceType.Pawn));
		white.addPiece(getBoard().createNewPiece("H2", Side.White, PieceType.Pawn));
	}

	public ChessBoard getBoard() {
		return board;
	}
}
