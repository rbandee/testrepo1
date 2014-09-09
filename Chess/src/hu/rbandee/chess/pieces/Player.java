package hu.rbandee.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Player {
	User user;
	List<Piece> pieces;
	Side side;

	public Player(User user, Side side) {
		this.user = user;
		this.side = side;
		pieces = new ArrayList<Piece>();
	}

	public Piece addPiece(String square, PieceType pieceType) {
		Piece newPiece = null;
		switch (pieceType) {
		case Bishop:
			newPiece = new Bishop(square, side);
			break;
		case King:
			newPiece = new King(square, side);
			break;
		case Knight:
			newPiece = new Knight(square, side);
			break;
		case Pawn:
			newPiece = new Pawn(square, side);
			break;
		case Queen:
			newPiece = new Queen(square, side);
			break;
		case Rook:
			newPiece = new Rook(square, side);
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
		System.out.println(user + "'s pieces:");
		for (Piece piece : pieces) {
			System.out.print(piece + ":" + piece.getLocation() + " - ");
		}
	}
}
