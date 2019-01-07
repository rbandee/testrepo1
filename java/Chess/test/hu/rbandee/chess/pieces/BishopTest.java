package hu.rbandee.chess.pieces;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.chessboard.PieceType;
import hu.rbandee.chess.chessboard.Side;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BishopTest {
	private ChessBoard testBoard;
	private Bishop whiteBishop;
	private Bishop blackBishop;
	private Bishop blockingBishop;

	@BeforeTest
	public void initBoard() {
		testBoard = new ChessBoard();
		whiteBishop = (Bishop) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Bishop);
		blackBishop = (Bishop) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.Black, PieceType.Bishop);
		blockingBishop = (Bishop) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Bishop);
	}

	@AfterMethod
	public void cleanBoard() {
		testBoard.clearBoard();
	}

	@Test
	public void neg_stay_in_same_place_is_not_a_move() {
		whiteBishop.setPosition("A1");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void one_step_forward_and_right_with_black_is_valid_move() {
		blackBishop.setPosition("F8");
		assertTrue(blackBishop.isMoveValid(testBoard.getSquare("E7")));
	}

	@Test
	public void one_step_forward_and_right_is_valid_move() {
		whiteBishop.setPosition("A1");
		assertTrue(whiteBishop.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void one_step_forward_and_left_is_valid_move() {
		whiteBishop.setPosition("B1");
		assertTrue(whiteBishop.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void one_step_backward_and_right_is_valid_move() {
		whiteBishop.setPosition("B2");
		assertTrue(whiteBishop.isMoveValid(testBoard.getSquare("C1")));
	}

	@Test
	public void one_step_backward_and_left_is_valid_move() {
		whiteBishop.setPosition("B2");
		assertTrue(whiteBishop.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void neg_some_steps_forward_with_black_is_invalid_move() {
		blackBishop.setPosition("E1");
		assertFalse(blackBishop.isMoveValid(testBoard.getSquare("E7")));
	}

	@Test
	public void neg_some_steps_forward_is_invalid_move() {
		whiteBishop.setPosition("A1");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void neg_some_steps_backward_is_invalid_move() {
		whiteBishop.setPosition("C7");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("C3")));
	}

	@Test
	public void neg_some_steps_to_the_right_is_invalid_move() {
		whiteBishop.setPosition("B6");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("G6")));
	}

	@Test
	public void neg_some_steps_to_the_left_is_invalid_move() {
		whiteBishop.setPosition("C7");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void neg_steps_forward_and_right_with_blocking_is_invalid() {
		whiteBishop.setPosition("A1");
		blockingBishop.setPosition("C3");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("E5")));
	}

	@Test
	public void neg_steps_forward_and_right_with_blocking_next_to_the_bishop_is_invalid() {
		whiteBishop.setPosition("A1");
		blockingBishop.setPosition("B2");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("E5")));
	}

	@Test
	public void neg_steps_forward_and_right_with_blocking_next_to_the_new_position_is_invalid() {
		whiteBishop.setPosition("A1");
		blockingBishop.setPosition("D4");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("E5")));
	}

	@Test
	public void neg_steps_forward_and_right_with_blocking_on_the_new_position_is_invalid() {
		whiteBishop.setPosition("A1");
		blockingBishop.setPosition("E5");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("E5")));
	}

	@Test
	public void neg_steps_forward_and_left_with_blocking_is_invalid() {
		whiteBishop.setPosition("E1");
		blockingBishop.setPosition("C3");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_steps_forward_and_left_with_blocking_next_to_the_bishop_is_invalid() {
		whiteBishop.setPosition("E1");
		blockingBishop.setPosition("D2");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_steps_forward_and_left_with_blocking_next_to_the_new_position_is_invalid() {
		whiteBishop.setPosition("E1");
		blockingBishop.setPosition("B4");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_steps_forward_and_left_with_blocking_on_the_new_position_is_invalid() {
		whiteBishop.setPosition("E1");
		blockingBishop.setPosition("A5");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_steps_backard_and_right_with_blocking_is_invalid() {
		whiteBishop.setPosition("A5");
		blockingBishop.setPosition("C3");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("E1")));
	}

	@Test
	public void neg_steps_backard_and_right_with_blocking_next_to_the_bishop_is_invalid() {
		whiteBishop.setPosition("A5");
		blockingBishop.setPosition("B4");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("E1")));
	}

	@Test
	public void neg_steps_backard_and_right_with_blocking_next_to_the_new_position_is_invalid() {
		whiteBishop.setPosition("A5");
		blockingBishop.setPosition("D2");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("E1")));
	}

	@Test
	public void neg_steps_backard_and_right_with_blocking_on_the_new_position_is_invalid() {
		whiteBishop.setPosition("A5");
		blockingBishop.setPosition("E1");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("E1")));
	}

	@Test
	public void neg_steps_backard_and_left_with_blocking_is_invalid() {
		whiteBishop.setPosition("E5");
		blockingBishop.setPosition("C3");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void neg_steps_backard_and_left_with_blocking_next_to_the_bishop_is_invalid() {
		whiteBishop.setPosition("E5");
		blockingBishop.setPosition("D4");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void neg_steps_backard_and_left_with_blocking_next_to_the_new_position_is_invalid() {
		whiteBishop.setPosition("E5");
		blockingBishop.setPosition("B2");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void neg_steps_backard_and_left_with_blocking_on_the_new_position_is_invalid() {
		whiteBishop.setPosition("E5");
		blockingBishop.setPosition("A1");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void capture_enemy_bishop_forward_and_right() {
		whiteBishop.setPosition("A1");
		blackBishop.setPosition("H8");
		assertTrue(whiteBishop.isMoveValid(testBoard.getSquare("H8")));
	}

	@Test
	public void capture_enemy_bishop_forward_and_left() {
		whiteBishop.setPosition("H1");
		blackBishop.setPosition("A8");
		assertTrue(whiteBishop.isMoveValid(testBoard.getSquare("A8")));
	}

	@Test
	public void capture_enemy_bishop_backward_and_right() {
		whiteBishop.setPosition("A8");
		blackBishop.setPosition("H1");
		assertTrue(whiteBishop.isMoveValid(testBoard.getSquare("H1")));
	}

	@Test
	public void capture_enemy_bishop_backward_and_left() {
		whiteBishop.setPosition("H8");
		blackBishop.setPosition("A1");
		assertTrue(whiteBishop.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void capture_enemy_bishop_backward_and_left_with_black() {
		blackBishop.setPosition("D8");
		whiteBishop.setPosition("B6");
		assertTrue(blackBishop.isMoveValid(testBoard.getSquare("B6")));
	}
}
