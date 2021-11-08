package A01207448;

import A01207448.Enums.*;

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
    board = new ChessBoard(this);
    start();
    players = new ArrayList<Player>();
    players.add(new Player(Color.WHITE));
    players.add(new Player(Color.BLACK));
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

  void start() {
    board.setVisible(true);
  }

  void restart() {}

  void end() {}
}
