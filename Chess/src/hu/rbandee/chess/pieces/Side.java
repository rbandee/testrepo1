package hu.rbandee.chess.pieces;

import java.util.Set;

public class Side {
	Player player;
	Set<Piece> pieces;

	public Side(Player player) {
		this.player = player;
	}

	public void addPiece(String square, PieceType piece) {
		switch (piece) {
		case Bishop:
			pieces.add(new Bishop(square));
			break;
		case King:
			pieces.add(new King(square));
			break;
		case Knight:
			pieces.add(new Knight(square));
			break;
		case Pawn:
			pieces.add(new Pawn(square));
			break;
		case Queen:
			pieces.add(new Queen(square));
			break;
		case Rook:
			pieces.add(new Rook(square));
			break;
		}
	}
}
