package assignments;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents the scheduling strategy based on the deadline time order of
 * the task.
 *
 *
 */
public class DeadlineSchedulingStrategy implements SchedulingStrategy {

  private class DeadlineComparator implements Comparator<Assignment> {

    @Override
    public int compare(Assignment o1, Assignment o2) {
      if (o1 == null || o2 == null) {
        throw new IllegalArgumentException("Cannot compare null object");
      }
      if (o1.getEndDate().equals(o2.getEndDate())) {
        return o1.compareTo(o2);
      }
      return o1.getEndDate().compareTo(o2.getEndDate());
    }
    
  }
  
  @Override
  public String schedule(List<Assignment> assigns) {
    if (assigns == null) {
      throw new IllegalArgumentException();
    }
    Collections.sort(assigns, new DeadlineComparator());
    return new String("deadline");
  }

}
