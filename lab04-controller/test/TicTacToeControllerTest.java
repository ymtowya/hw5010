import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.io.StringWriter;
import org.junit.Before;
import org.junit.Test;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeConsoleController;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;

/**
 * Test cases for the tic tac toe controller, using mocks for readable and
 * appendable.
 */
public class TicTacToeControllerTest {

  // Providing this shell for you to write your
  // own test cases for the TicTacToe controller
  // You DO NOT NEED to implement tests for the provided model

  // TODO: Implement your own tests cases for the controller

  private TicTacToe model;
  private StringWriter stringWriter;

  @Before
  public void setUp() {
    model = new TicTacToeModel();
    stringWriter = new StringWriter();
  }

  /**
   * Test if the game can run smoothly without any exception with valid inputs, and end with Tie.
   *
   */
  @Test
  public void testNormalTieGame() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertEquals(getTieResultString(), stringWriter.toString());
  }
  
  /**
   * Test exception thrown when model is invalid.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalGameModel() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(null);
  }
  
  /**
   * Test error message when input row is invalid.
   *
   */
  @Test
  public void testInvalidRow() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 two 2 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertTrue(stringWriter.toString().contains("Not a valid number: two"));
  }
  
  /**
   * Test error message when input column is invalid.
   *
   */
  @Test
  public void testInvalidCol() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 one 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertTrue(stringWriter.toString().contains("Not a valid number: one"));
  }
  
  /**
   * Test error message when input row is out of bounds.
   *
   */
  @Test
  public void testRowOutBnd() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 4 3 2 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertTrue(stringWriter.toString().contains("Not a valid move: 4, 3\n"));
  }
  
  /**
   * Test exception thrown when input col is out of bounds.
   *
   */
  @Test
  public void testColOutBnd() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 4 2 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertTrue(stringWriter.toString().contains("Not a valid move: 2, 4\n"));
  }
  
  /**
   * Test game model quit when input row is Q.
   *
   */
  @Test
  public void testRowQ() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 q 3 2 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertEquals(" O | O | X\n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   | X", model.toString());
  }
  
  /**
   * Test game state quit when input column is Q.
   *
   */
  @Test
  public void testColQ() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 q 2 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertEquals(" O | O | X\n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   | X", model.toString());
  }
  
  /**
   * Test game state when input is one valid move.
   *
   */
  @Test
  public void testValidMove() {
    StringReader input = new StringReader("2 1 q");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  ", model.toString());
  }
  
  /**
   * Test game state when input is one occupied space.
   *
   */
  @Test
  public void testOccupiedSpace() {
    StringReader input = new StringReader("2 2 1 2 3 3 1 1 1 3 1 2 q");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertTrue(stringWriter.toString().contains("Not a valid move: 1, 2"));
    assertEquals(" O | O | X\n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   | X", model.toString());
  }

  /**
   * Test game continues after input is one occupied space.
   *
   */
  @Test
  public void testContinue() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 1 1 2 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    assertTrue(stringWriter.toString().contains("Not a valid move: 1, 1"));
    assertEquals(" O | O | X\n"
        + "-----------\n"
        + " X | X | O\n"
        + "-----------\n"
        + " O | X | X", model.toString());
  }

  /**
   * Test invalid input.
   *
   */
  @Test
  public void testInvalidInput1() {
    StringReader input = new StringReader("1 1 2 2 1 3 1 2 3 3 1 3 q");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
    String expectString = "   |   |  \n" + "-----------\n" + "   |   |  \n" + "-----------\n"
        + "   |   |  \n" + "Enter a move for X:\n" + " X |   |  \n" + "-----------\n"
        + "   |   |  \n" + "-----------\n" + "   |   |  \n" + "Enter a move for O:\n"
        + " X |   |  \n" + "-----------\n" + "   | O |  \n" + "-----------\n" + "   |   |  \n"
        + "Enter a move for X:\n" + " X |   | X\n" + "-----------\n" + "   | O |  \n"
        + "-----------\n" + "   |   |  \n" + "Enter a move for O:\n" + " X | O | X\n"
        + "-----------\n" + "   | O |  \n" + "-----------\n" + "   |   |  \n"
        + "Enter a move for X:\n" + " X | O | X\n" + "-----------\n" + "   | O |  \n"
        + "-----------\n" + "   |   | X\n" + "Enter a move for O:\n" + "Not a valid move: 1, 3\n"
        + "Game quit! Ending game state:\n" + " X | O | X\n" + "-----------\n" + "   | O |  \n"
        + "-----------\n" + "   |   | X\n";
    assertEquals(expectString, stringWriter.toString());
  }

  @Test
  public void testInvalidInput2() {
    StringReader input = new StringReader("2 2 1 1 3 3 0 1 2 1 3 2 3 1 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
  }

  @Test
  public void testInvalidState1() {
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    TicTacToeController c = new TicTacToeConsoleController(input, stringWriter);
    c.playGame(model);
  }

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    // Testing when something goes wrong with the Appendable
    // Here we are passing it a mock of an Appendable that always fails
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
  }
  
  private String getTieResultString() {
    String reString = "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " O |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " O |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   | X\n"
        + "Enter a move for O:\n"
        + " O | O |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   | X\n"
        + "Enter a move for X:\n"
        + " O | O | X\n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   | X\n"
        + "Enter a move for O:\n"
        + " O | O | X\n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + "   |   | X\n"
        + "Enter a move for X:\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X | X | O\n"
        + "-----------\n"
        + "   |   | X\n"
        + "Enter a move for O:\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X | X | O\n"
        + "-----------\n"
        + " O |   | X\n"
        + "Enter a move for X:\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X | X | O\n"
        + "-----------\n"
        + " O | X | X\n"
        + "Game is over! Tie game.\n";
    return reString;
  }
}
