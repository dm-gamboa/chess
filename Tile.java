package A01207448;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.*;

public class Tile  extends JButton {
    public static Color DARK_TILE = new Color(112,80,77); // Medium Taupe
    public static Color LIGHT_TILE = new Color(239, 222, 205); // Almond
    public static final Color SELECTABLE_TILE = new Color(76, 153, 0); // Green

    private final int row;
    private final int col;
    private JLabel label;
    private Piece piece;
    private boolean isSelectable;
    private Color color;

    Tile (int row, int col, ActionListener actionListener) {
        this.row = row;
        this.col = col;
        piece = null;
        isSelectable = false;
        label = new JLabel();
        this.add(label);
        
        color = getColor(row, col);
        this.setBackground(color);  
        this.setOpaque(true); // Needed to make tile colour visible in Mac sOS
        this.setBorderPainted(false); // Needed to make tile colour visible in Mac OS
        this.addActionListener(actionListener);
    }

    void setPiece(Piece piece) {
        String text = "";
        if (piece != null) {
            text += piece.getColorNotation() + piece.getNotation().name();
        }
        label.setText(text);
        this.piece = piece;
    }

    void setIsSelectable(boolean isSelectable) {
        this.isSelectable = isSelectable;
        if (isSelectable) {
            this.setBackground(SELECTABLE_TILE);
        } else {
            this.setBackground(color);
        }
    }

    /**
     * Helper function to determine tile colour based on
     * tile's given row and col
     * @param row
     * @param col
     * @return
     */
    private Color getColor(int row, int col) {
        Color startingColor = LIGHT_TILE;
        Color altColor = DARK_TILE;

        // Swap colours every other row
        if (row % 2 == 0) {
            startingColor = DARK_TILE;
            altColor = LIGHT_TILE;
        }

        return col % 2 == 0 ? altColor : startingColor;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    boolean isSelectable() {
        return isSelectable;
    }

    Piece getPiece() {
        return piece;
    }
}
