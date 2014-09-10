package hu.rbandee.chess.pieces;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

public class PawnTest {
	@Test
	public void stay_in_same_place_is_invalid_move() {
		final String startPositon = "A2";
		final Pawn apawn = new Pawn(startPositon, Side.White);
		assertFalse(apawn.isMoveValid(startPositon));
	}

	@Test
	public void step_one_step_forward_is_valid_move() {
		final String startPositon = "A2";
		final Pawn apawn = new Pawn(startPositon, Side.White);
		final String nextPosition = "A3";
		assertTrue(apawn.isMoveValid(nextPosition));
	}
}
