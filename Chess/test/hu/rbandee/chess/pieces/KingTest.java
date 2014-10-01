package hu.rbandee.chess.pieces;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.chessboard.PieceType;
import hu.rbandee.chess.chessboard.Side;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KingTest {
	private ChessBoard testBoard;
	private King whiteKing;
	private King blackKing;
	private Queen blockingQueen;
	private Queen blackQueen;

	@BeforeTest
	public void initBoard() {
		testBoard = new ChessBoard();
		whiteKing = (King) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.King);
		blackKing = (King) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.Black, PieceType.King);
		blockingQueen = (Queen) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Queen);
		blackQueen = (Queen) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.Black, PieceType.Queen);
	}

	@AfterMethod
	public void cleanBoard() {
		testBoard.clearBoard();
	}

	@Test
	public void neg_stay_in_same_place_is_not_a_move() {
		whiteKing.setPosition("A1");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void one_step_forward_and_right_with_black_is_valid_move() {
		blackKing.setPosition("F8");
		assertTrue(blackKing.isMoveValid(testBoard.getSquare("E7")));
	}

	@Test
	public void one_step_forward_is_valid_move() {
		whiteKing.setPosition("A1");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void one_step_left_is_valid_move() {
		whiteKing.setPosition("B2");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void one_step_right_is_valid_move() {
		whiteKing.setPosition("B1");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("C1")));
	}

	@Test
	public void one_step_backward_is_valid_move() {
		whiteKing.setPosition("A2");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void one_step_forward_and_right_is_valid_move() {
		whiteKing.setPosition("A1");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void one_step_forward_and_left_is_valid_move() {
		whiteKing.setPosition("B1");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void one_step_backward_and_right_is_valid_move() {
		whiteKing.setPosition("B2");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("C1")));
	}

	@Test
	public void one_step_backward_and_left_is_valid_move() {
		whiteKing.setPosition("B2");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void neg_some_steps_forward_with_black_is_invalid_move() {
		blackKing.setPosition("E1");
		assertFalse(blackKing.isMoveValid(testBoard.getSquare("E7")));
	}

	@Test
	public void neg_some_steps_forward_is_invalid_move() {
		whiteKing.setPosition("A1");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void neg_some_steps_backward_is_invalid_move() {
		whiteKing.setPosition("C7");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("C3")));
	}

	@Test
	public void neg_some_steps_to_the_right_is_invalid_move() {
		whiteKing.setPosition("B6");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("G6")));
	}

	@Test
	public void neg_some_steps_to_the_left_is_invalid_move() {
		whiteKing.setPosition("C7");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void neg_step_forward_with_blocking_is_invalid() {
		whiteKing.setPosition("A1");
		blockingQueen.setPosition("A2");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void neg_step_left_with_blocking_is_invalid() {
		whiteKing.setPosition("E2");
		blockingQueen.setPosition("D2");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("D2")));
	}

	@Test
	public void neg_steps_right_with_blocking_is_invalid() {
		whiteKing.setPosition("A5");
		blockingQueen.setPosition("B5");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("B5")));
	}

	@Test
	public void neg_steps_backward_with_blocking_is_invalid() {
		whiteKing.setPosition("D5");
		blockingQueen.setPosition("D4");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("D4")));
	}

	@Test
	public void neg_step_forward_and_right_with_blocking_is_invalid() {
		whiteKing.setPosition("A1");
		blockingQueen.setPosition("B2");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void neg_step_forward_and_left_with_blocking_is_invalid() {
		whiteKing.setPosition("E1");
		blockingQueen.setPosition("D2");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("D2")));
	}

	@Test
	public void neg_steps_backward_and_right_with_blocking_is_invalid() {
		whiteKing.setPosition("A5");
		blockingQueen.setPosition("B4");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("B4")));
	}

	@Test
	public void neg_steps_backward_and_left_with_blocking_is_invalid() {
		whiteKing.setPosition("E5");
		blockingQueen.setPosition("D4");
		assertFalse(whiteKing.isMoveValid(testBoard.getSquare("D4")));
	}

	@Test
	public void capture_enemy_Queen_forward() {
		whiteKing.setPosition("B1");
		blackQueen.setPosition("B2");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void capture_enemy_Queen_left() {
		whiteKing.setPosition("H2");
		blackQueen.setPosition("G2");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("G2")));
	}

	@Test
	public void capture_enemy_Queen_right() {
		whiteKing.setPosition("F7");
		blackQueen.setPosition("G7");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("G7")));
	}

	@Test
	public void capture_enemy_Queen_backward() {
		whiteKing.setPosition("A2");
		blackQueen.setPosition("A1");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void capture_enemy_Queen_forward_and_right() {
		whiteKing.setPosition("A1");
		blackQueen.setPosition("B2");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void capture_enemy_Queen_forward_and_left() {
		whiteKing.setPosition("H1");
		blackQueen.setPosition("G2");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("G2")));
	}

	@Test
	public void capture_enemy_Queen_backward_and_right() {
		whiteKing.setPosition("F8");
		blackQueen.setPosition("G7");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("G7")));
	}

	@Test
	public void capture_enemy_Queen_backward_and_left() {
		whiteKing.setPosition("B2");
		blackQueen.setPosition("A1");
		assertTrue(whiteKing.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void capture_enemy_Queen_backward_and_left_with_black() {
		blackKing.setPosition("A5");
		blockingQueen.setPosition("B6");
		assertTrue(blackKing.isMoveValid(testBoard.getSquare("B6")));
	}
}
