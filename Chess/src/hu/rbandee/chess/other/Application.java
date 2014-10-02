package hu.rbandee.chess.other;

import hu.rbandee.chess.gui_swing.ChessFrame;

import java.util.ArrayList;
import java.util.List;

public class Application {
	private static final Application INSTANCE = new Application();
	private final List<User> users = new ArrayList<User>();
	private final Game game;

	public Application() {
		final User white = new User("White");
		final User black = new User("Black");
		addNewUsers(white, black);

		game = new Game(white, black);
		getGame().initBoard();
		getGame().printBoard();
	}

	public static void main(final String[] args) {
		ChessFrame gui = ChessFrame.getInstance();
		gui.showGui();
	}

	private void addNewUsers(final User... users) {
		for (final User user : users) {
			addNewUser(user);
		}
	}

	private void addNewUser(final User user) {
		users.add(user);

	}

	public static Application getInstance() {
		return INSTANCE;
	}

	public Game getGame() {
		return game;
	}

}
