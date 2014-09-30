package hu.rbandee.chess.pieces;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.chessboard.PieceType;
import hu.rbandee.chess.chessboard.Side;
import hu.rbandee.chess.pieces.Pawn;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PawnTest {
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
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White, PieceType.Pawn);
		assertFalse(apawn.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void one_step_forward_from_start_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White, PieceType.Pawn);
		assertTrue(apawn.isMoveValid(testBoard.getSquare("A3")));
	}

	@Test
	public void one_step_forward_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("C4", Side.White, PieceType.Pawn);
		assertTrue(apawn.isMoveValid(testBoard.getSquare("C5")));
	}

	@Test
	public void one_step_forward_with_black_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("B7", Side.Black, PieceType.Pawn);
		assertTrue(apawn.isMoveValid(testBoard.getSquare("B6")));
	}

	@Test
	public void two_steps_forward_is_valid_move_as_opening() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White, PieceType.Pawn);
		assertTrue(apawn.isMoveValid(testBoard.getSquare("A4")));
	}

	@Test
	public void neg_two_steps_forward_not_from_starting_position() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A3", Side.White, PieceType.Pawn);
		assertFalse(apawn.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_could_not_step_to_a_square_too_far() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A3", Side.White, PieceType.Pawn);
		assertFalse(apawn.isMoveValid(testBoard.getSquare("E6")));
	}

	@Test
	public void capture_opponent_piece() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E5", Side.White, PieceType.Pawn);
		final Pawn opponentPawn = (Pawn) testBoard.createNewPiece("D6", Side.Black, PieceType.Pawn);
		assertTrue(apawn.isMoveValid(testBoard.getSquare("D6")));
	}

	@Test
	public void neg_capture_opponent_piece() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E5", Side.White, PieceType.Pawn);
		final Pawn opponentPawn = (Pawn) testBoard.createNewPiece("D7", Side.Black, PieceType.Pawn);
		assertFalse(apawn.isMoveValid(testBoard.getSquare("D6")));
	}

	@Test
	public void capture_opponent_piece_with_black() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("D6", Side.Black, PieceType.Pawn);
		final Pawn opponentPawn = (Pawn) testBoard.createNewPiece("E5", Side.White, PieceType.Pawn);
		assertTrue(apawn.isMoveValid(testBoard.getSquare("E5")));
	}

	@Test
	public void neg_capture_own_piece() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E5", Side.White, PieceType.Pawn);
		final Pawn opponentPawn = (Pawn) testBoard.createNewPiece("F6", Side.White, PieceType.Pawn);
		assertFalse(apawn.isMoveValid(testBoard.getSquare("F6")));
	}

	@Test
	public void capture_opponent_en_passant() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E2", Side.White, PieceType.Pawn);
		final Pawn opponentPawn = (Pawn) testBoard.createNewPiece("D4", Side.Black, PieceType.Pawn);

		apawn.move(testBoard.getSquare("E4"));
		assertTrue(opponentPawn.isMoveValid(testBoard.getSquare("E3")));
	}

	@Test
	public void neg_capture_opponent_en_passant_not_immediately() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E2", Side.White, PieceType.Pawn);
		final Pawn otherPawn = (Pawn) testBoard.createNewPiece("D2", Side.White, PieceType.Pawn);
		final Pawn opponentPawn = (Pawn) testBoard.createNewPiece("D4", Side.Black, PieceType.Pawn);
		apawn.move(testBoard.getSquare("E4"));
		otherPawn.move(testBoard.getSquare("D3"));
		assertFalse(opponentPawn.isMoveValid(testBoard.getSquare("E3")));
	}
}
