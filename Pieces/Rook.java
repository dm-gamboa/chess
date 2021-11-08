package A01207448.Pieces;

import A01207448.ChessBoard;
import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color, PieceNotation.R);
    }

    @Override
    public int[][] getLegalMoves(int row, int col) {
        int[][] legalMoves = new int[ChessBoard.COL_SIZE][ChessBoard.ROW_SIZE];

        for (int i = 0; i < ChessBoard.COL_SIZE; i++) {
            for (int j = 0; j < ChessBoard.ROW_SIZE; j++) {
                if (row == i || col == j) {
                    legalMoves[i][j] = 1;
                }
            }
        }
        return legalMoves;
    }
}
