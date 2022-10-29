package polynomial;

/**
 * Polynomial Node.
 *
 */
public interface PolynomialNode {
  int getPower();
  int getCoeff();
  double getValue(double x);
  PolynomialNode addTerm(int p, int e);
  PolynomialNode getRest();
  boolean isSame(PolynomialNode node);
  int getCoefficient(int power);
}
