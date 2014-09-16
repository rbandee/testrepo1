package hu.rbandee.chess.pieces;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeTest;

public class PawnTest {
	private ChessBoard testBoard;

	@BeforeTest
	public void initBoard(){
		testBoard = new ChessBoard();
	}

	@Test
	public void stay_in_same_place_is_invalid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertFalse(apawn.isMoveValid(new Square("A2")));
	}

	@Test
	public void step_one_step_forward_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Square("A3")));
	}

	@Test
	public void step_one_step_forward_with_black_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("B7", Side.Black, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Square("B6")));
	}
	
	@Test
	public void step_two_step_forward_is_valid_move_as_opening() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Square("A4")));
	}
	
	@Test
	public void step_two_step_forward_is_invalid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A3", Side.White, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertFalse(apawn.isMoveValid(new Square("A5")));
	}
}
