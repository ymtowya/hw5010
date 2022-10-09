package tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * This starter files is for students to implement a console controller for the
 * TicTacToe MVC assignment.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private final Appendable out;
  private final Scanner scan;
  
  private TicTacToe model;

  /**
   * Constructor for the controller.
   * 
   * @param in  the source to read from
   * @param out the target to print to
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }
  
  /**
   * Get next String from the Scanner scan.
   * @return next String input
   */
  private String  getNextString() {
    String reString = scan.next();
    return reString;
  }
  
  /**
   * Get the prompt string for the model.
   *
   * @param m the model asking for prompt string
   * @return the prompt string
   */
  private String getPromptString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getGameStateString());
    sb.append(String.format("Enter a move for %s:\n", model.getTurn().name()));
    return sb.toString();
  }
  
  /**
   * Get the state of the game.
   *
   * @param m the model to be depicted
   * @return string of model
   */
  private String getGameStateString() {
    return model.toString().concat("\n");
  }
  
  /**
   * User quits.
   * @param m model of the game
   * @throws IOException when append of out failed
   */
  private void userQuits() throws IOException {
    StringBuilder sb = new StringBuilder();
    sb.append("Game quit! Ending game state:\n")
        .append(getGameStateString());
    out.append(sb.toString());
  }
  
  /**
   * The game ends, and get the string as final words.
   *
   * @param m model of the game
   * @return string of the end words
   */
  private String gameEndString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getGameStateString());
    sb.append("Game is over! ");
    if (model.getWinner() == null) {
      sb.append("Tie game.\n");
    } else {
      sb.append(String.format("%s wins.\n", model.getWinner().name()));
    }
    return sb.toString();
  }
  
  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException("Model is Null\n");
    }
    this.model = m;
    boolean endedWithErr = false;
    try {
      while (!model.isGameOver()) {
        if (!endedWithErr) {
          out.append(getPromptString());
        }
        int pos1 = -1;
        int pos2 = -1;
        String pos1String = getNextString();
        if ("q".equalsIgnoreCase(pos1String)) {
          userQuits();
          return;
        }
        try {
          pos1 = Integer.parseInt(pos1String);
        } catch (NumberFormatException e) {
          out.append(String.format("Not a valid number: %s\n", pos1String));
          endedWithErr = true;
          continue;
        }
        String pos2String = getNextString();
        while (true) {
          if ("q".equalsIgnoreCase(pos2String)) {
            userQuits();
            return;
          }
          try {
            pos2 = Integer.parseInt(pos2String);
          } catch (NumberFormatException e) {
            out.append(String.format("Not a valid number: %s\n", pos2String));
            endedWithErr = true;
            pos2String = getNextString();
            continue;
          }
          break;
        }
        try {
          model.move(pos1 - 1, pos2 - 1);
          endedWithErr = false;
        } catch (IllegalArgumentException e) {
          out.append(String.format("Not a valid move: %d, %d\n", pos1, pos2));
          endedWithErr = true;
        } catch (IllegalStateException e) {
          out.append(String.format("Not a valid move: %d, %d\n", pos1, pos2));
          endedWithErr = true;
        }
        
      }
      out.append(gameEndString());
    } catch (IOException ioe) {
      throw new IllegalStateException("Append failed", ioe);
    }
  }

}
