package polynomial;

import java.util.Scanner;

/**
 * Normal Node for polynomials.
 *
 */
public class NormalPolynomialNode implements PolynomialNode {

  private int power;
  private int coeff;
  private PolynomialNode rest;

  public NormalPolynomialNode(int p, int e, PolynomialNode r) {
    setParams(p, e);
    this.rest = r;
  }
  
  public NormalPolynomialNode(Scanner in) {
    String curr = in.next();
    String [] currs = curr.split("x");
    if (currs.length < 2) {
      this.power = 0;
      this.coeff = Integer.parseInt(curr);
    } else {
      this.coeff = Integer.parseInt(currs[0].trim());
      this.power = Integer.parseInt(currs[1].substring(1));
    }
    if (in.hasNext()) {
      this.rest = new NormalPolynomialNode(in);
    } else {
      this.rest = new EmptyPolynomialNode();
    }
  }
  
  private void setParams(int newPower, int newCoeff) {
    if (newPower < 0 || (newPower > 0 && newCoeff == 0)) {
      throw new IllegalArgumentException("invalid parameters!");
    }
    this.power = newPower;
    this.coeff = newCoeff;
  }

  @Override
  public double getValue(double x) {
    double curr = this.coeff * Math.pow(x, this.power);
    return curr + this.rest.getValue(x);
  }

  @Override
  public PolynomialNode addTerm(int p, int e) {
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
    boolean curr = (this.power == node.getPower() && this.coeff == node.getCoeff());
    return curr && this.rest.isSame(node.getRest());
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
