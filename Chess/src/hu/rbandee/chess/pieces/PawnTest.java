package hu.rbandee.chess.pieces;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class PawnTest {
	@Test
	public void stay_in_same_place_is_invalid_move() {
		String startPositon = "A2";
		Pawn apawn = new Pawn(startPositon, Side.White);
		assertEquals(false, apawn.isMoveValid(startPositon));
	}

	@Test
	public void step_one_step_forward_is_valid_move() {
		String startPositon = "A2";
		Pawn apawn = new Pawn(startPositon, Side.White);
		String nextPosition = "A3";
		assertEquals(true, apawn.isMoveValid(nextPosition));
	}
}
