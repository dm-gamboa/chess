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

    @Override
    public int[][][] getLegalMovesToOtherBoards(int row, int col, int boardIndex, int numBoards) {
        int[][][] legalMoves = new int[numBoards][ChessBoard.ROW_SIZE][ChessBoard.COL_SIZE];
        int leftBoard = boardIndex - 1;
        int rightBoard = boardIndex + 1;

        for (int i = 2; i > 0; i--) {
            if (row + i < ChessBoard.ROW_SIZE) {
                if (leftBoard >= 0) {
                    legalMoves[leftBoard][row + i][col] = 1;
                }
                
                if (rightBoard < numBoards) {
                    legalMoves[rightBoard][row + i][col] = 1;
                }
            }

            if (row - i >= 0) {
                if (leftBoard >= 0) {
                    legalMoves[leftBoard][row - i][col] = 1;
                }
                
                if (rightBoard < numBoards) {
                    legalMoves[rightBoard][row - i][col] = 1;
                }
            }
            
            if (col + i < ChessBoard.COL_SIZE) {
                if (leftBoard >= 0) {
                    legalMoves[leftBoard][row][col + i] = 1;
                }
                
                if (rightBoard < numBoards) {
                    legalMoves[rightBoard][row][col + i] = 1;
                }
            }
            
            if (col - i >= 0) {
                if (leftBoard >= 0) {
                    legalMoves[leftBoard][row][col - i] = 1;
                }
                
                if (rightBoard < numBoards) {
                    legalMoves[rightBoard][row][col - i] = 1;
                }
            }

            leftBoard--;
            rightBoard++;
        }

        return legalMoves;
    }
}
