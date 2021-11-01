package A01207448.Pieces;

import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Pawn extends Piece {
    private boolean hasMoved;

    public Pawn(Color color) {
        super(color, PieceNotation.P);
        hasMoved = false;
    }

    @Override
    public int[][] getLegalMoves() {
        return null;
    }
}
