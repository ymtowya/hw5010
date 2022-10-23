package sentence;

/**
 * WordNode represents a word in the sentence.
 *
 */
public class WordNode implements Sentence {

  private String word;
  private Sentence rest;
  
  public WordNode(String theWord, Sentence restSentence) {
    this.word = new String(theWord);
    this.rest = restSentence;
  }
  
  @Override
  public int getNumberOfWords() {
    return this.countHelp(0);
  }

  @Override
  public String longestWord() {
    String nextLongest = this.rest.longestWord();
    if (nextLongest != null && nextLongest.length() > this.word.length()) {
      return nextLongest;
    }
    return new String(this.word);
  }

  @Override
  public Sentence merge(Sentence other) {
    return new WordNode(this.word, this.rest.merge(other));
  }

  @Override
  public Sentence duplicate() {
    return new WordNode(this.word, this.rest.duplicate());
  }

  @Override
  public int countHelp(int acc) {
    return this.rest.countHelp(acc + 1);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.word);
    if (rest instanceof WordNode) {
      sb.append(" ");
    }
    sb.append(this.rest.toString());
    return sb.toString();
  }

}
