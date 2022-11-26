import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import assignments.AlphabeticalSchedulingStrategy;
import assignments.AssignedSchedulingStrategy;
import assignments.Assignment;
import assignments.AssignmentList;
import assignments.DeadlineSchedulingStrategy;
import assignments.DifficultySchedulingStrategy;
import assignments.SchedulingStrategy;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


/** Class that tests the tasks. */
public class AssignmentTest {
  
  private Assignment a1;
  private Assignment a2;
  private Assignment a3;
  private Assignment a4;
  private Assignment a5;
  private Assignment a6;
  private AssignmentList tasks;
  
  /**
   * Set up.
   *
   */
  @Before
  public void setUp() throws IOException {
    a1 = new Assignment("ask for help");
    a2 = new Assignment("clean house");
    a3 = new Assignment("find cat");
    a4 = new Assignment("find cotton");
    a5 = new Assignment("play guitar");
    a6 = new Assignment("yield next");
    
    a1.setStart(11, 5, 2020);
    a1.setDeadline(12, 7, 2020);
    a2.setStart(7, 12, 2020);
    a2.setDeadline(8, 1, 2021);
    a3.setStart(8, 14, 2022);
    a3.setDeadline(9, 5, 2022);
    a4.setStart(8, 14, 2022);
    a4.setDeadline(9, 5, 2022);
    a5.setStart(6, 3, 2021);
    a5.setDeadline(7, 8, 2022);
    a6.setStart(12, 7, 2019);
    a6.setDeadline(12, 7, 2019);
    
    tasks = new AssignmentList();
    tasks.add(a1);
    tasks.add(a2);
    tasks.add(a3);
    tasks.add(a4);
    tasks.add(a5);
    
  }


  /** Testing constructor and toString(). */
  @Test
  public void testConstructor() {
    LocalDate now = LocalDate.now();
    System.out.println(now);
    Assignment t1 = new Assignment("task 1");
    assertEquals("task 1, starting " + now + ", ending " + now, t1.toString());
    Assignment t2 = new Assignment("task 2");
    t2.setDeadline(3, 4, 2025);
    assertEquals("task 2, starting " + now + ", ending 2025-03-04", t2.toString());
  }
  
  @Test
  public void testAssign() {
    tasks.scheduleAssignments(new AssignedSchedulingStrategy());
    String targetString = "Ordered by assigned\n"
        + "1 -- ask for help, starting 2020-11-05, ending 2020-12-07\n"
        + "2 -- clean house, starting 2020-07-12, ending 2021-08-01\n"
        + "3 -- find cat, starting 2022-08-14, ending 2022-09-05\n"
        + "4 -- find cotton, starting 2022-08-14, ending 2022-09-05\n"
        + "5 -- play guitar, starting 2021-06-03, ending 2022-07-08\n";
    assertTrue(targetString.equals(tasks.toString()));
  }
  
  @Test
  public void testAlpha() {
    tasks.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    String targetString = "Ordered by alphabetical\n"
        + "1 -- ask for help, starting 2020-11-05, ending 2020-12-07\n"
        + "2 -- clean house, starting 2020-07-12, ending 2021-08-01\n"
        + "3 -- find cat, starting 2022-08-14, ending 2022-09-05\n"
        + "4 -- find cotton, starting 2022-08-14, ending 2022-09-05\n"
        + "5 -- play guitar, starting 2021-06-03, ending 2022-07-08\n";
    assertTrue(targetString.equals(tasks.toString()));
  }
  
  @Test
  public void testDdl() {
    tasks.scheduleAssignments(new DeadlineSchedulingStrategy());

    String targetString = "Ordered by deadline\n"
        + "1 -- ask for help, starting 2020-11-05, ending 2020-12-07\n"
        + "2 -- clean house, starting 2020-07-12, ending 2021-08-01\n"
        + "3 -- play guitar, starting 2021-06-03, ending 2022-07-08\n"
        + "4 -- find cat, starting 2022-08-14, ending 2022-09-05\n"
        + "5 -- find cotton, starting 2022-08-14, ending 2022-09-05\n";
    assertTrue(targetString.equals(tasks.toString()));
  }
  
