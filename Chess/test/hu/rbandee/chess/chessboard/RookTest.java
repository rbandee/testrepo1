package hu.rbandee.chess.chessboard;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RookTest {
	private ChessBoard testBoard;

	@BeforeTest
	public void initBoard() {
		testBoard = new ChessBoard();
	}

	@AfterMethod
	public void cleanBoard() {
		testBoard.clearBoard();
	}

	@Test
	public void neg_stay_in_same_place_is_not_a_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("A1", Side.White, PieceType.Rook);
		assertFalse(arook.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void one_step_forward_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("A1", Side.White, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void some_steps_forward_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("A1", Side.White, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void one_step_backward_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("A2", Side.White, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void some_steps_backward_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("B8", Side.White, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("B3")));
	}

	@Test
	public void one_step_forward_with_black_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("A8", Side.Black, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void some_steps_forward_with_black_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("C6", Side.Black, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("C1")));
	}

	@Test
	public void one_step_backward_with_black_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("D2", Side.Black, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("D3")));
	}

	@Test
	public void some_steps_backward_with_black_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("G4", Side.Black, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("G6")));
	}

	@Test
	public void some_steps_to_the_right_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("A1", Side.White, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("C1")));
	}

	@Test
	public void some_steps_to_the_left_is_valid_move() {
		final Rook arook = (Rook) testBoard.createNewPiece("G4", Side.White, PieceType.Rook);
		assertTrue(arook.isMoveValid(testBoard.getSquare("B4")));
	}

	@Test
	public void neg_a_step_forward_and_sideways_is_invalid() {
		final Rook arook = (Rook) testBoard.createNewPiece("A1", Side.White, PieceType.Rook);
		assertFalse(arook.isMoveValid(testBoard.getSquare("B2")));
	}
}
