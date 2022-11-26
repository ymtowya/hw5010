package assignments;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents the scheduling strategy based on the difficulty order of
 * the task.
 *
 *
 */
public class DifficultySchedulingStrategy implements SchedulingStrategy {

  private class DifficultyComparator implements Comparator<Assignment> {

    @Override
    public int compare(Assignment o1, Assignment o2) {
      if (o1 == null || o2 == null) {
        throw new IllegalArgumentException("Cannot compare null object");
      }
      if (o1.getDifficulty() == o2.getDifficulty()) {
        return o1.compareTo(o2);
      }
      return o2.getDifficulty() - o1.getDifficulty();
    }
    
  }
  
  @Override
  public String schedule(List<Assignment> assigns) {
    if (assigns == null) {
      throw new IllegalArgumentException();
    }
    Collections.sort(assigns, new DifficultyComparator());
    return new String("difficulty");
  }

}
