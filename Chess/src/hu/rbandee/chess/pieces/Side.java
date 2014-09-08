package hu.rbandee.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Side {
	Player player;
	List<Piece> pieces;
	Color color;

	public Side(Player player, Color color) {
		this.player = player;
		this.color = color;
		pieces = new ArrayList<Piece>();
	}

	public Piece addPiece(String square, PieceType pieceType) {
		Piece newPiece = null;
		switch (pieceType) {
		case Bishop:
			newPiece = new Bishop(square, color);
			break;
		case King:
			newPiece = new King(square, color);
			break;
		case Knight:
			newPiece = new Knight(square, color);
			break;
		case Pawn:
			newPiece = new Pawn(square, color);
			break;
		case Queen:
			newPiece = new Queen(square, color);
			break;
		case Rook:
			newPiece = new Rook(square, color);
			break;
		}
		if (newPiece != null)
			pieces.add(newPiece);
		else {
			throw new RuntimeException("Chess Piece (" + pieceType
					+ ") couldn't created on square " + square);
		}

		return newPiece;
	}

	public void printAllPieces() {
		System.out.println();
		System.out.println(player + "'s pieces:");
		for (Piece piece : pieces) {
			System.out.print(piece + ":" + piece.getLocation() + " - ");
		}
	}
}
