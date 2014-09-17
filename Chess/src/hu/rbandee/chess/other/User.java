package hu.rbandee.chess.other;

public class User {
	private final String name;

	public User(final String newUser) {
		name = newUser;
	}

	@Override
	public String toString() {
		return name;
	}
}
