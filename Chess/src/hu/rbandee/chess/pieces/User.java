package hu.rbandee.chess.pieces;

public class User {
	String name = "";

	public User(String newUser) {
		name = newUser;
	}

	@Override
	public String toString() {
		return name;
	}
}
