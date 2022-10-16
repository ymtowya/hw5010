package questions;

/**
 * Likert class extends from AbstractQuestion, represents category of
 * Question asking users' rating degree as response from 1 to 5.
 *
 */
public class Likert extends AbstractQuestion {
  
  public Likert(String question) {
    super(question, "", new String[0]);
  }
  
  /**
   * For Likert, as long as the input falls under the range, it's valid.
   *
   */
  @Override
  protected boolean isValidInput(String string) {
    try {
      Integer inputInteger = Integer.parseInt(string);
      if (inputInteger < 1 || inputInteger > 5) {
        return false;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
  
  @Override
  protected int compareToLikert(Likert other) {
    return this.questionString.compareTo(other.questionString);
  }

  @Override
  protected int compareToMulChoice(MultipleChoice multipleChoice) {
    return 1;
  }

  @Override
  protected int compareToMulSelect(MultipleSelect multipleSelect) {
    return 1;
  }

  @Override
  protected int compareToTrueFalse(TrueFalse trueFalse) {
    return 1;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      return -1 * ((AbstractQuestion) o).compareToLikert(this);
    }
    return -1;
  }
  
  @Override
  public String answer(String answer) {
    return isValidInput(answer) ? Question.CORRECT : Question.INCORRECT;
  }

}
