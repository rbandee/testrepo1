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

	//TODO: normal steps with black
	@Test
	public void neg_a_step_forward_and_right_is_invalid() {
		whiteBishop.setPosition("A1");
		assertFalse(whiteBishop.isMoveValid(testBoard.getSquare("B2")));
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

	//TODO:blocking tests with all 3 other direction
	@Test
	public void capture_enemy_bishop_forward_and_right() {
		whiteBishop.setPosition("A1");
		blackBishop.setPosition("H8");
		assertTrue(whiteBishop.isMoveValid(testBoard.getSquare("H8")));
	}
	//TODO:capture tests with all 3 other direction
}
