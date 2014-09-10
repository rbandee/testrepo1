package hu.rbandee.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final User user;
	private final List<Piece> pieces;
	private final Side side;

	public Player(final User user, final Side side) {
		this.user = user;
		this.side = side;
		pieces = new ArrayList<Piece>();
	}

	public Piece addPiece(final String square, final PieceType pieceType) {
		Piece newPiece;
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
		default:
			throw new RuntimeException("Chess Piece (" + pieceType
					+ ") couldn't created on square " + square);
		}
		pieces.add(newPiece);

		return newPiece;
	}

	//For Testing purposes
	public void printAllPieces() {
		System.out.println();
		System.out.println(user + "'s pieces:");
		for (final Piece piece : pieces) {
			System.out.print(piece + ":" + piece.getLocation() + " - ");
		}
	}
}
