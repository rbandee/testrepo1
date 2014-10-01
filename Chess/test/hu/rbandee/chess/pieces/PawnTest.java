package hu.rbandee.chess.pieces;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import hu.rbandee.chess.chessboard.ChessBoard;
import hu.rbandee.chess.chessboard.PieceType;
import hu.rbandee.chess.chessboard.Side;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PawnTest {
	private ChessBoard testBoard;
	private Pawn whitePawn;
	private Pawn whitePawn2;
	private Pawn blackPawn;

	@BeforeTest
	public void initBoard() {
		testBoard = new ChessBoard();
		whitePawn = (Pawn) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Pawn);
		whitePawn2 = (Pawn) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.White, PieceType.Pawn);
		blackPawn = (Pawn) testBoard.createNewPiece(ChessBoard.OUTOFBOARD, Side.Black, PieceType.Pawn);
	}

	@AfterMethod
	public void cleanBoard() {
		testBoard.clearBoard();
	}

	@Test
	public void neg_stay_in_same_place_is_not_a_move() {
		whitePawn.setPosition("A2");
		assertFalse(whitePawn.isMoveValid(testBoard.getSquare("A2")));
	}

	@Test
	public void one_step_forward_from_start_is_valid_move() {
		whitePawn.setPosition("A2");
		assertTrue(whitePawn.isMoveValid(testBoard.getSquare("A3")));
	}

	@Test
	public void one_step_forward_is_valid_move() {
		whitePawn.setPosition("C4");
		assertTrue(whitePawn.isMoveValid(testBoard.getSquare("C5")));
	}

	@Test
	public void one_step_forward_with_black_is_valid_move() {
		blackPawn.setPosition("B7");
		assertTrue(blackPawn.isMoveValid(testBoard.getSquare("B6")));
	}

	@Test
	public void two_steps_forward_is_valid_move_as_opening() {
		whitePawn.setPosition("A2");
		assertTrue(whitePawn.isMoveValid(testBoard.getSquare("A4")));
	}

	@Test
	public void neg_two_steps_forward_not_from_starting_position() {
		whitePawn.setPosition("A3");
		assertFalse(whitePawn.isMoveValid(testBoard.getSquare("A5")));
	}

	@Test
	public void neg_could_not_step_to_a_square_too_far() {
		whitePawn.setPosition("A3");
		assertFalse(whitePawn.isMoveValid(testBoard.getSquare("E6")));
	}

	@Test
	public void capture_opponent_piece() {
		whitePawn.setPosition("E5");
		blackPawn.setPosition("D6");
		assertTrue(whitePawn.isMoveValid(testBoard.getSquare("D6")));
	}

	@Test
	public void neg_capture_opponent_piece() {
		whitePawn.setPosition("E5");
		blackPawn.setPosition("D7");
		assertFalse(whitePawn.isMoveValid(testBoard.getSquare("D6")));
	}

	@Test
	public void capture_opponent_piece_with_black() {
		blackPawn.setPosition("D6");
		whitePawn.setPosition("E5");
		assertTrue(blackPawn.isMoveValid(testBoard.getSquare("E5")));
	}

	@Test
	public void neg_capture_own_piece() {
		whitePawn.setPosition("E5");
		whitePawn2.setPosition("F6");
		assertFalse(whitePawn.isMoveValid(testBoard.getSquare("F6")));
	}

	@Test
	public void capture_opponent_en_passant() {
		whitePawn.setPosition("E2");
		blackPawn.setPosition("D4");
		whitePawn.move(testBoard.getSquare("E4"));
		assertTrue(blackPawn.isMoveValid(testBoard.getSquare("E3")));
	}

	@Test
	public void neg_capture_opponent_en_passant_not_immediately() {
		whitePawn.setPosition("E2");
		whitePawn2.setPosition("D2");
		blackPawn.setPosition("D4");
		whitePawn.move(testBoard.getSquare("E4"));
		whitePawn2.move(testBoard.getSquare("D3"));
		assertFalse(blackPawn.isMoveValid(testBoard.getSquare("E3")));
	}
}
