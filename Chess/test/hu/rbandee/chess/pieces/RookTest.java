package hu.rbandee.chess.pieces;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.chessboard.PieceType;
import hu.rbandee.chess.chessboard.Side;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RookTest {
	private ChessBoard testBoard;
	private Rook whiteRook;
	private Rook blackRook;
	private Rook blockingRook;

	@BeforeTest
	public void initBoard() {
		testBoard = new ChessBoard();
		whiteRook = (Rook) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Rook);
		blackRook = (Rook) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.Black, PieceType.Rook);
		blockingRook = (Rook) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Rook);
	}

	@AfterMethod
	public void cleanBoard() {
		testBoard.clearBoard();
	}

	@Test
	public void neg_stay_in_same_place_is_not_a_move() {
		whiteRook.setPosition("A1");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void one_step_forward_is_valid_move() {
		whiteRook.setPosition("A1");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void some_steps_forward_is_valid_move() {
		whiteRook.setPosition("A1");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void one_step_backward_is_valid_move() {
		whiteRook.setPosition("A2");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void some_steps_backward_is_valid_move() {
		whiteRook.setPosition("B6");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("B3")));
	}

	@Test
	public void one_step_forward_with_black_is_valid_move() {
		blackRook.setPosition("H8");
		assertTrue(blackRook.isMoveValid(testBoard.getSquare("H7")));
	}

	@Test
	public void some_steps_forward_with_black_is_valid_move() {
		blackRook.setPosition("C6");
		assertTrue(blackRook.isMoveValid(testBoard.getSquare("C1")));
	}

	@Test
	public void one_step_backward_with_black_is_valid_move() {
		blackRook.setPosition("D2");
		assertTrue(blackRook.isMoveValid(testBoard.getSquare("D3")));
	}

	@Test
	public void some_steps_backward_with_black_is_valid_move() {
		blackRook.setPosition("G4");
		assertTrue(blackRook.isMoveValid(testBoard.getSquare("G6")));
	}

	@Test
	public void some_steps_to_the_right_is_valid_move() {
		whiteRook.setPosition("A1");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("C1")));
	}

	@Test
	public void some_steps_to_the_left_is_valid_move() {
		whiteRook.setPosition("G4");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("B4")));
	}

	@Test
	public void neg_a_step_forward_and_right_is_invalid() {
		whiteRook.setPosition("A1");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void neg_a_step_forward_and_left_is_invalid() {
		whiteRook.setPosition("B1");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void neg_a_step_backward_and_right_is_invalid() {
		whiteRook.setPosition("A2");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("B1")));
	}

	@Test
	public void neg_a_step_backward_and_left_is_invalid() {
		whiteRook.setPosition("B2");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void neg_some_steps_forward_and_right_is_invalid() {
		whiteRook.setPosition("C3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("E7")));
	}

	@Test
	public void neg_some_steps_forward_and_left_is_invalid() {
		whiteRook.setPosition("E2");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A4")));
	}

	@Test
	public void neg_some_steps_backward_and_right_is_invalid() {
		whiteRook.setPosition("B8");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("H3")));
	}

	@Test
	public void neg_some_steps_backward_and_left_is_invalid() {
		whiteRook.setPosition("D6");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void neg_steps_forward_with_blocking_is_invalid() {
		whiteRook.setPosition("A1");
		blockingRook.setPosition("A3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_steps_forward_with_blocking_next_to_the_rook_is_invalid() {
		whiteRook.setPosition("A1");
		blockingRook.setPosition("A2");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_steps_forward_with_blocking_next_to_the_new_position_is_invalid() {
		whiteRook.setPosition("A1");
		blockingRook.setPosition("A4");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_steps_forward_with_blocking_on_the_new_position_is_invalid() {
		whiteRook.setPosition("A1");
		blockingRook.setPosition("A5");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_steps_backwards_with_blocking_is_invalid() {
		whiteRook.setPosition("A5");
		blockingRook.setPosition("A3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void neg_steps_backwards_with_blocking_next_to_the_rook_is_invalid() {
		whiteRook.setPosition("G8");
		blockingRook.setPosition("G7");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("G5")));
	}

	@Test
	public void neg_steps_backwards_with_blocking_next_to_the_new_position_is_invalid() {
		whiteRook.setPosition("G8");
		blockingRook.setPosition("G6");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("G5")));
	}

	@Test
	public void neg_steps_backwards_with_blocking_on_the_new_position_is_invalid() {
		whiteRook.setPosition("G8");
		blockingRook.setPosition("G6");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("G6")));
	}

	@Test
	public void neg_steps_to_the_right_with_blocking_is_invalid() {
		whiteRook.setPosition("B3");
		blockingRook.setPosition("F3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("H3")));
	}

	@Test
	public void neg_steps_to_the_right_with_blocking_next_to_the_rook_is_invalid() {
		whiteRook.setPosition("B3");
		blockingRook.setPosition("C3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("H3")));
	}

	@Test
	public void neg_steps_to_the_right_with_blocking_next_to_the_new_position_is_invalid() {
		whiteRook.setPosition("B3");
		blockingRook.setPosition("F3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("H3")));
	}

	@Test
	public void neg_steps_to_the_right_with_blocking_on_the_new_position_is_invalid() {
		whiteRook.setPosition("B3");
		blockingRook.setPosition("F3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("F3")));
	}

	@Test
	public void neg_steps_to_the_left_with_blocking_is_invalid() {
		whiteRook.setPosition("G5");
		blockingRook.setPosition("D5");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("B5")));
	}

	@Test
	public void neg_steps_to_the_left_with_blocking_next_to_the_rook_is_invalid() {
		whiteRook.setPosition("G5");
		blockingRook.setPosition("F5");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("B5")));
	}

	@Test
	public void neg_steps_to_the_left_with_blocking_next_to_the_new_position_is_invalid() {
		whiteRook.setPosition("G5");
		blockingRook.setPosition("C5");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("B5")));
	}

	@Test
	public void neg_steps_to_the_left_with_blocking_on_the_new_position_is_invalid() {
		whiteRook.setPosition("G5");
		blockingRook.setPosition("C5");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("C5")));
	}

	@Test
	public void capture_enemy_rook_forwards() {
		whiteRook.setPosition("A1");
		blackRook.setPosition("A8");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("A8")));
	}

	@Test
	public void capture_enemy_rook_forwards_with_black() {
		blackRook.setPosition("A8");
		whiteRook.setPosition("A1");
		assertTrue(blackRook.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void capture_enemy_rook_backwards() {
		whiteRook.setPosition("G6");
		blackRook.setPosition("G2");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("G2")));
	}

	@Test
	public void capture_enemy_rook_to_the_right() {
		whiteRook.setPosition("C3");
		blackRook.setPosition("G3");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("G3")));
	}

	@Test
	public void capture_enemy_rook_to_the_left() {
		whiteRook.setPosition("G3");
		blackRook.setPosition("C3");
		assertTrue(whiteRook.isMoveValid(testBoard.getSquare("C3")));
	}
}
