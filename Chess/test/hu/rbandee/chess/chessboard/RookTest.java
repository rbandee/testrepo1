package hu.rbandee.chess.chessboard;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

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
		whiteRook = (Rook) testBoard.createNewPiece("A1", Side.White, PieceType.Rook);
		blackRook = (Rook) testBoard.createNewPiece("H8", Side.Black, PieceType.Rook);
		blockingRook = (Rook) testBoard.createNewPiece("A3", Side.White, PieceType.Rook);
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
		testBoard.printBoard();
		whiteRook.setPosition("A2");
		testBoard.printBoard();
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
	public void neg_a_step_forward_and_sideways_is_invalid() {
		whiteRook.setPosition("A1");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void neg_vertical_steps_up_with_blocking_is_invalid() {
		whiteRook.setPosition("A1");
		blockingRook.setPosition("A3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_vertical_steps_down_with_blocking_is_invalid() {
		whiteRook.setPosition("A5");
		blockingRook.setPosition("A3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void neg_vertical_steps_with_blocking_next_to_the_rook_is_invalid() {
		blockingRook.setPosition("A2");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_vertical_steps_with_blocking_next_to_the_rook_is_invalid2() {
		whiteRook.setPosition("G8");
		blockingRook.setPosition("G7");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("G5")));
	}

	@Test
	public void neg_horizontal_steps_with_blocking_is_invalid() {
		whiteRook.setPosition("B3");
		blockingRook.setPosition("F3");
		assertFalse(whiteRook.isMoveValid(testBoard.getSquare("H3")));
	}

}
