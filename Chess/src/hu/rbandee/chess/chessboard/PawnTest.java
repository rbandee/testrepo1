package hu.rbandee.chess.chessboard;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PawnTest {
	private ChessBoard testBoard;

	@BeforeTest
	public void initBoard() {
		testBoard = new ChessBoard();
	}

	@Test
	public void stay_in_same_place_is_invalid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertFalse(apawn.isMoveValid(new Square("A2")));
	}

	@Test
	public void one_step_forward_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Square("A3")));
	}

	@Test
	public void one_step_forward_with_black_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("B7", Side.Black,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Square("B6")));
	}

	@Test
	public void two_steps_forward_is_valid_move_as_opening() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Square("A4")));
	}

	@Test
	public void two_steps_forward_is_invalid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A3", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertFalse(apawn.isMoveValid(new Square("A5")));
	}

	@Test
	public void invalid_far_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A3", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertFalse(apawn.isMoveValid(new Square("E6")));
	}

	@Test
	public void capture_opponent_piece() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E5", Side.White,
				PieceType.Pawn);
		final Pawn oppositePawn = (Pawn) testBoard.createNewPiece("D6",
				Side.Black, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		testBoard.addPieceToBoard(oppositePawn);
		assertTrue(apawn.isMoveValid(new Square("D6")));
	}

	@Test
	public void invalid_capture_own_piece() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E5", Side.White,
				PieceType.Pawn);
		final Pawn oppositePawn = (Pawn) testBoard.createNewPiece("F6",
				Side.White, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		testBoard.addPieceToBoard(oppositePawn);
		assertFalse(apawn.isMoveValid(new Square("F6")));
	}
}
