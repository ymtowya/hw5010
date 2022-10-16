package questions;

/**
 * MultipleSelect class extends from AbstractQuestion, represents category of
 * Question asking users' multiple choice as response to the given options.
 *
 */
public class MultipleSelect extends AbstractQuestion {

  public MultipleSelect(String question, String answer, String ...options) {
    super(question, answer, options);
  }
  
  @Override
  protected int compareToLikert(Likert likert) {
    return -1;
  }

  @Override
  protected int compareToMulChoice(MultipleChoice multipleChoice) {
    return 1;
  }

  @Override
  protected int compareToMulSelect(MultipleSelect multipleSelect) {
    return this.getText().compareTo(multipleSelect.getText());
  }

  @Override
  protected int compareToTrueFalse(TrueFalse trueFalse) {
    return 1;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      return -1 * ((AbstractQuestion) o).compareToMulSelect(this);
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
      String[] numbers = string.split(" ");
      for (String number : numbers) {
        Integer inputInteger = Integer.parseInt(number);
        if (inputInteger < 1 || inputInteger > this.optionStrings.length) {
          return false;
        }
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

}
