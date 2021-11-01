package A01207448.Pieces;

import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Rook extends Piece {
    private boolean hasMoved;

    public Rook(Color color) {
        super(color, PieceNotation.R);
        hasMoved = false;
    }

    @Override
    public int[][] getLegalMoves() {
        return null;
    }
}
