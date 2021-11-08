package A01207448;

import javax.swing.*;
import java.awt.event.*;

class TileListener implements ActionListener {
    private final ChessBoard board;
    private Tile previouslySelectedTile;

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
            selectedTile.setIsSelectable(true);
            if (selectedTile.getPiece() != null) {
                board.showSelectableTiles(selectedTile.getRow(), selectedTile.getCol());
            }
        } else {
            if (selectedTile.isSelectable()) {
                previouslySelectedTile.setIsSelectable(false);
                board.movePiece(previouslySelectedTile, selectedTile);
                previouslySelectedTile = null;
            }
        }
    }
}
