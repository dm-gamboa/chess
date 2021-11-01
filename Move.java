package A01207448;

import java.util.List;

import A01207448.Enums.MoveType;

public class Move {
    private final int[][] startPos;
    private final int[][] endPos;
    private final List<Piece> pieces;
    private final boolean didCheck;
    private final MoveType type;

    Move(int[][] startPos, int[][] endPos, List<Piece> pieces, boolean didCheck, MoveType type) {
        this.startPos = startPos;
        this.endPos = endPos;
        this.pieces = pieces;
        this.didCheck = didCheck;
        this.type = type;
    }

    public int[][] getStartPos() {
        return startPos;
    }

    public int[][] getEndPos() {
        return endPos;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public boolean didCheck() {
        return didCheck;
    }

    public MoveType getType() {
        return type;
    }

    public String toString() {
        return "";
    }
}
