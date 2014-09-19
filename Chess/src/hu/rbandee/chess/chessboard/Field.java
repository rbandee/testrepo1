package hu.rbandee.chess.chessboard;

import java.util.Arrays;
import java.util.Locale;

public class Field {
	private int row;
	private int column;
	
	public Field(String fieldString){
		column = getColumnNumber(fieldString.substring(0, 1));
		row = Integer.parseInt(fieldString.substring(1)) - 1;
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
