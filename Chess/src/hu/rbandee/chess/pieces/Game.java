package hu.rbandee.chess.pieces;

public class Game {
	Side whiteSide;
	Side blackSide;
	ChessBoard board;

	public Game(Player white, Player black) {
		whiteSide = new Side(white);
		blackSide = new Side(black);

		board = new ChessBoard();
	}

	public void printEmptyBoard() {
		board.printBoard();
	}

	public void printBoard() {
		board.printBoard();
	}

	public void initBoard() {
		whiteSide.addPiece("A1", PieceType.Rook);
		whiteSide.addPiece("A2", PieceType.Knight);
		whiteSide.addPiece("A3", PieceType.Bishop);
		whiteSide.addPiece("A4", PieceType.King);
		whiteSide.addPiece("A5", PieceType.Queen);
		whiteSide.addPiece("A6", PieceType.Bishop);
		whiteSide.addPiece("A7", PieceType.Knight);
		whiteSide.addPiece("A8", PieceType.Rook);
		whiteSide.addPiece("B1", PieceType.Pawn);
		whiteSide.addPiece("B2", PieceType.Pawn);
		whiteSide.addPiece("B3", PieceType.Pawn);
		whiteSide.addPiece("B4", PieceType.Pawn);
		whiteSide.addPiece("B5", PieceType.Pawn);
		whiteSide.addPiece("B6", PieceType.Pawn);
		whiteSide.addPiece("B7", PieceType.Pawn);
		whiteSide.addPiece("B8", PieceType.Pawn);

		blackSide.addPiece("H1", PieceType.Rook);
		blackSide.addPiece("H2", PieceType.Knight);
		blackSide.addPiece("H3", PieceType.Bishop);
		blackSide.addPiece("H4", PieceType.King);
		blackSide.addPiece("H5", PieceType.Queen);
		blackSide.addPiece("H6", PieceType.Bishop);
		blackSide.addPiece("H7", PieceType.Knight);
		blackSide.addPiece("H8", PieceType.Rook);
		blackSide.addPiece("G1", PieceType.Pawn);
		blackSide.addPiece("G2", PieceType.Pawn);
		blackSide.addPiece("G3", PieceType.Pawn);
		blackSide.addPiece("G4", PieceType.Pawn);
		blackSide.addPiece("G5", PieceType.Pawn);
		blackSide.addPiece("G6", PieceType.Pawn);
		blackSide.addPiece("G7", PieceType.Pawn);
		blackSide.addPiece("G8", PieceType.Pawn);
	}
}
