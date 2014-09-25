package hu.rbandee.chess.other;

import java.util.ArrayList;
import java.util.List;

public class Application {
	private static List<User> users = new ArrayList<User>();

	public static void main(final String[] args) {
		final User white = new User("White");
		final User black = new User("Black");
		addNewUsers(white, black);

		final Game game = new Game(white, black);
		game.initBoard();
		game.printBoard();
	}

	private static void addNewUsers(final User... users) {
		for (final User user : users) {
			addNewUser(user);
		}
	}

	private static void addNewUser(final User user) {
		users.add(user);

	}

}
