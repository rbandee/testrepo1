package hu.rbandee.chess.chessboard;

public class Rook extends Piece {

	public Rook(final Square startPositon, final Side side) {
		super(startPositon, side);
	}

	@Override
	protected boolean isMoveValid(Square newPosition) {
		boolean valid;
		if (newPosition.isFree()) {
			if (validVerticalStep(newPosition) || validHorizontalStep(newPosition)) {
				valid = true;
			} else {
				valid = false;
			}
		} else if (isOpponent(newPosition)) {
			if (capture(newPosition)) {
				valid = true;
			} else {
				valid = false;
			}

		} else {
			valid = false;
		}
		return valid;
	}

  private boolean noVerticalBlock(Square newPosition){
    boolean valid = true;
    int column = getPosition.getColumn();
    int step = (newPosition.getRow() - getPosition.getRow() > 0) ? 1 : -1;
    for (int i = getPosition.getRow()+1; i<newPosition.getRow(); i=i+step){
      if (!board.getSquare(column, i).isFree){
        valid = false;
        break;
      }
    }
    return valid;
  }

	private boolean capture(Square newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isOpponent(Square newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validHorizontalStep(Square newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validVerticalStep(Square newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "R";
	}
}
