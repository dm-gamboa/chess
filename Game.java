package A01207448;

import A01207448.Enums.*;
import A01207448.Pieces.*;

import java.awt.GridLayout;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {
  Menu menu;
  List<ChessBoard> boards;
  GameStatus status;
  GameResult result;
  List<Player> players;
  private Tile previouslySelectedTile;
  private ChessBoard previouslySelectedBoard;

  Game() {
    status = GameStatus.ONGOING;
    boards = new ArrayList<ChessBoard>();
    setUpBoards(3);
    start();

    players = new ArrayList<Player>();
    players.add(new Player(Color.WHITE));
    players.add(new Player(Color.BLACK));
    this.setVisible(true);
  }

  public void setStatus(GameStatus status) {
    this.status = status;
  }

  public GameStatus getStatus() {
    return this.status;
  }

  public GameResult getResult() {
    return this.result;
  }

  public Color getNextPlayer() {
    Player whitePlayer = players.get(0);
    Player blackPlayer = players.get(1);
    boolean nextMoveWhite = whitePlayer.getMoves().size() == blackPlayer.getMoves().size();
    return nextMoveWhite ? Color.WHITE : Color.BLACK;
  }

  public int getNumBoards() {
    return boards.size();
  }

  public Tile getPreviouslySelectedTile() {
    return previouslySelectedTile;
  }

  public ChessBoard getPreviouslySelectedBoard() {
    return previouslySelectedBoard;
  }

  void setPreviouslySelectedTile(Tile tile) {
    previouslySelectedTile = tile;
  }

  void setPreviouslySelectedBoard(ChessBoard board) {
    previouslySelectedBoard = board;
  }

  void deselectTiles() {
    previouslySelectedTile = null;
    previouslySelectedBoard = null;
    for (ChessBoard board : boards) {
      board.deselectTiles();
    }
  }

  void setUpBoards(int numBoards) {
    int width = ChessBoard.BOARD_SIZE * numBoards;
    this.setSize(width, ChessBoard.BOARD_SIZE);
    this.setLayout(new GridLayout(1, numBoards));

    for (int i = 0; i < numBoards; i++) {
      boards.add(new ChessBoard(this, i));
    }

    for (ChessBoard board : boards) {
      add(board);
    }
  }

  void start() {
    for (ChessBoard board : boards) {
      board.setVisible(true);
    }
  }

  void restart() {}

  void end() {}

  private boolean isTileObstructed(Tile selectedTile, Color pieceToMoveColor) {
    Piece selectedPiece = selectedTile.getPiece();
    
    if (selectedPiece != null && selectedPiece.color == pieceToMoveColor) {
      return true;
    }
    
    return false;
  }

  private int getBounds(Direction direction, int startingPos, int maxSpacesToMove) {

    switch (direction) {
      case NORTH:
        startingPos -= maxSpacesToMove;
        return startingPos > 0 ? startingPos - 1 : -1;
      case SOUTH:
        startingPos += maxSpacesToMove;
        return startingPos < ChessBoard.COL_SIZE ? startingPos + 1 : ChessBoard.COL_SIZE; 
      case EAST:
        startingPos += maxSpacesToMove;
        return startingPos < ChessBoard.ROW_SIZE ? startingPos + 1 : ChessBoard.ROW_SIZE;
      case WEST:
        startingPos -= maxSpacesToMove;
        return startingPos > 0 ? startingPos - 1 : -1;
    }

    return -1;
  }

  private void showLegalMoves(Direction verticalDirection, Direction horizontalDirection, int[][][] legalMoves, int boardIndex, Piece pieceToMove,  int row, int col, int maxSpacesToMove) {
    int currentRow = row;
    int currentCol = col;
    int rowBound = getBounds(verticalDirection, row, maxSpacesToMove);
    int colBound = getBounds(horizontalDirection, col, maxSpacesToMove);

    if (boardIndex == 2 && row == 7 && col == 7) {
      System.out.println(legalMoves[2][7][7]);
    }

    while (rowBound != currentRow) {
      while (colBound != currentCol) {
        Tile selectedTile = boards.get(boardIndex).getTile(currentRow, currentCol);
        if (legalMoves[boardIndex][currentRow][currentCol] == 1) {
          if (!isTileObstructed(selectedTile, pieceToMove.getColor())) {
            selectedTile.setIsSelectable(true);
          }
        } else {
          selectedTile.setIsSelectable(false);
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


  void showSelectableTilesOnOtherBoards(Piece piece, int boardIndex, int row, int col) {
    int[][][] legalMoves = piece.getLegalMovesToOtherBoards(row, col, boardIndex, boards.size());

    if (legalMoves == null) {
      return; // 3d chess movements for other pieces not yet implemented
    }

    int maxSpacesToMove = boards.size();

    for (int i = 0; i < boards.size(); i++) {
      if (i != boardIndex) {
        showLegalMoves(Direction.NORTH, Direction.EAST, legalMoves, i, piece, row, col, maxSpacesToMove);
        showLegalMoves(Direction.NORTH, Direction.WEST, legalMoves, i, piece, row, col, maxSpacesToMove);
        showLegalMoves(Direction.SOUTH, Direction.EAST, legalMoves, i, piece, row, col, maxSpacesToMove);
        showLegalMoves(Direction.SOUTH, Direction.WEST, legalMoves, i, piece, row, col, maxSpacesToMove);
      }
    }
  }

  public void movePiece(Tile origin, Tile destination) {
    if (origin != destination) {
      Piece pieceToMove = origin.getPiece();
      destination.setPiece(pieceToMove);
      origin.setPiece(null);
      pieceToMove.hasMoved(true);

      Player whitePlayer = players.get(0);
      Player blackPlayer = players.get(1);
      if (whitePlayer.getMoves().size() > blackPlayer.getMoves().size()) {
          blackPlayer.addMove(new Move());
      } else {
          whitePlayer.addMove(new Move());
      }
    }
  }
}
