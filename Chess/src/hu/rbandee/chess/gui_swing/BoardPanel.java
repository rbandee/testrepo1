package hu.rbandee.chess.gui_swing;

import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.other.Application;
import hu.rbandee.chess.pieces.Bishop;
import hu.rbandee.chess.pieces.King;
import hu.rbandee.chess.pieces.Knight;
import hu.rbandee.chess.pieces.Pawn;
import hu.rbandee.chess.pieces.Piece;
import hu.rbandee.chess.pieces.Queen;
import hu.rbandee.chess.pieces.Rook;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class BoardPanel extends JComponent {
	private final int squaresInRow = 8;
	private final int squaresInColumn = 8;
	private final Color darkSquareColor = Color.LIGHT_GRAY;
	private final Color lightSquareColor = Color.WHITE;
	private final Color darkPieceColor = Color.DARK_GRAY;
	private final Color lightPieceColor = Color.ORANGE;
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
		g2d.setColor(lightSquareColor);
		g2d.fill(new Rectangle2D.Double(col * squareWidth, row * squareHeight, squareWidth, squareHeight));
	}

	private void drawDarkSquare(final Graphics2D g2d, int col, int row) {
		g2d.setColor(darkSquareColor);
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
		int x = piece.getPosition().getColumn() * squareWidth + squareWidth / 2;
		int y = (squaresInColumn - piece.getPosition().getRow() - 1) * squareHeight + squareHeight / 2;
		if (piece.getSide().equals(Side.White)){
			g2d.setColor(lightPieceColor);
		} else{
			g2d.setColor(darkPieceColor);
		}

		g2d.setFont(new Font("TimesRoman", Font.BOLD, 32));
		if (piece instanceof Pawn) {
			g2d.drawString("P", x, y);
		} else if (piece instanceof King) {
			g2d.drawString("K", x, y);
		} else if (piece instanceof King) {
			g2d.drawString("K", x, y);
		} else if (piece instanceof Knight) {
			g2d.drawString("N", x, y);
		} else if (piece instanceof Queen) {
			g2d.drawString("Q", x, y);
		} else if (piece instanceof Bishop) {
			g2d.drawString("B", x, y);
		} else if (piece instanceof Rook) {
			g2d.drawString("R", x, y);
		}
	}

	private ChessBoard getBoard() {
		return Application.getInstance().getGame().getBoard();
	}
}
