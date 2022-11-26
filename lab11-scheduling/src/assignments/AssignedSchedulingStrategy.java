package assignments;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents the scheduling strategy based on the assigned time order of
 * the task.
 *
 *
 */
public class AssignedSchedulingStrategy implements SchedulingStrategy {
  
  private class AssignedComparator implements Comparator<Assignment> {

    @Override
    public int compare(Assignment o1, Assignment o2) {
      if (o1 == null || o2 == null) {
        throw new IllegalArgumentException("Cannot compare null object");
      }
      if (o1.getNumber() == o2.getNumber()) {
        return o1.compareTo(o2);
      }
      return o1.getNumber() - o2.getNumber();
    }
    
  }

  @Override
  public String schedule(List<Assignment> assigns) {
    if (assigns == null) {
      throw new IllegalArgumentException();
    }
    Collections.sort(assigns, new AssignedComparator());
    return new String("assigned");
  }

}
