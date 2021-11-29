package A01207448;

import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Piece {
    protected final Color color;
    protected final PieceNotation notation;
    protected boolean hasMoved;

    public Piece(Color color, PieceNotation notation) {
        this.color = color;
        this.notation = notation;
    }

    Color getColor() {
        return color;
    }

    String getColorNotation() {
        return color == Color.WHITE ? "W" : "B";
    }

    PieceNotation getNotation() {
        return notation;
    }

    boolean hasMoved() {
        return hasMoved;
    }

    void hasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    void capture() {}

    public int[][] getLegalMoves(int row, int col) {
        return null;
    }

    public int[][][] getLegalMovesToOtherBoards(int row, int col, int boardIndex, int numBoards) {
        return null;
    }
}
