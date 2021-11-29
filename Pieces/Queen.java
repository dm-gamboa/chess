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

        legalMoves[row][col] = 0;
        return legalMoves;
    }

    @Override
    public int[][][] getLegalMovesToOtherBoards(int row, int col, int boardIndex, int numBoards) {
        int[][][] legalMoves = new int[numBoards][ChessBoard.ROW_SIZE][ChessBoard.COL_SIZE];

        for (int i = 0; i < numBoards; i++) {
            if (i != boardIndex) {
                int diagonalMove = Math.abs(i - boardIndex);
                int startRow = (row - diagonalMove) < 0 ? row : row - diagonalMove;
                int startCol = (col - diagonalMove) < 0 ? col : col - diagonalMove;
                int endRow = row + diagonalMove;
                int endCol = col + diagonalMove;

                for (int j = startRow; j <= endRow && j >= 0 && j < ChessBoard.ROW_SIZE; j += diagonalMove) {
                    for (int k = startCol; k <= endCol && k >= 0 && k < ChessBoard.COL_SIZE; k += diagonalMove) {
                        legalMoves[i][j][k] = 1;
                    }
                }

                legalMoves[i][row][col] = 1;
            }
        }

        return legalMoves;
    }
}
