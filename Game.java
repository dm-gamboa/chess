package A01207448;

import A01207448.Enums.GameResult;
import A01207448.Enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {
  Menu menu;
  ChessBoard board;
  GameStatus status;
  GameResult result;
  List<Player> players;

  Game() {
    status = GameStatus.ONGOING;
    board = new ChessBoard();
    start();
    players = new ArrayList<Player>();
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

  void start() {
    board.setVisible(true);
  }

  void restart() {}

  void end() {}
}
