package questions;


public abstract class AbstractQuestion implements Question {

  protected String questionString;
  protected String answerString;
  protected String[] optionStrings;

  protected AbstractQuestion (String question, String answer, String ...options) {
    this.questionString = question;
    this.answerString = answer;
    optionStrings = new String[options.length];
    for (int i = 0; i < options.length; ++i) {
      optionStrings[i] = options[i];
    }
  }
  
  protected int compareToLikert(Likert likert) {
    return -1;
  }
  
  protected int compareToMulChoice(MultipleChoice multipleChoice) {
    return -1;
  }
  
  protected int compareToMulSelect(MultipleSelect multipleSelect) {
    return -1;
  }
  
  protected int compareToTrueFalse(TrueFalse trueFalse) {
    return -1;
  }
  
  abstract protected boolean isValidInput(String string);
  
  @Override
  abstract public int compareTo(Question o);

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
