package questions;

public class MultipleChoice extends AbstractQuestion {

  public MultipleChoice(String question, String answer, String ...options) {
    super(question, answer, options);
  }
  
  @Override
  protected int compareToLikert(Likert likert) {
    return -1;
  }

  @Override
  protected int compareToMulChoice(MultipleChoice multipleChoice) {
    return this.getText().compareTo(multipleChoice.getText());
  }

  @Override
  protected int compareToMulSelect(MultipleSelect multipleSelect) {
    return -1;
  }

  @Override
  protected int compareToTrueFalse(TrueFalse trueFalse) {
    return 1;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      return -1 * ((AbstractQuestion) o).compareToMulChoice(this);
    }
    return -1;
  }

  @Override
  public String answer(String answer) {
    return super.answer(answer);
  }

  @Override
  protected boolean isValidInput(String string) {
    try {
      Integer inputInteger = Integer.parseInt(string);
      if (inputInteger > 0) {
        return true;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return false;
  }

}
