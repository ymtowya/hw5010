package assignments;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents the scheduling strategy based on the alphabetical order of
 * the description.
 *
 *
 */
public class AlphabeticalSchedulingStrategy implements SchedulingStrategy {

  private class AlphabeticalComparator implements Comparator<Assignment> {

    @Override
    public int compare(Assignment o1, Assignment o2) {
      if (o1 == null || o2 == null) {
        throw new IllegalArgumentException("Cannot compare null object");
      }
      return o1.getDescription().compareTo(o2.getDescription());
    }
    
  }
  
  @Override
  public String schedule(List<Assignment> assigns) {
    if (assigns == null) {
      throw new IllegalArgumentException();
    }
    Collections.sort(assigns, new AlphabeticalComparator());
    return new String("alphabetical");
  }

}
