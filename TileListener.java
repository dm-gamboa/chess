package A01207448;

import javax.swing.*;
import java.awt.event.*;

class TileListener implements ActionListener {
    static final int CLICK_DELAY = 1000;
    private final ChessBoard board;
    private final Game game;

    TileListener(ChessBoard board) {
        this.board = board;
        this.game = board.game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selected = (JButton) e.getSource();
        Tile selectedTile = (Tile) selected;
        Piece selectedPiece = selectedTile.getPiece();

        Tile previouslySelectedTile = game.getPreviouslySelectedTile();

        if (previouslySelectedTile != null) {
            if (selectedTile.isSelectable() && !previouslySelectedTile.equals(selectedTile)) {
                game.movePiece(previouslySelectedTile, selectedTile);
            }
            game.setPreviouslySelectedTile(null);
            game.deselectTiles();
        } else if (selectedPiece != null && selectedPiece.getColor() == game.getNextPlayer()) {
            game.setPreviouslySelectedTile(selectedTile);
            selectedTile.setIsSelectable(true);

            int row = selectedTile.getRow();
            int col = selectedTile.getCol();
            int boardIndex = board.getIndex();

            board.showSelectableTiles(row, col);
            game.showSelectableTilesOnOtherBoards(selectedPiece, boardIndex, row, col);
        }

        game.repaint();
    }
}
