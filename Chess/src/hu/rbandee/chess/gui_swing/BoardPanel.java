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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class BoardPanel extends JComponent implements MouseListener {
	public final int squaresInRow = 8;
	public final int squaresInColumn = 8;
	private final Color darkSquareColor = Color.LIGHT_GRAY;
	private final Color lightSquareColor = Color.WHITE;
	private final Color darkPieceColor = Color.DARK_GRAY;
	private final Color lightPieceColor = Color.ORANGE;
	private final SquareOnGui[][] squaresOnPanel = new SquareOnGui[squaresInRow][squaresInColumn];

	public BoardPanel() {
		addMouseListener(this);

		for (int col = 0; col < squaresInRow; col++) {
			for (int row = 0; row < squaresInColumn; row++) {
				if ((col + row) % 2 == 0) {
					squaresOnPanel[col][row] = new SquareOnGui(this, lightSquareColor, col, row);
				} else {
					squaresOnPanel[col][row] = new SquareOnGui(this, darkSquareColor, col, row);
				}
			}
		}
	}

	@Override
	protected void paintComponent(final Graphics graphics) {
		final Graphics2D g2d = (Graphics2D) graphics;

		drawBoard(g2d);
		drawPieces(g2d);
	}

	private void drawBoard(final Graphics2D g2d) {
		for (int cols = 0; cols < squaresInRow; cols++) {
			for (int rows = 0; rows < squaresInColumn; rows++) {
				squaresOnPanel[cols][rows].draw(g2d);
			}
		}
	}

	private void drawPieces(final Graphics2D g2d) {
		final ChessBoard board = getBoard();
		for (int column = 0; column < squaresInRow; column++) {
			for (int row = 0; row < squaresInColumn; row++) {
				Piece piece = board.getSquare(column, row).getPiece();
				if (piece != null) {
					drawPiece(g2d, piece, column, row);
				}
			}
		}
	}

	private void drawPiece(final Graphics2D g2d, final Piece piece, final int column, final int row) {
		SquareOnGui mySquare = getSquareOnGui(piece.getPosition().getColumn(), squaresInColumn - 1
				- piece.getPosition().getRow());

		final int x = mySquare.getStartX() + mySquare.getWidth() / 2;
		final int y = mySquare.getStartY() + mySquare.getHeight() / 2;
		if (piece.getSide().equals(Side.White)) {
			g2d.setColor(lightPieceColor);
		} else {
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

	private SquareOnGui getSquareOnGui(final int column, final int row) {
		return squaresOnPanel[column][row];
	}

	private ChessBoard getBoard() {
		return Application.getInstance().getGame().getBoard();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		System.out.println("mouseClicked");
		final int x = event.getX();
		final int y = event.getY();

		this.requestFocus(); // request focus so this panel can get keyEvents
	}

	@Override
	public void mousePressed(MouseEvent event) {
	}

	@Override
	public void mouseReleased(MouseEvent event) {
	}

	@Override
	public void mouseEntered(MouseEvent event) {
	}

	@Override
	public void mouseExited(MouseEvent event) {
	}

	public void updateContent() {
		for (int cols = 0; cols < squaresInRow; cols++) {
			for (int rows = 0; rows < squaresInColumn; rows++) {
				squaresOnPanel[cols][rows].updateSize();
			}
		}
	}
}
