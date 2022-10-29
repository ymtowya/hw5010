package polynomial;

import java.util.Scanner;

/**
 * Normal Node for polynomials. Has Power and Coefficient.
 *
 */
public class NormalPolynomialNode implements PolynomialNode {

  private int power;
  private int coeff;
  private PolynomialNode rest;

  /**
   * Init one term in the polynomial with params.
   *
   * @param p power
   * @param e coefficient
   * @param r rest
   */
  public NormalPolynomialNode(int p, int e, PolynomialNode r) {
    setParams(p, e);
    this.rest = r;
  }
  
  private void setParams(int newPower, int newCoeff) {
    if (newPower < 0) {
      throw new IllegalArgumentException("invalid parameters!");
    }
    this.power = newPower;
    this.coeff = newCoeff;
  }

  @Override
  public double getValue(double x) {
    double curr = this.coeff * Math.pow(x, this.power);
    if (this.power == 0) {
      curr = this.coeff;
    }
    return curr + this.rest.getValue(x);
  }

  @Override
  public PolynomialNode addTerm(int p, int e) {
    if (e == 0) {
      return this;
    }
    if (p == this.power) {
      this.coeff += e;
      if (this.coeff == 0) {
        // drop
        return this.rest;
      }
      return this;
    } else if (p > this.power) {
      PolynomialNode newNode = new NormalPolynomialNode(p, e, this);
      return newNode;
    }
    this.rest = this.rest.addTerm(p, e);
    return this;
  }

  @Override
  public int getPower() {
    return power;
  }

  @Override
  public int getCoeff() {
    return coeff;
  }

  @Override
  public PolynomialNode getRest() {
    return rest;
  }

  @Override
  public boolean isSame(PolynomialNode node) {
    return node.toString().equals(this.toString());
  }

  @Override
  public int getCoefficient(int power) {
    if (power == this.power) {
      return this.coeff;
    }
    return this.rest.getCoefficient(power);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(" ");
    if (this.coeff > 0) {
      sb.append("+");
    }
    sb.append(this.coeff);
    if (this.power > 0) {
      sb.append("x^");
      sb.append(this.power);
    }
    sb.append(this.rest.toString());
    return sb.toString();
  }

}
