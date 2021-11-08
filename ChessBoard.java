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
    
    private static enum Direction { NORTH, SOUTH, EAST, WEST };

    private final List<Tile> tiles;
    private final TileListener tileListener;
    final Game game;

    public ChessBoard(Game game) {
        this.game = game;

        tileListener = new TileListener(this);
        this.setLayout(new GridLayout(8, 18));
        this.setSize(BOARD_SIZE, BOARD_SIZE);

        tiles = new ArrayList<Tile>();
        for (int i = 0; i < COL_SIZE; i++) {
            for (int j = 0; j < ROW_SIZE; j++) {
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
        if (origin != destination) {
            Piece pieceToMove = origin.getPiece();
            destination.setPiece(pieceToMove);
            origin.setPiece(null);
            pieceToMove.hasMoved(true);

            Player whitePlayer = game.players.get(0);
            Player blackPlayer = game.players.get(1);
            if (whitePlayer.getMoves().size() > blackPlayer.getMoves().size()) {
                blackPlayer.addMove(new Move());
            } else {
                whitePlayer.addMove(new Move());
            }
        }

        for (Tile tile : tiles) {
            tile.setIsSelectable(false);
        }
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

    private void showLegalMoves(Direction verticalDirection, Direction horizontalDirection, int row, int col, int[][] legalMoves,  Piece pieceToMove) {
        int currentRow = row;
        int currentCol = col;
        int rowBound = verticalDirection == Direction.NORTH ? -1 : COL_SIZE;
        int colBound = horizontalDirection == Direction.WEST ? -1 : ROW_SIZE;

        while (currentRow != rowBound) {
            while (currentCol != colBound) {

                if (legalMoves[currentRow][currentCol] == 1) {
                    int index = (currentRow * ROW_SIZE) + currentCol;
                    Tile tile = tiles.get(index);
                    Piece pieceInCurrentTile = tile.getPiece();
    
                    if (pieceInCurrentTile != null) {
                        boolean canCaptureOtherPiece = pieceToMove.getColor() != pieceInCurrentTile.getColor();
                        if (!(pieceToMove instanceof Pawn) && canCaptureOtherPiece) {
                            tile.setIsSelectable(true);
                        }

                        if (!(pieceToMove instanceof Knight)) {
                            colBound = currentCol;
                            break;
                        }
                    } else {
                        tile.setIsSelectable(true);
                    }
                }

                if (horizontalDirection == Direction.WEST) {
                    currentCol--;
                } else {
                    currentCol++;
                }
            }

            if (verticalDirection == Direction.NORTH) {
                currentRow--;
            } else {
                currentRow++;
            }
            currentCol = col;
        }
    }

    void showSelectableTiles(int row, int col) {
        int index = (row * ROW_SIZE) + col;
        Tile tile = tiles.get(index);
        Piece pieceToMove = tile.getPiece();
        int pos[][] = tile.getPiece().getLegalMoves(row, col);
        showLegalMoves(Direction.NORTH, Direction.EAST, row, col, pos, pieceToMove);
        showLegalMoves(Direction.NORTH, Direction.WEST, row, col - 1, pos, pieceToMove);
        showLegalMoves(Direction.SOUTH, Direction.EAST, row + 1, col, pos, pieceToMove);
        showLegalMoves(Direction.SOUTH, Direction.WEST, row + 1, col - 1, pos, pieceToMove);

        if (pieceToMove instanceof Queen || pieceToMove instanceof King) {
            showLegalMoves(Direction.NORTH, Direction.EAST, row - 1, col + 1, pos, pieceToMove);
            showLegalMoves(Direction.NORTH, Direction.WEST, row - 1, col - 1, pos, pieceToMove);
            showLegalMoves(Direction.SOUTH, Direction.EAST, row + 1, col + 1, pos, pieceToMove);
            showLegalMoves(Direction.SOUTH, Direction.WEST, row + 1, col - 1, pos, pieceToMove);
        }

        if (pieceToMove instanceof Pawn) {
            int leftDiagonalIndex = pieceToMove.getColor() == Color.BLACK ? index + 9 : index - 9;
            int rightDiagonalIndex = pieceToMove.getColor() == Color.BLACK ? index + 7 : index - 7;


            Tile leftDiagonalTile = tiles.get(leftDiagonalIndex);
            Piece leftDiagonalPiece = leftDiagonalTile.getPiece();

            if (leftDiagonalPiece != null) {
                boolean canCaptureLeftPiece = leftDiagonalPiece.getColor() != pieceToMove.getColor();
                if (canCaptureLeftPiece) {
                    leftDiagonalTile.setIsSelectable(true);
                }
            }

            Tile rightDiagonalTile = tiles.get(rightDiagonalIndex);
            Piece rightDiagonalPiece = rightDiagonalTile.getPiece();

            if (rightDiagonalPiece != null) {
                boolean canCaptureRightPiece = rightDiagonalPiece.getColor() != pieceToMove.getColor();
                if (canCaptureRightPiece) {
                    rightDiagonalTile.setIsSelectable(true);
                }
            }

        }
    }
}
