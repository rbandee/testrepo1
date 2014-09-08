package hu.rbandee.chess.pieces;

public class Game {
	Side whiteSide;
	Side blackSide;
	ChessBoard board;

	public Game(Player white, Player black) {
		whiteSide = new Side(white, Color.White);
		blackSide = new Side(black, Color.Black);

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
		board.addPieceToBoard(blackSide.addPiece("H1", PieceType.Rook));
		board.addPieceToBoard(blackSide.addPiece("H2", PieceType.Knight));
		board.addPieceToBoard(blackSide.addPiece("H3", PieceType.Bishop));
		board.addPieceToBoard(blackSide.addPiece("H4", PieceType.Queen));
		board.addPieceToBoard(blackSide.addPiece("H5", PieceType.King));
		board.addPieceToBoard(blackSide.addPiece("H6", PieceType.Bishop));
		board.addPieceToBoard(blackSide.addPiece("H7", PieceType.Knight));
		board.addPieceToBoard(blackSide.addPiece("H8", PieceType.Rook));
		board.addPieceToBoard(blackSide.addPiece("G1", PieceType.Pawn));
		board.addPieceToBoard(blackSide.addPiece("G2", PieceType.Pawn));
		board.addPieceToBoard(blackSide.addPiece("G3", PieceType.Pawn));
		board.addPieceToBoard(blackSide.addPiece("G4", PieceType.Pawn));
		board.addPieceToBoard(blackSide.addPiece("G5", PieceType.Pawn));
		board.addPieceToBoard(blackSide.addPiece("G6", PieceType.Pawn));
		board.addPieceToBoard(blackSide.addPiece("G7", PieceType.Pawn));
		board.addPieceToBoard(blackSide.addPiece("G8", PieceType.Pawn));
	}

	private void initWhiteSide() {
		board.addPieceToBoard(whiteSide.addPiece("A1", PieceType.Rook));
		board.addPieceToBoard(whiteSide.addPiece("A2", PieceType.Knight));
		board.addPieceToBoard(whiteSide.addPiece("A3", PieceType.Bishop));
		board.addPieceToBoard(whiteSide.addPiece("A4", PieceType.Queen));
		board.addPieceToBoard(whiteSide.addPiece("A5", PieceType.King));
		board.addPieceToBoard(whiteSide.addPiece("A6", PieceType.Bishop));
		board.addPieceToBoard(whiteSide.addPiece("A7", PieceType.Knight));
		board.addPieceToBoard(whiteSide.addPiece("A8", PieceType.Rook));
		board.addPieceToBoard(whiteSide.addPiece("B1", PieceType.Pawn));
		board.addPieceToBoard(whiteSide.addPiece("B2", PieceType.Pawn));
		board.addPieceToBoard(whiteSide.addPiece("B3", PieceType.Pawn));
		board.addPieceToBoard(whiteSide.addPiece("B4", PieceType.Pawn));
		board.addPieceToBoard(whiteSide.addPiece("B5", PieceType.Pawn));
		board.addPieceToBoard(whiteSide.addPiece("B6", PieceType.Pawn));
		board.addPieceToBoard(whiteSide.addPiece("B7", PieceType.Pawn));
		board.addPieceToBoard(whiteSide.addPiece("B8", PieceType.Pawn));
	}
}
