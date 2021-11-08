package A01207448;

import javax.swing.*;
import java.awt.event.*;

class TileListener implements ActionListener {
    private final ChessBoard board;
    private final Game game;
    private Tile previouslySelectedTile;

    TileListener(ChessBoard board) {
        this.board = board;
        this.game = board.game;
        previouslySelectedTile = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selected = (JButton) e.getSource();
        Tile selectedTile = (Tile) selected;
        Piece selectedPiece = selectedTile.getPiece();

        if (previouslySelectedTile != null) {
            if (selectedTile.isSelectable()) {
                previouslySelectedTile.setIsSelectable(false);
                board.movePiece(previouslySelectedTile, selectedTile);
                previouslySelectedTile = null;
            }
        } else if (selectedPiece != null && selectedPiece.getColor() == game.getNextPlayer()) {
            previouslySelectedTile = selectedTile;
            selectedTile.setIsSelectable(true);
            if (selectedTile.getPiece() != null) {
                board.showSelectableTiles(selectedTile.getRow(), selectedTile.getCol());
            }
        }
    }
}
