package A01207448.Pieces;

import A01207448.Piece;
import A01207448.Enums.Color;
import A01207448.Enums.PieceNotation;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, PieceNotation.Q);
    }

    @Override
    public int[][] getLegalMoves() {
        return null;
    }
}
