package hu.rbandee.chess.pieces;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.chessboard.PieceType;
import hu.rbandee.chess.chessboard.Side;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QueenTest {
	private ChessBoard testBoard;
	private Queen whiteQueen;
	private Queen blackQueen;
	private Pawn blockingPawn;
	private Pawn blackPawn;

	@BeforeTest
	public void initBoard() {
		testBoard = new ChessBoard();
		whiteQueen = (Queen) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Queen);
		blackQueen = (Queen) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.Black, PieceType.Queen);
		blockingPawn = (Pawn) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Pawn);
		blackPawn = (Pawn) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.Black, PieceType.Pawn);
	}

	@AfterMethod
	public void cleanBoard() {
		testBoard.clearBoard();
	}

	@Test
	public void neg_stay_in_same_place_is_not_a_move() {
		whiteQueen.setPosition("A1");
		assertFalse(whiteQueen.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void one_step_forward_and_right_with_black_is_valid_move() {
		blackQueen.setPosition("F8");
		assertTrue(blackQueen.isMoveValid(testBoard.getSquare("E7")));
	}

	@Test
	public void one_step_forward_is_valid_move() {
		whiteQueen.setPosition("A1");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void one_step_left_is_valid_move() {
		whiteQueen.setPosition("B2");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void one_step_right_is_valid_move() {
		whiteQueen.setPosition("B1");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("C1")));
	}

	@Test
	public void one_step_backward_is_valid_move() {
		whiteQueen.setPosition("A2");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void one_step_forward_and_right_is_valid_move() {
		whiteQueen.setPosition("A1");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void one_step_forward_and_left_is_valid_move() {
		whiteQueen.setPosition("B1");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void one_step_backward_and_right_is_valid_move() {
		whiteQueen.setPosition("B2");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("C1")));
	}

	@Test
	public void one_step_backward_and_left_is_valid_move() {
		whiteQueen.setPosition("B2");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void some_steps_forward_with_black_is_valid_move() {
		blackQueen.setPosition("E1");
		assertTrue(blackQueen.isMoveValid(testBoard.getSquare("E7")));
	}

	@Test
	public void some_steps_forward_is_valid_move() {
		whiteQueen.setPosition("A1");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void some_steps_backward_is_valid_move() {
		whiteQueen.setPosition("C7");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("C3")));
	}

	@Test
	public void some_steps_to_the_right_is_valid_move() {
		whiteQueen.setPosition("B6");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("G6")));
	}

	@Test
	public void some_steps_to_the_left_is_valid_move() {
		whiteQueen.setPosition("C7");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("A7")));
	}

	@Test
	public void neg_step_forward_with_blocking_is_invalid() {
		whiteQueen.setPosition("A1");
		blockingPawn.setPosition("A2");
		assertFalse(whiteQueen.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void neg_step_left_with_blocking_is_invalid() {
		whiteQueen.setPosition("E2");
		blockingPawn.setPosition("D2");
		assertFalse(whiteQueen.isMoveValid(testBoard.getSquare("D2")));
	}

	@Test
	public void neg_steps_right_with_blocking_is_invalid() {
		whiteQueen.setPosition("A5");
		blockingPawn.setPosition("B5");
		assertFalse(whiteQueen.isMoveValid(testBoard.getSquare("B5")));
	}

	@Test
	public void neg_steps_backward_with_blocking_is_invalid() {
		whiteQueen.setPosition("D5");
		blockingPawn.setPosition("D4");
		assertFalse(whiteQueen.isMoveValid(testBoard.getSquare("D4")));
	}

	@Test
	public void neg_step_forward_and_right_with_blocking_is_invalid() {
		whiteQueen.setPosition("A1");
		blockingPawn.setPosition("B2");
		assertFalse(whiteQueen.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void neg_step_forward_and_left_with_blocking_is_invalid() {
		whiteQueen.setPosition("E1");
		blockingPawn.setPosition("D2");
		assertFalse(whiteQueen.isMoveValid(testBoard.getSquare("D2")));
	}

	@Test
	public void neg_steps_backward_and_right_with_blocking_is_invalid() {
		whiteQueen.setPosition("A5");
		blockingPawn.setPosition("B4");
		assertFalse(whiteQueen.isMoveValid(testBoard.getSquare("B4")));
	}

	@Test
	public void neg_steps_backward_and_left_with_blocking_is_invalid() {
		whiteQueen.setPosition("E5");
		blockingPawn.setPosition("D4");
		assertFalse(whiteQueen.isMoveValid(testBoard.getSquare("D4")));
	}

	@Test
	public void capture_enemy_Pawn_forward() {
		whiteQueen.setPosition("B1");
		blackPawn.setPosition("B2");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void capture_enemy_Pawn_left() {
		whiteQueen.setPosition("H2");
		blackPawn.setPosition("G2");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("G2")));
	}

	@Test
	public void capture_enemy_Pawn_right() {
		whiteQueen.setPosition("F7");
		blackPawn.setPosition("G7");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("G7")));
	}

	@Test
	public void capture_enemy_Pawn_backward() {
		whiteQueen.setPosition("A2");
		blackPawn.setPosition("A1");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void capture_enemy_Pawn_forward_and_right() {
		whiteQueen.setPosition("A1");
		blackPawn.setPosition("B2");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("B2")));
	}

	@Test
	public void capture_enemy_Pawn_forward_and_left() {
		whiteQueen.setPosition("H1");
		blackPawn.setPosition("G2");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("G2")));
	}

	@Test
	public void capture_enemy_Pawn_backward_and_right() {
		whiteQueen.setPosition("F8");
		blackPawn.setPosition("G7");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("G7")));
	}

	@Test
	public void capture_enemy_Pawn_backward_and_left() {
		whiteQueen.setPosition("B2");
		blackPawn.setPosition("A1");
		assertTrue(whiteQueen.isMoveValid(testBoard.getSquare("A1")));
	}

	@Test
	public void capture_enemy_Pawn_backward_and_left_with_black() {
		blackQueen.setPosition("A5");
		blockingPawn.setPosition("B6");
		assertTrue(blackQueen.isMoveValid(testBoard.getSquare("B6")));
	}
}
