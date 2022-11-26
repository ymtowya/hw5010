package assignments;

import java.util.List;

/**
 * This interface represents the strategy for sorting assignments.
 *
 */
public interface SchedulingStrategy {
  
  /**
   * This method will schedule the given list based on certain
   * standard.
   *
   * @param assigns given list of assignments
   * @return String of the strategy name
   */
  String schedule(List<Assignment> assigns);
  
}
