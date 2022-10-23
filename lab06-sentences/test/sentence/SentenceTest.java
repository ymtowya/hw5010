package sentence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * Sentence Test.
 *
 */
public class SentenceTest {
  
  private Sentence sentence;

  /**
   * Set up.
   *
   */
  @Before
  public void setUp() throws IOException {
    sentence = new WordNode("Hello", new WordNode("World", 
        new PunctuationNode("!", new WordNode("Good", 
            new PunctuationNode("?", new EmptyNode())))));
  }

  @Test
  public final void testEmptyWord1() {
    Sentence s = new EmptyNode();
    assertEquals(0, s.getNumberOfWords());
  }
  
  @Test
  public final void testWordNumber1() {
    Sentence s = new WordNode("Hello", new WordNode("World", 
        new WordNode("Tpoday", new WordNode("Good", 
            new WordNode("Ui", new EmptyNode())))));
    assertEquals(5, s.getNumberOfWords());
  }

  @Test
  public final void testWordNumber2() {
    assertEquals(3, this.sentence.getNumberOfWords());
  }
  
  @Test
  public final void testLongestEmpty() {
    Sentence s = new EmptyNode();
    assertTrue("".equals(s.longestWord()));
  }
  
  @Test
  public final void testLongestFull() {
    Sentence s = new WordNode("Hello", new WordNode("Friends", 
        new PunctuationNode("!", new WordNode("Good", 
            new PunctuationNode("?", new EmptyNode())))));
    assertTrue("Friends".equals(s.longestWord()));
  }
  
  @Test
  public final void testLongestMultiple() {
    // Hello and World has same length
    assertTrue("Hello".equals(sentence.longestWord()));
  }
  
  @Test
  public final void testMergeEmpty() {
    Sentence s = sentence.merge(new EmptyNode());
    assertTrue("Hello World! Good?".equals(s.toString()));
  }
  
  @Test
  public final void testMergePunc() {
    Sentence s = sentence.merge(new PunctuationNode("@", new EmptyNode()));
    assertTrue("Hello World! Good?@".equals(s.toString()));
  }
  
  @Test
  public final void testMergePuncMiddle() {
    Sentence s = sentence.merge(new WordNode("X",
        new PunctuationNode("@", new WordNode("W", new EmptyNode()))));
    assertTrue("Hello World! Good? X@ W".equals(s.toString()));
  }
  
  @Test
  public final void testEmptyDup() {
    Sentence s = new EmptyNode();
    Sentence s2 = s.duplicate();
    assertTrue("".equals(s2.toString()));
  }
  
  @Test
  public final void testWordsDup() {
    Sentence s = new WordNode("Hello", new WordNode("World", 
        new WordNode("Today", new WordNode("Good", 
            new WordNode("Ui", new EmptyNode())))));
    Sentence s2 = s.duplicate();
    assertTrue("Hello World Today Good Ui".equals(s2.toString()));
  }
  
  @Test
  public final void testPuncDup() {
    Sentence s2 = sentence.duplicate();
    assertTrue("Hello World! Good?".equals(s2.toString()));
  }
  
  @Test
  public final void testStrRepEmpty() {
    Sentence s2 = new EmptyNode();
    assertTrue("".equals(s2.toString()));
  }
  
  @Test
  public final void testStrWords() {
    Sentence s = new WordNode("Hello", new WordNode("World", 
        new WordNode("Today", new WordNode("Good", 
            new WordNode("Ui", new EmptyNode())))));
    assertTrue("Hello World Today Good Ui".equals(s.toString()));
  }
  
  @Test
  public final void testStrPuncsEnd() {
    Sentence s = new WordNode("Hello", new WordNode("World", 
        new WordNode("Today", new WordNode("Good", 
            new PunctuationNode("?", new EmptyNode())))));
    assertTrue("Hello World Today Good?".equals(s.toString()));
  }
  
  @Test
  public final void testStrPuncsFull() {
    Sentence s = new WordNode("Hello", new WordNode("World", 
        new PunctuationNode("!", new WordNode("Good", 
            new PunctuationNode("?", new EmptyNode())))));
    assertTrue("Hello World! Good?".equals(s.toString()));
  }
}
