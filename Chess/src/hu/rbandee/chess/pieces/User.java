package hu.rbandee.chess.pieces;

public class Player {
	String name = "";

	public Player(String newPlayer) {
		name = newPlayer;
	}

	@Override
	public String toString() {
		return name;
	}
}
