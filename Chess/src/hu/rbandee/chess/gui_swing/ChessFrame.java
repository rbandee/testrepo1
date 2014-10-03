package hu.rbandee.chess.gui_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

public class ChessFrame extends JFrame implements ComponentListener {

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
		addComponentListener(this);

		contentPane = this.getContentPane();
		final BorderLayout bLayout = new BorderLayout();
		contentPane.setLayout(bLayout);

		boardPanel = new BoardPanel();
		addComponentsToPane();

	}

	private void addComponentsToPane() {
		contentPane.add(boardPanel);
	}

	public static ChessFrame getInstance() {
		return INSTANCE;
	}

	public void showGui() {
		setVisible(true);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		boardPanel.updateContent();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
	}

	@Override
	public void componentShown(ComponentEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent e) {
	}
}
