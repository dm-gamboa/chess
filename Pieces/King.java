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

    @Override
    public int[][][] getLegalMovesToOtherBoards(int row, int col, int boardIndex, int numBoards) {
        int[][][] legalMoves = new int[numBoards][ChessBoard.ROW_SIZE][ChessBoard.COL_SIZE];

        int startRow = (row - 1) < 0 ? row : row - 1;
        int startCol = (col - 1) < 0 ? col : col - 1;
        int endRow = row + 1;
        int endCol = col + 1;
        int leftBoard = boardIndex - 1;
        int rightBoard = boardIndex + 1;

        for (int j = startRow; j <= endRow && j >= 0 && j < ChessBoard.ROW_SIZE; j += 1) {
            for (int k = startCol; k <= endCol && k >= 0 && k < ChessBoard.COL_SIZE; k += 1) {
                if (leftBoard > 0) {
                    legalMoves[leftBoard][j][k] = 1;
                }

                if (rightBoard < numBoards) {
                    legalMoves[rightBoard][j][k] = 1;
                }
            }
        }

        if (leftBoard > 0) {
            legalMoves[leftBoard][row][col] = 1;
        }

        if (rightBoard < numBoards) {
            legalMoves[rightBoard][row][col] = 1;
        }

        return legalMoves;
    }
}
