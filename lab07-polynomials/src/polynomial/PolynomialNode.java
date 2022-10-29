package polynomial;

/**
 * Polynomial Node.
 *
 */
public interface PolynomialNode {
  
  /**
   * Get the power.
   *
   * @return power
   */
  int getPower();
  
  /**
   * Get the coefficient.
   *
   * @return coefficient.
   */
  int getCoeff();
  
  /**
   * Get the evaluation with base x.
   *
   * @param x base
   * @return eval
   */
  double getValue(double x);
  
  /**
   * Add another term to it.
   *
   * @param p power
   * @param e coefficient
   * @return new term
   */
  PolynomialNode addTerm(int p, int e);
  
  /**
   * Get rest of polynomials.
   *
   * @return rest nodes
   */
  PolynomialNode getRest();
  
  /**
   * Determine if are of same polynomials.
   *
   * @param node to compare node
   * @return compare result
   */
  boolean isSame(PolynomialNode node);
  
  /**
   * Get coefficient of certain power
   *
   * @param power power
   * @return coefficient
   */
  int getCoefficient(int power);
}
