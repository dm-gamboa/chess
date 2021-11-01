package A01207448.Pieces;

import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class King extends Piece {
    private boolean hasMoved;

    public King(Color color) {
        super(color, PieceNotation.K);
        hasMoved = false;
    }

    @Override
    public int[][] getLegalMoves() {
        return null;
    }
}
