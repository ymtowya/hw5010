package sentence;

/**
 * EmptyNode represents an empty node in the sentence,
 * denoting the end.
 *
 */
public class EmptyNode implements Sentence {

  @Override
  public int countHelp(int acc) {
    return acc;
  }

  @Override
  public int getNumberOfWords() {
    return 0;
  }

  @Override
  public String longestWord() {
    return new String("");
  }

  @Override
  public Sentence merge(Sentence other) {
    return other.duplicate();
  }

  @Override
  public Sentence duplicate() {
    return new EmptyNode();
  }
  
  @Override
  public String toString() {
    return new String("");
  }

}
