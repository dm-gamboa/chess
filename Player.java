package A01207448;

import java.util.ArrayList;
import java.util.List;

import A01207448.Enums.Color;

public class Player {
    private final Color color;
    private int points;
    private boolean isChecked;
    private List<Piece> captured;
    private List<Move> moves;

    Player(Color color) {
        this.color = color;
        points = 0;
        isChecked = false;
        captured = new ArrayList<Piece>();
        moves = new ArrayList<Move>();
    }

    List<Move> getMoves() {
        return moves;
    }

    void addCaptured(Piece piece) {}

    void addMove(Move move) {
        moves.add(move);
    }
}
