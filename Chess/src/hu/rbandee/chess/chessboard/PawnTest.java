package hu.rbandee.chess.chessboard;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

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
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertFalse(apawn.isMoveValid(new Field("A2")));
	}

	@Test
	public void one_step_forward_from_start_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Field("A3")));
	}

	@Test
	public void one_step_forward_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("C4", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Field("C5")));
	}

	@Test
	public void one_step_forward_with_black_is_valid_move() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("B7", Side.Black,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Field("B6")));
	}

	@Test
	public void two_steps_forward_is_valid_move_as_opening() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A2", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertTrue(apawn.isMoveValid(new Field("A4")));
	}

	@Test
	public void neg_two_steps_forward_not_from_starting_position() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A3", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertFalse(apawn.isMoveValid(new Field("A5")));
	}

	@Test
	public void neg_coludnt_step_to_a_field_too_far() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("A3", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		assertFalse(apawn.isMoveValid(new Field("E6")));
	}

	@Test
	public void capture_opponent_piece() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E5", Side.White,
				PieceType.Pawn);
		final Pawn opponentPawn = (Pawn) testBoard.createNewPiece("D6",
				Side.Black, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		testBoard.addPieceToBoard(opponentPawn);
		assertTrue(apawn.isMoveValid(new Field("D6")));
	}

	@Test
	public void neg_capture_opponent_piece() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E5", Side.White,
				PieceType.Pawn);
		final Pawn opponentPawn = (Pawn) testBoard.createNewPiece("D7",
				Side.Black, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		testBoard.addPieceToBoard(opponentPawn);
		assertFalse(apawn.isMoveValid(new Field("D6")));
	}

	@Test
	public void capture_opponent_piece_with_black() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("D6", Side.Black,
				PieceType.Pawn);
		final Pawn opponentPawn = (Pawn) testBoard.createNewPiece("E5",
				Side.White, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		testBoard.addPieceToBoard(opponentPawn);
		assertTrue(apawn.isMoveValid(new Field("E5")));
	}

	@Test
	public void neg_capture_own_piece() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E5", Side.White,
				PieceType.Pawn);
		final Pawn oppositePawn = (Pawn) testBoard.createNewPiece("F6",
				Side.White, PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		testBoard.addPieceToBoard(oppositePawn);
		assertFalse(apawn.isMoveValid(new Field("F6")));
	}

	@Test
	public void capture_opponent_en_passant() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E2", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		final Pawn oppositePawn = (Pawn) testBoard.createNewPiece("D4",
				Side.Black, PieceType.Pawn);
		testBoard.addPieceToBoard(oppositePawn);

		apawn.move(new Field("E4"));
		assertTrue(oppositePawn.isMoveValid(new Field("E3")));
	}

	@Test
	public void neg_capture_opponent_en_passant_not_immediately() {
		final Pawn apawn = (Pawn) testBoard.createNewPiece("E2", Side.White,
				PieceType.Pawn);
		testBoard.addPieceToBoard(apawn);
		final Pawn otherPawn = (Pawn) testBoard.createNewPiece("D2",
				Side.White, PieceType.Pawn);
		testBoard.addPieceToBoard(otherPawn);
		final Pawn oppositePawn = (Pawn) testBoard.createNewPiece("D4",
				Side.Black, PieceType.Pawn);
		testBoard.addPieceToBoard(oppositePawn);
		apawn.move(new Field("E4"));
		otherPawn.move(new Field("D3"));
		assertFalse(oppositePawn.isMoveValid(new Field("E3")));
	}
}
