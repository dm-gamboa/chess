package A01207448;

import A01207448.Enums.*;

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

  void setUpBoards(int numBoards) {
    int width = ChessBoard.BOARD_SIZE * numBoards;
    this.setSize(width, ChessBoard.BOARD_SIZE);
    this.setLayout(new GridLayout(1, numBoards));

    for (int i = 0; i < numBoards; i++) {
      boards.add(new ChessBoard(this, i == 0));
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
}
