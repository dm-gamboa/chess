package A01207448.Pieces;

import A01207448.ChessBoard;
import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color, PieceNotation.P);
    }

    @Override
    public int[][] getLegalMoves(int row, int col) {
        int[][] legalMoves = new int[ChessBoard.ROW_SIZE][ChessBoard.COL_SIZE];

        legalMoves[color == Color.BLACK ? ++row : --row][col] = 1;
        if (!hasMoved) {
            legalMoves[color == Color.BLACK ? ++row : --row][col] = 1;
        }
        return legalMoves;
    }
}
