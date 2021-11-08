package A01207448.Pieces;

import A01207448.ChessBoard;
import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, PieceNotation.Q);
    }

    @Override
    public int[][] getLegalMoves(int row, int col) {
        int[][] legalMoves = new int[ChessBoard.COL_SIZE][ChessBoard.ROW_SIZE];
                
        for (int i = 0; i < ChessBoard.COL_SIZE; i++) {
            for (int j = 0; j < ChessBoard.ROW_SIZE; j++) {
                // Check for diagonal moves
                int rowDiff = Math.abs(i - row);
                int colDiff = Math.abs(j - col);
                if (rowDiff == colDiff && rowDiff > 0) {
                    legalMoves[i][j] = 1;
                }

                // Check for straight moves
                if (row == i || col == j) {
                    legalMoves[i][j] = 1;
                }
            }
        }
        return legalMoves;
    }
}