  @Test
  public void testDifficulty() {
    tasks.scheduleAssignments(new DifficultySchedulingStrategy());

    String targetString = "Ordered by difficulty\n"
        + "1 -- find cat, starting 2022-08-14, ending 2022-09-05\n"
        + "2 -- find cotton, starting 2022-08-14, ending 2022-09-05\n"
        + "3 -- clean house, starting 2020-07-12, ending 2021-08-01\n"
        + "4 -- play guitar, starting 2021-06-03, ending 2022-07-08\n"
        + "5 -- ask for help, starting 2020-11-05, ending 2020-12-07\n";
    assertTrue(targetString.equals(tasks.toString()));
  }
  
  @Test
  public void testAddAssign() {
    tasks.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    tasks.add(a6);
    tasks.scheduleAssignments(new AssignedSchedulingStrategy());
    final String targetString = "Ordered by assigned\n"
        + "1 -- ask for help, starting 2020-11-05, ending 2020-12-07\n"
        + "2 -- clean house, starting 2020-07-12, ending 2021-08-01\n"
        + "3 -- find cat, starting 2022-08-14, ending 2022-09-05\n"
        + "4 -- find cotton, starting 2022-08-14, ending 2022-09-05\n"
        + "5 -- play guitar, starting 2021-06-03, ending 2022-07-08\n"
        + "6 -- yield next, starting 2019-12-07, ending 2019-12-07\n";
    assertTrue(targetString.equals(tasks.toString()));
  }
  
  @Test
  public void testAddAlpha() {
    tasks.scheduleAssignments(new DeadlineSchedulingStrategy());
    tasks.add(a6);
    tasks.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    final String targetString = "Ordered by alphabetical\n"
        + "1 -- ask for help, starting 2020-11-05, ending 2020-12-07\n"
        + "2 -- clean house, starting 2020-07-12, ending 2021-08-01\n"
        + "3 -- find cat, starting 2022-08-14, ending 2022-09-05\n"
        + "4 -- find cotton, starting 2022-08-14, ending 2022-09-05\n"
        + "5 -- play guitar, starting 2021-06-03, ending 2022-07-08\n"
        + "6 -- yield next, starting 2019-12-07, ending 2019-12-07\n";
    assertTrue(targetString.equals(tasks.toString()));
  }
  
  @Test
  public void testAddDdl() {
    tasks.scheduleAssignments(new DifficultySchedulingStrategy());
    tasks.add(a6);
    tasks.scheduleAssignments(new DeadlineSchedulingStrategy());
    final String targetString = "Ordered by deadline\n"
        + "1 -- yield next, starting 2019-12-07, ending 2019-12-07\n"
        + "2 -- ask for help, starting 2020-11-05, ending 2020-12-07\n"
        + "3 -- clean house, starting 2020-07-12, ending 2021-08-01\n"
        + "4 -- play guitar, starting 2021-06-03, ending 2022-07-08\n"
        + "5 -- find cat, starting 2022-08-14, ending 2022-09-05\n"
        + "6 -- find cotton, starting 2022-08-14, ending 2022-09-05\n";
    assertTrue(targetString.equals(tasks.toString()));
  }
  
  @Test
  public void testAddDifficulty() {
    tasks.scheduleAssignments(new AssignedSchedulingStrategy());
    tasks.add(a6);
    tasks.scheduleAssignments(new DifficultySchedulingStrategy());
    final String targetString = "Ordered by difficulty\n"
        + "1 -- find cat, starting 2022-08-14, ending 2022-09-05\n"
        + "2 -- find cotton, starting 2022-08-14, ending 2022-09-05\n"
        + "3 -- clean house, starting 2020-07-12, ending 2021-08-01\n"
        + "4 -- play guitar, starting 2021-06-03, ending 2022-07-08\n"
        + "5 -- ask for help, starting 2020-11-05, ending 2020-12-07\n"
        + "6 -- yield next, starting 2019-12-07, ending 2019-12-07\n";
    assertTrue(targetString.equals(tasks.toString()));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIllegal() {
    List<Assignment> newTasks = null;
    SchedulingStrategy ss2 = new AssignedSchedulingStrategy();
    ss2.schedule(newTasks);
  }

  
}
