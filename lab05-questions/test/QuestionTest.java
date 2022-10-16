import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * This class tests the Question Class and its implementations.
 *
 */
public class QuestionTest {

  private Question question1;
  private Question question2;
  private Question question3;
  private Question question4;
  private List<Question> queList;
  
  /**
   * Set up.
   *
   *
   */
  @Before
  public void setUp() {
    this.question1 = new TrueFalse("Are you tired?", "True", "True", "False");
    this.question2 = new MultipleChoice("Richmond in?", "3",
        "Toronto", "New York", "Vancouver", "Florida");
    this.question3 = new MultipleSelect("Great year alike?", "2 3 5",
        "2001", "2002", "1987", "1999", "2013", "2017");
    this.question4 = new Likert("2022 is great?");
    queList = new ArrayList<Question>();
  }

  /**
   * This function tests the TrueFalse class responding to correct / incorrect answer.
   *
   */
  @Test
  public void testTrueFalse() {
    assertTrue(this.question1.answer("True").equals(Question.CORRECT));
    assertTrue(this.question1.answer("False").equals(Question.INCORRECT));
    assertTrue(this.question1.answer("T").equals(Question.INCORRECT));
    assertTrue(this.question1.answer("1").equals(Question.INCORRECT));
  }
  
  /**
   * This function tests the MultipleChoice class responding to correct / incorrect answer.
   *
   */
  @Test
  public void testMulChoice() {
    assertTrue(this.question2.answer("3").equals(Question.CORRECT));
    assertTrue(this.question2.answer("4").equals(Question.INCORRECT));
    assertTrue(this.question2.answer("-1").equals(Question.INCORRECT));
    assertTrue(this.question2.answer("6").equals(Question.INCORRECT));
  }
  
  /**
   * This function tests the MultipleSelect class responding to correct / incorrect answer.
   *
   */
  @Test
  public void testMulSelect() {
    assertTrue(this.question3.answer("2 3 5").equals(Question.CORRECT));
    assertTrue(this.question3.answer("2 3").equals(Question.INCORRECT));
    assertTrue(this.question3.answer("1 2 3 5").equals(Question.INCORRECT));
    assertTrue(this.question3.answer("Several").equals(Question.INCORRECT));
  }
  
  /**
   * This function tests the Likert class responding to correct / incorrect answer.
   *
   */
  @Test
  public void testLikert() {
    assertTrue(this.question4.answer("3").equals(Question.CORRECT));
    assertTrue(this.question4.answer("1").equals(Question.CORRECT));
    assertTrue(this.question4.answer("1 2").equals(Question.INCORRECT));
    assertTrue(this.question4.answer("6").equals(Question.INCORRECT));
  }
  
  /**
   * This function adds questions to the list and shuffle it.
   *
   */
  private void addToList() {
    queList.add(question3);
    queList.add(question4);
    queList.add(question1);
    queList.add(question2);
    Collections.shuffle(this.queList);
  }
  
  /**
   * This function tests the TrueFalse class's order in a list with other Questions.
   *
   */
  @Test
  public void testTrueFalseOrder() {
    addToList();
    Collections.sort(this.queList);
    assertEquals(queList.indexOf(question1), 0);
  }
  
  /**
   * This function tests the MultipleChoice class's order in a list with other Questions.
   *
   */
  @Test
  public void testMulChoiceOrder() {
    addToList();
    Collections.sort(this.queList);
    assertTrue(queList.indexOf(question2) > queList.indexOf(question1));
    assertTrue(queList.indexOf(question2) < queList.indexOf(question3));
    assertTrue(queList.indexOf(question2) < queList.indexOf(question4));
  }

  /**
   * This function tests the MultipleSelect class's order in a list with other Questions.
   *
   */
  @Test
  public void testMulSelectOrder() {
    addToList();
    Collections.sort(this.queList);
    assertTrue(queList.indexOf(question3) > queList.indexOf(question1));
    assertTrue(queList.indexOf(question3) > queList.indexOf(question2));
    assertTrue(queList.indexOf(question3) < queList.indexOf(question4));
  }
  
  /**
   * This function tests the Likert class's order in a list with other Questions.
   *
   */
  @Test
  public void testLikertOrder() {
    addToList();
    Collections.sort(this.queList);
    assertTrue(queList.indexOf(question4) > queList.indexOf(question1));
    assertTrue(queList.indexOf(question4) > queList.indexOf(question2));
    assertTrue(queList.indexOf(question4) > queList.indexOf(question3));
  }
  
  /**
   * This function tests order inside a list of all kinds of Questions.
   *
   */
  @Test
  public void testQueOrder() {
    addToList();
    Collections.sort(this.queList);
    assertEquals(queList.indexOf(question1), 0);
    assertEquals(queList.indexOf(question2), 1);
    assertEquals(queList.indexOf(question3), 2);
    assertEquals(queList.indexOf(question4), 3);
  }
  
}
