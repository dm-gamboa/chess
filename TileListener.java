package A01207448;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

class TileListener implements ActionListener {
    private final ChessBoard board;
    private Tile previouslySelectedTile;
    private Color previouslySelectedTileColor;
    public static final Color SELECTED_TILE = new Color(76, 153, 0);

    TileListener(ChessBoard board) {
        this.board = board;
        previouslySelectedTile = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selected = (JButton)e.getSource();
        Tile selectedTile = (Tile) selected;
        if (previouslySelectedTile == null) {
            previouslySelectedTile = selectedTile;
            previouslySelectedTileColor = selectedTile.getBackground();
            selectedTile.setBackground(SELECTED_TILE);
        } else {
            selectedTile.setPiece(previouslySelectedTile.getPiece());
            previouslySelectedTile.setPiece(null);
            previouslySelectedTile.setBackground(previouslySelectedTileColor);
            previouslySelectedTile = null;
            previouslySelectedTileColor = null;
        }
    }
}
