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
			if (oneStepAhead(square)||initialTwoSteps(square)){
				valid = true;
			} else {
				valid = false;
			}
		}else{
			if (utes(square)){
				valid = true;
			}else {
				valid = false;
			}
			
		}
		
		return valid;
	}

	private boolean utes(final Square square) {
		return oneStep(square) && adjacent(square);
	}

	private boolean initialTwoSteps(final Square square) {
		return straightAhead(square) && twoStep(square);
	}

	private boolean oneStepAhead(final Square square) {
		return straightAhead(square) && oneStep(square);
	}

	private boolean twoStep(Square square) {
		return (isWhite() && (getPosition().getRow() == 1) && ((square.getRow()-2) == getPosition().getRow())) || (isBlack() && (getPosition().getRow() == 6) && ((square.getRow()+2) == getPosition().getRow()));
	}

	private boolean adjacent(Square square) {
		return (square.getColumn()+1 == getPosition().getColumn()) || (square.getColumn()-1 == getPosition().getColumn());
	}

	private boolean oneStep(Square square) {
		return (isWhite() && square.getRow()-1 == getPosition().getRow()) || (isBlack() && square.getRow()+1 == getPosition().getRow());
	}

	private boolean straightAhead(final Square square) {
		return square.getColumn() == getPosition().getColumn();
	}
}
