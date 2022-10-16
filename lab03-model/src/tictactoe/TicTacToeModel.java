package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * This is the model for Tic-Tac-Toe Game.
 *
 */
public class TicTacToeModel implements TicTacToe {
  
  private static final int columns = 3;
  private static final int rows = 3;
  
  private Player player;
  private Player[][] board;
  
  public TicTacToeModel() {
    this.player = Player.X;
    this.board = new Player[3][3];
  }
  
  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using the helpful
    // built-in String.join method.
    // List<String> rows = new ArrayList<>();
    // for(Player[] row : getBoard()) {
    //   List<String> rowStrings = new ArrayList<>();
    //   for(Player p : row) {
    //     if(p == null) {
    //       rowStrings.add(" ");
    //     } else {
    //       rowStrings.add(p.toString());
    //     }
    //   }
    //   rows.add(" " + String.join(" | ", rowStrings));
    // }
    // return String.join("\n-----------\n", rows);
  }
  
  private void flipPlayer() {
    this.player = (this.player == Player.O) ? Player.X : Player.O;
  }
  
  private boolean isValidPosition(int r, int c) {
    return !(r < 0 || c < 0 || r >= rows || c >= columns);
  }

  @Override
  public void move(int r, int c) {
    if (this.isGameOver()) {
      throw new IllegalStateException("Game is alreay over!");
    }
    if (!isValidPosition(r, c) || this.board[r][c] != null) {
      throw new IllegalArgumentException("Illegal Argument!");
    }
    this.board[r][c] = this.player; 
    this.flipPlayer();
  }

  @Override
  public Player getTurn() {
    return this.player;
  }

  @Override
  public boolean isGameOver() {
    
    boolean allTaken = true;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < columns; ++j) {
        if (board[i][j] == null) {
          allTaken = false;
          break;
        }
      }
    }
    if (getWinner() != null || allTaken) {
      return true;
    }
    return false;
    
  }
  
  private Player checkRows() {
    for (int i = 0; i < rows; i++) {
      Player tmpPlayer = board[i][0];
      int j = 0;
      for (; j < columns; ++j) {
        if (tmpPlayer == board[i][j]) {
          continue;
        } else {
          break;
        }
      }
      if (j == columns) {
        return tmpPlayer;
      }
    }
    return null;
  }
  
  private Player checkCols() {
    for (int i = 0; i < columns; i++) {
      Player tmpPlayer = board[0][i];
      int j = 0;
      for (; j < rows; ++j) {
        if (tmpPlayer == board[j][i]) {
          continue;
        } else {
          break;
        }
      }
      if (j == rows) {
        return tmpPlayer;
      }
    }
    return null;
  }
  
  private Player checkDiagnoal() {
    final int limit = Math.min(rows, columns);
    Player tmpPlayer = board[0][0];
    int i = 0;
    for (; i < limit; ++i) {
      if (tmpPlayer == board[i][i]) {
        continue;
      } else {
        break;
      }
    }
    if (i == limit) {
      return tmpPlayer;
    }
    tmpPlayer = board[0][limit - 1];
    i = 0;
    for (; i < limit; ++i) {
      if (tmpPlayer == board[i][limit - 1 - i]) {
        continue;
      } else {
        break;
      }
    }
    if (i == limit) {
      return tmpPlayer;
    }
    return null;
  }

  @Override
  public Player getWinner() {
    Player rowWinnerPlayer = checkRows();
    Player colWinnerPlayer = checkCols();
    Player diaWinnerPlayer = checkDiagnoal();
    if (colWinnerPlayer != null) {
      return colWinnerPlayer;
    } else if (rowWinnerPlayer != null) {
      return rowWinnerPlayer;
    } else if (diaWinnerPlayer != null) {
      return diaWinnerPlayer;
    }
    return null;
  }

  @Override
  public Player[][] getBoard() {
    Player[][] tmpBoard = new Player[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        tmpBoard[i][j] = this.board[i][j]; 
      }
    }
    return tmpBoard;
  }

  @Override
  public Player getMarkAt(int r, int c) {
    if (!this.isValidPosition(r, c)) {
      throw new IllegalArgumentException("Illegal input argumentsout of range!");
    }
    return this.board[r][c];
  }
}
