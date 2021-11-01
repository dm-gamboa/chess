package A01207448.Pieces;

import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color, PieceNotation.B);
    }

    @Override
    public int[][] getLegalMoves() {
        return null;
    }
}
