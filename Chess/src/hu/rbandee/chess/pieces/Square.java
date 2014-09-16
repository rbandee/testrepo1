package hu.rbandee.chess.pieces;

import java.util.Arrays;
import java.util.Locale;

public class Square {
	private int row;
	private int column;
	
	public Square(String squareString){
		column = getColumnNumber(squareString.substring(0, 1));
		row = Integer.parseInt(squareString.substring(1)) - 1;
	}

	private int getColumnNumber(final String letter) {
		return Arrays.binarySearch(ChessBoard.columnLetters,
				letter.toLowerCase(Locale.ENGLISH));
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
