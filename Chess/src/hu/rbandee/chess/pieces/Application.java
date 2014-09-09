package hu.rbandee.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Application {
	static List<User> users = new ArrayList<User>();

	public static void main(String[] args) {
		User white = new User("White");
		User black = new User("Black");
		addNewUsers(white, black);

		Game game = new Game(white, black);
		game.initBoard();
		game.printBoard();
	}

	private static void addNewUsers(User... users) {
		for (User user : users) {
			addNewUser(user);
		}
	}

	private static void addNewUser(User user) {
		users.add(user);

	}
}
