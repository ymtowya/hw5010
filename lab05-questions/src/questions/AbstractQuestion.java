package questions;

/**
 * This abstract class is a general representation of the questions, with common code gathered.
 *
 *
 */
public abstract class AbstractQuestion implements Question {

  protected String questionString;
  protected String answerString;
  protected String[] optionStrings;

  protected AbstractQuestion(String question, String answer, String ...options) {
    this.questionString = question;
    this.answerString = answer;
    optionStrings = new String[options.length];
    for (int i = 0; i < options.length; ++i) {
      optionStrings[i] = options[i];
    }
  }
  
  /**
   * Compare this to the argument 'Likert'.
   *
   * @param likert the Likert to be compared
   * @return compare result following the CompareTo method pattern
   */
  protected int compareToLikert(Likert likert) {
    return -1;
  }
  
  /**
   * Compare this to the argument 'MultipleChoice'.
   *
   * @param multipleChoice the question to be compared
   * @return compare result following the CompareTo method pattern
   */
  protected int compareToMulChoice(MultipleChoice multipleChoice) {
    return -1;
  }
  
  /**
   * Compare this to the argument 'MulSelect'.
   *
   * @param multipleSelect the question to be compared
   * @return compare result following the CompareTo method pattern
   */
  protected int compareToMulSelect(MultipleSelect multipleSelect) {
    return -1;
  }
  
  /**
   * Compare this to the argument 'TrueFalse'.
   *
   * @param trueFalse the question to be compared
   * @return compare result following the CompareTo method pattern
   */
  protected int compareToTrueFalse(TrueFalse trueFalse) {
    return -1;
  }
  
  /**
   * Abstract function (to be implemented by subclass) to tell if the input is valid.
   * @param string input string
   * @return boolean for valid or not
   */
  protected abstract boolean isValidInput(String string);
  
  @Override
  public abstract int compareTo(Question o);

  @Override
  public String answer(String answer) {
    if (isValidInput(answer) && this.answerString.equals(answer)) {
      return Question.CORRECT;
    }
    return Question.INCORRECT;
  }

  @Override
  public String getText() {
    return this.questionString;
  }

}
