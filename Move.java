package A01207448;

import java.util.ArrayList;
import java.util.List;

import A01207448.Enums.MoveType;

public class Move {
    private final int[][] startPos;
    private final int[][] endPos;
    private final List<Piece> pieces;
    private final boolean didCheck;
    private final MoveType type;

    // Placeholder while Move obj is not implemented yet
    Move() {
        this.startPos = new int[1][1];
        this.endPos = new int[1][1];
        this.pieces = new ArrayList<>();
        this.didCheck = false;
        this.type = MoveType.TRAVEL;
    }

    // Move(int[][] startPos, int[][] endPos, List<Piece> pieces, boolean didCheck, MoveType type) {
        // this.startPos = startPos;
        // this.endPos = endPos;
        // this.pieces = pieces;
        // this.didCheck = didCheck;
        // this.type = type;
    // }

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
