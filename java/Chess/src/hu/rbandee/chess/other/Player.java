package hu.rbandee.chess.other;

import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.pieces.Piece;

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

	public void addPiece(final Piece newPiece) {
		getPieces().add(newPiece);
	}
	
	//For Testing purposes
	public void printAllPieces() {
		System.out.println();
		System.out.println(user + "'s pieces:");
		for (final Piece piece : getPieces()) {
			System.out.print(piece + ":" + piece.getPosition() + " - ");
		}
	}

	public List<Piece> getPieces() {
		return pieces;
	}
}
