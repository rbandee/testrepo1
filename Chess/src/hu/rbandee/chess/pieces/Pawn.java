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
		}else if (isOpponent(square)){
			if (capture(square)){
				valid = true;
			}else {
				valid = false;
			}
			
		} else {
			valid = false;
		}
		
		return valid;
	}

	private boolean isOpponent(Square square) {
		boolean result;
		BoardValues bv = getMyBoard().getBoardValue(square.getColumn(), square.getRow());
		Side pieceSide;
		if (bv == BoardValues.BK || bv == BoardValues.BB || bv == BoardValues.BQ || bv == BoardValues.BR || bv == BoardValues.BN || bv == BoardValues.BP){
			pieceSide = Side.Black;
		}else if (bv == BoardValues.WK || bv == BoardValues.WB || bv == BoardValues.WQ || bv == BoardValues.WR || bv == BoardValues.WN || bv == BoardValues.WP){
			pieceSide = Side.White;
		}else{
			throw new RuntimeException("Unexpected error! There should be a "+bv+" piece on "+square+", but it seems empty.");
		}
		if (pieceSide == this.side){
			result = false;
		}else {
			result = true;
		}
		return result;
	}

	private boolean capture(final Square square) {
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
		boolean result;
		int col = getPosition().getColumn();
		int toCol = square.getColumn();

		if ((col - 1 >= 0 && col-1==toCol) || (col +1 <8 && col +1==toCol)){
			result = true;
		}else {
			result = false;
		}
		return result;
	}

	private boolean oneStep(Square square) {
		return (isWhite() && square.getRow()-1 == getPosition().getRow()) || (isBlack() && square.getRow()+1 == getPosition().getRow());
	}

	private boolean straightAhead(final Square square) {
		return square.getColumn() == getPosition().getColumn();
	}
}
