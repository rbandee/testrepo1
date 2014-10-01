package hu.rbandee.chess.pieces;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.chessboard.PieceType;
import hu.rbandee.chess.chessboard.Side;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KnightTest {
	private ChessBoard testBoard;
	private Knight whiteKnight;
	private Knight blockingKnight;
	private Knight blackKnight;

	@BeforeTest
	public void initBoard() {
		testBoard = new ChessBoard();
		whiteKnight = (Knight) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Knight);
		blockingKnight = (Knight) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Knight);
		blackKnight = (Knight) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.Black, PieceType.Knight);
	}

	@AfterMethod
	public void cleanBoard() {
		testBoard.clearBoard();
	}

	@Test
	public void neg_stay_in_same_place_is_not_a_move() {
		whiteKnight.setPosition("A1");
		assertFalse(whiteKnight.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void step_forward_right_with_black_is_valid_move() {
		blackKnight.setPosition("D4");
		assertTrue(blackKnight.isMoveValid(testBoard.getSquare("C2")));
	}

	@Test
	public void step_forward_right_is_valid_move() {
		whiteKnight.setPosition("D4");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("E6")));
	}

	@Test
	public void step_right_forward_is_valid_move() {
		whiteKnight.setPosition("D4");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("F5")));
	}

	@Test
	public void step_backward_right_is_valid_move() {
		whiteKnight.setPosition("D4");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("E2")));
	}

	@Test
	public void step_right_backward_is_valid_move() {
		whiteKnight.setPosition("D4");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("F3")));
	}

	@Test
	public void step_forward_left_is_valid_move() {
		whiteKnight.setPosition("D4");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("C6")));
	}

	@Test
	public void step_left_forward_is_valid_move() {
		whiteKnight.setPosition("D4");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("B5")));
	}

	@Test
	public void step_backward_left_is_valid_move() {
		whiteKnight.setPosition("D4");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("C2")));
	}

	@Test
	public void step_left_backward_is_valid_move() {
		whiteKnight.setPosition("D4");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("B3")));
	}

	@Test
	public void neg_some_steps_forward_with_black_is_invalid_move() {
		blackKnight.setPosition("E1");
		assertFalse(blackKnight.isMoveValid(testBoard.getSquare("E7")));
	}

	@Test
	public void neg_some_steps_forward_is_invalid_move() {
		whiteKnight.setPosition("A1");
		assertFalse(whiteKnight.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void neg_one_step_forward_and_right_is_invalid_move() {
		whiteKnight.setPosition("A1");
		assertFalse(whiteKnight.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void neg_two_step_forward_and_right_is_invalid_move() {
		whiteKnight.setPosition("A1");
		assertFalse(whiteKnight.isMoveValid(testBoard.getSquare("C3")));
	}

	@Test
	public void neg_step_with_blocking_is_invalid() {
		whiteKnight.setPosition("A1");
		blockingKnight.setPosition("B3");
		assertFalse(whiteKnight.isMoveValid(testBoard.getSquare("B3")));
	}

	@Test
	public void neg_step_with_blocking_is_invalid2() {
		whiteKnight.setPosition("A1");
		blockingKnight.setPosition("C2");
		assertFalse(whiteKnight.isMoveValid(testBoard.getSquare("C2")));
	}

	@Test
	public void capture_enemy_Knight_forward_right() {
		whiteKnight.setPosition("B1");
		blackKnight.setPosition("C3");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("C3")));
	}

	@Test
	public void capture_enemy_Knight_left_backward() {
		whiteKnight.setPosition("D4");
		blackKnight.setPosition("B3");
		assertTrue(whiteKnight.isMoveValid(testBoard.getSquare("B3")));
	}

	@Test
	public void capture_enemy_Knight_backward_left_with_black() {
		blackKnight.setPosition("A5");
		whiteKnight.setPosition("B7");
		assertTrue(blackKnight.isMoveValid(testBoard.getSquare("B7")));
	}
}
