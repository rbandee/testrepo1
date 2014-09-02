package hu.rbandee.chess.pieces;

public class Game {
	Side whiteSide;
	Side blackSide;

	public Game(Player white, Player black) {
		whiteSide = new Side(white);
		blackSide = new Side(black);

		initBoard();
	}

	private void initBoard() {
		whiteSide.addPiece("A1", PieceType.Rook);
		whiteSide.addPiece("A2", PieceType.Knight);
		whiteSide.addPiece("A3", PieceType.Bishop);
		whiteSide.addPiece("A4", PieceType.King);
		whiteSide.addPiece("A5", PieceType.Queen);
		whiteSide.addPiece("A6", PieceType.Bishop);
		whiteSide.addPiece("A7", PieceType.Knight);
		whiteSide.addPiece("A8", PieceType.Rook);
	}
}
