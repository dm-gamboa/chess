package A01207448;

import javax.swing.*;
import java.awt.event.*;

class TileListener implements ActionListener {
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
        ChessBoard previouslySelectedBoard = game.getPreviouslySelectedBoard();

        if (previouslySelectedTile != null) {
            if (selectedTile.isSelectable()) {
                previouslySelectedTile.setIsSelectable(false);
                game.movePiece(previouslySelectedTile, selectedTile);
                game.deselectTiles();
            }
        } else if (selectedPiece != null && selectedPiece.getColor() == game.getNextPlayer()) {
            game.setPreviouslySelectedTile(selectedTile);
            game.setPreviouslySelectedBoard(board);
            selectedTile.setIsSelectable(true);

            if (selectedPiece != null) {
                int row = selectedTile.getRow();
                int col = selectedTile.getCol();
                int boardIndex = board.getIndex();

                board.showSelectableTiles(row, col);
                game.showSelectableTilesOnOtherBoards(selectedPiece, boardIndex, row, col);
            }
        }
    }
}
