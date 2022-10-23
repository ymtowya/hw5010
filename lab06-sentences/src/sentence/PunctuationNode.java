package sentence;

/**
 * PunctuationNode represents a punctuation in the sentence.
 *
 */
public class PunctuationNode implements Sentence {
  
  private String punctuation;
  private Sentence rest;
  
  public PunctuationNode(String c, Sentence theRest) {
    this.punctuation = new String(c);
    this.rest = theRest;
  }

  @Override
  public int countHelp(int acc) {
    return this.rest.countHelp(acc);
  }

  @Override
  public int getNumberOfWords() {
    return this.countHelp(0);
  }

  @Override
  public String longestWord() {
    return this.rest.longestWord();
  }

  @Override
  public Sentence merge(Sentence other) {
    return new PunctuationNode(punctuation, this.rest.merge(other));
  }

  @Override
  public Sentence duplicate() {
    return new PunctuationNode(this.punctuation, this.rest.duplicate());
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.punctuation);
    if (rest instanceof WordNode) {
      sb.append(" ");
    }
    sb.append(this.rest.toString());
    return sb.toString();
  }

}
