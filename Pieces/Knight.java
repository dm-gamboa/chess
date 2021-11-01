package A01207448.Pieces;

import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color, PieceNotation.N);
    }

    @Override
    public int[][] getLegalMoves() {
        return null;
    }
}
