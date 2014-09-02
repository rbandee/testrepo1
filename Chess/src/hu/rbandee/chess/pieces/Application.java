package hu.rbandee.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Application {
	static List<Player> players = new ArrayList<Player>();

	public static void main(String[] args) {
		Player white = new Player("White");
		Player black = new Player("Black");
		addNewPlayers(white, black);

		Game game = new Game(white, black);
	}

	private static void addNewPlayers(Player... players) {
		for (Player player : players) {
			addNewPlayer(player);
		}
	}

	private static void addNewPlayer(Player player) {
		players.add(player);

	}
}
