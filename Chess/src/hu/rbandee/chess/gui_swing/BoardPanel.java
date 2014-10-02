package hu.rbandee.chess.gui_swing;

import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.other.Application;
import hu.rbandee.chess.pieces.Pawn;
import hu.rbandee.chess.pieces.Piece;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class BoardPanel extends JComponent {
	private final int squaresInRow = 8;
	private final int squaresInColumn = 8;
	private final Color darkColor = Color.DARK_GRAY;
	private final Color lightColor = Color.WHITE;
	private int squareHeight;
	private int squareWidth;
	private ChessBoard board;

	@Override
	protected void paintComponent(final Graphics graphics) {
		Graphics2D g2d = (Graphics2D) graphics;

		drawBoard(g2d);
		drawPieces(g2d);
	}

	private void drawBoard(Graphics2D g2d) {
		squareHeight = this.getHeight() / squaresInColumn;
		squareWidth = this.getWidth() / squaresInRow;

		for (int cols = 0; cols < squaresInRow; cols++) {
			for (int rows = 0; rows < squaresInColumn; rows++) {
				if ((cols + rows) % 2 == 0) {
					drawLightSquare(g2d, cols, rows);
				} else {
					drawDarkSquare(g2d, cols, rows);
				}
			}
		}
	}

	private void drawLightSquare(final Graphics2D g2d, int col, int row) {
		g2d.setColor(lightColor);
		g2d.fill(new Rectangle2D.Double(col * squareWidth, row * squareHeight, squareWidth, squareHeight));
	}

	private void drawDarkSquare(final Graphics2D g2d, int col, int row) {
		g2d.setColor(darkColor);
		g2d.fill(new Rectangle2D.Double(col * squareWidth, row * squareHeight, squareWidth, squareHeight));
	}

	private void drawPieces(Graphics2D g2d) {
		ChessBoard board = getBoard();
		for (int column = 0; column < squaresInRow; column++) {
			for (int row = 0; row < squaresInColumn; row++) {
				Piece piece = board.getSquare(column, row).getPiece();
				if (piece != null) {
					drawPiece(g2d, piece);
				}
			}
		}
	}

	private void drawPiece(Graphics2D g2d, Piece piece) {
		if (piece instanceof Pawn) {
			drawPawn(g2d, (Pawn) piece);
		}
	}

	private void drawPawn(Graphics2D g2d, Pawn piece) {
		int x = piece.getPosition().getColumn() * squareWidth + squareWidth / 2;
		int y = piece.getPosition().getRow() * squareHeight + squareHeight / 2;
		g2d.setColor(Color.green);
		g2d.drawString("P", x, y);
	}

	private ChessBoard getBoard() {
		return Application.getInstance().getGame().getBoard();
	}
}
