package hu.rbandee.chess.pieces;

public class Pawn extends Piece {

	public Pawn(final Square startPositon, final Side side) {
		super(startPositon);
		if (side == Side.White) {
			boardValue = BoardValues.WP;
		} else {
			boardValue = BoardValues.BP;
		}
	}

	@Override
	protected boolean isMoveValid(final Square square) {
		boolean valid;
		if ( getMyBoard().isSquareFree(square)){
			//lepes
			if (straightAhead(square) && oneStep(square)){
				valid = true;
			}else  if (straightAhead(square) && twoStep(square)){
				valid = true;
			} else {
				valid = false;
			}
			
		}else{
			//utes
			if (oneStep(square) && adjacent(square)){
				valid = true;
			}else {
				valid = false;
			}
			
		}
		
		return valid;
	}

	private boolean twoStep(Square square) {
		return square.getRow()-2 == getPosition().getRow();
	}

	private boolean adjacent(Square square) {
		return (square.getColumn()+1 == getPosition().getColumn()) || (square.getColumn()-1 == getPosition().getColumn());
	}

	private boolean oneStep(Square square) {
		return square.getRow()-1 == getPosition().getRow();
	}

	private boolean straightAhead(final Square square) {
		return square.getColumn() == getPosition().getColumn();
	}
}
