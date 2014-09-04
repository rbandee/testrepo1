package hu.rbandee.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Side {
	Player player;
	List<Piece> pieces;

	public Side(Player player) {
		this.player = player;
		pieces = new ArrayList<Piece>();
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

	public void printAllPieces() {
		System.out.println();
		System.out.println(player + "'s pieces:");
		for (Piece piece : pieces) {
			System.out.print(piece + ":" + piece.getLocation() + " - ");
		}
	}
}
