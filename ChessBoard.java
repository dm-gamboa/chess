package A01207448;

import A01207448.Enums.Color;
import A01207448.Pieces.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class ChessBoard extends JFrame {
    public static final int ROW_SIZE = 8;
    public static final int COL_SIZE = 8;
    public static final int BOARD_SIZE = 650;

    private final List<Tile> tiles;
    private final TileListener tileListener;

    public ChessBoard() {
        tileListener = new TileListener(this);
        this.setLayout(new GridLayout(8, 18));
        this.setSize(BOARD_SIZE, BOARD_SIZE);

        tiles = new ArrayList<Tile>();
        for (int i = 1; i <= COL_SIZE; i++) {
            for (int j = 1; j <= ROW_SIZE; j++) {
                final Tile tile = new Tile(i, j, tileListener);
                tiles.add(tile);
                add(tile);
            }
        }

        setup();
    }

    List<Tile> getTiles(int[][] pos) {
        return null;
    }

    void movePiece(Tile origin, Tile destination) {
    }

    void clear() {
        for (Tile tile : tiles) {
            tile.setPiece(null);
        }
    }

    private void setupBackRow(Color color) {
        int row = color == Color.BLACK ? 0 : 7;

        List<Piece> pieces = Arrays.asList(new Rook(color), new Knight(color), new Bishop(color), new Queen(color),
                new King(color), new Bishop(color), new Knight(color), new Rook(color));

        for (int i = 0; i < ROW_SIZE; i++) {
            int index = (row * ROW_SIZE) + i;

            tiles.get(index).setPiece(pieces.get(i));
        }
    }

    private void setupFrontRow(Color color) {
        int row = color == Color.BLACK ? 1 : 6;

        for (int i = 0; i < ROW_SIZE; i++) {
            int index = (row * ROW_SIZE) + i;
            tiles.get(index).setPiece(new Pawn(color));
        }
    }

    void setup() {
        setupBackRow(Color.BLACK);
        setupFrontRow(Color.BLACK);

        setupFrontRow(Color.WHITE);
        setupBackRow(Color.WHITE);
    }

    public void hide() {
    }

    public void display() {
    }

    void showSelectableTiles(int[][] pos) {
    }
}
