package A01207448.Pieces;

import A01207448.ChessBoard;
import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class King extends Piece {
    public King(Color color) {
        super(color, PieceNotation.K);
    }

    @Override
    public int[][] getLegalMoves(int row, int col) {
        int[][] legalMoves = new int[ChessBoard.COL_SIZE][ChessBoard.ROW_SIZE];
                
        for (int i = 0; i < ChessBoard.COL_SIZE; i++) {
            for (int j = 0; j < ChessBoard.ROW_SIZE; j++) {
                boolean validRow = (i + 1) == row || (i - 1) == row || i == row;
                boolean validCol = (j + 1) == col || (j - 1) == col || j == col;
                
                if (validRow && validCol) {
                    legalMoves[i][j] = 1;
                }
            }
        }

        legalMoves[row][col] = 0;
        return legalMoves;
    }
}
