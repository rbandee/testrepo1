package hu.rbandee.chess.gui_swing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ChessFrame extends JFrame {

	private static final ChessFrame INSTANCE = new ChessFrame();
	private static final String TITLE = "Chess";
	private final Container contentPane;
	private final BoardPanel boardPanel;

	public ChessFrame() {
		super();

		setTitle(TITLE);
		setSize(1024, 768);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = this.getContentPane();
		BorderLayout bLayout = new BorderLayout();
		contentPane.setLayout(bLayout);

		boardPanel = new BoardPanel();
		addComponentsToPane();

	}

	private void addComponentsToPane() {
		contentPane.add(boardPanel);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ChessFrame getInstance() {
		return INSTANCE;
	}

	public void showGui() {
		setVisible(true);
	}
}
