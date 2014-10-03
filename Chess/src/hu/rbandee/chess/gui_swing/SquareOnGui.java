package hu.rbandee.chess.gui_swing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class SquareOnGui {
	private final BoardPanel myBoardPanel;
	private int startX;
	private int startY;
	private int height;
	private int width;
	private final Color color;
	private final int column;
	private final int row;

	public SquareOnGui(final BoardPanel boardPanel, final Color color, final int column, final int row) {
		myBoardPanel = boardPanel;
		this.color = color;
		this.column = column;
		this.row = row;
		updateSize();
	}

	public void updateSize() {
		height = myBoardPanel.getHeight() / myBoardPanel.squaresInColumn;
		width = myBoardPanel.getWidth() / myBoardPanel.squaresInRow;
		startY = column * height;
		startX = row * width;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.fill(new Rectangle2D.Double(startX, startY, width, height));
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
