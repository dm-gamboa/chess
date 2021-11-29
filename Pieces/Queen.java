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
        int leftBoards = boardIndex - 1;
        int rightBoards = boardIndex + 1;

        while (rightBoards < numBoards && rightBoards < numBoards) {
            int diagonalMove = Math.abs(rightBoards - boardIndex);
            int startRow = row - diagonalMove;
            int startCol = col - diagonalMove;
            int endRow = row + diagonalMove;
            int endCol = col + diagonalMove;

            for (int i = startRow; i <= endRow && i >= 0 && i < ChessBoard.ROW_SIZE; i += diagonalMove) {
                for (int j = startCol; j <= endCol && j >= 0 && j < ChessBoard.ROW_SIZE; j += diagonalMove) {
                    legalMoves[rightBoards][i][j] = 1;
                }
            }
            
            legalMoves[rightBoards][row][col] = 1;

            
            rightBoards++;
        }

        while (leftBoards < numBoards && leftBoards >= 0) {
            int diagonalMove = Math.abs(leftBoards - boardIndex);
            int startRow = row - diagonalMove;
            int startCol = col - diagonalMove;
            int endRow = row + diagonalMove;
            int endCol = col + diagonalMove;

            for (int i = startRow; i <= endRow && i >= 0 && i < ChessBoard.ROW_SIZE; i -= diagonalMove) {
                for (int j = startCol; j <= endCol && j >= 0 && j < ChessBoard.ROW_SIZE; j -= diagonalMove) {
                    legalMoves[leftBoards][i][j] = 1;
                }
            }
            
            legalMoves[leftBoards][row][col] = 1;

            
            leftBoards--;
        }

        return legalMoves;
    }
}
