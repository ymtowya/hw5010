package questions;

public class TrueFalse extends AbstractQuestion {
  
  public TrueFalse(String question, String answer, String ...options) {
    super(question, answer, options);
  }
  
  @Override
  protected int compareToLikert(Likert likert) {
    return -1;
  }

  @Override
  protected int compareToMulChoice(MultipleChoice multipleChoice) {
    return -1;
  }

  @Override
  protected int compareToMulSelect(MultipleSelect multipleSelect) {
    return -1;
  }

  @Override
  protected int compareToTrueFalse(TrueFalse trueFalse) {
    return this.getText().compareTo(trueFalse.getText());
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      return -1 * ((AbstractQuestion) o).compareToTrueFalse(this);
    }
    return -1;
  }
  
  @Override
  public String answer(String answer) {
    return super.answer(answer);
  }

  @Override
  protected boolean isValidInput(String string) {
    if ("True".equals(string) || "False".equals(string)) {
      return true;
    }
    return false;
  }

}
