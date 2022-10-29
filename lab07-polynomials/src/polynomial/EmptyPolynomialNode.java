package polynomial;

/**
 * Empty node in polynomials, positioned at the end of the polynomial.
 *
 */
public class EmptyPolynomialNode implements PolynomialNode {

  @Override
  public double getValue(double x) {
    return 0;
  }

  @Override
  public PolynomialNode addTerm(int p, int e) {
    if (e == 0) {
      return this;
    }
    return new NormalPolynomialNode(p, e, this);
  }

  @Override
  public int getPower() {
    return 0;
  }

  @Override
  public int getCoeff() {
    return 0;
  }

  @Override
  public PolynomialNode getRest() {
    return null;
  }

  @Override
  public boolean isSame(PolynomialNode node) {
    if (node instanceof EmptyPolynomialNode) {
      return true;
    }
    return false;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }
  
  @Override
  public String toString() {
    return "";
  }

}
