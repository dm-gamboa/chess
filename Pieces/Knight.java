package A01207448.Pieces;

import A01207448.ChessBoard;
import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color, PieceNotation.N);
    }

    @Override
    public int[][] getLegalMoves(int row, int col) {
        int[][] legalMoves = new int[ChessBoard.COL_SIZE][ChessBoard.ROW_SIZE];
                
        for (int i = 0; i < ChessBoard.COL_SIZE; i++) {
            for (int j = 0; j < ChessBoard.ROW_SIZE; j++) {
                boolean northwardMove = (row + 2) == i && ((col - 1) == j || (col + 1) == j);
                boolean southwardMove = (row - 2) == i && ((col - 1) == j || (col + 1) == j);
                boolean eastwardMove = (col + 2) == j && ((row - 1) == i || (row + 1) == i);
                boolean westwardMove = (col - 2) == j && ((row - 1) == i || (row + 1) == i);

                if (northwardMove || southwardMove || eastwardMove || westwardMove) {
                    legalMoves[i][j] = 1;
                }
            }
        }
        return legalMoves;
    }
}
