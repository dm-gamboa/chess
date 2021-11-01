package A01207448;

import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Piece {
    private final Color color;
    private final PieceNotation notation;

    public Piece(Color color, PieceNotation notation) {
        this.color = color;
        this.notation = notation;
    }

    Color getColor() {
        return color;
    }

    PieceNotation getNotation() {
        return notation;
    }

    void capture() {}

    public int[][] getLegalMoves() {
        return null;
    }
}
