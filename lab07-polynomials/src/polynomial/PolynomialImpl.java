package polynomial;

import java.util.Scanner;

/**
 * Implementation of Polynomial.
 *
 */
public class PolynomialImpl implements Polynomial {

  private PolynomialNode head;
  
  /**
   * Init the Polynomial with empty input.
   *
   */
  public PolynomialImpl() {
    head = new EmptyPolynomialNode();
  }
  
  /**
   * Init the Polynomial with String of content.
   *
   * @param s poly content
   */
  public PolynomialImpl(String s) {
    Scanner input = new Scanner(s);
    this.head = new EmptyPolynomialNode();
    int p = 0;
    int e = 0;
    while (input.hasNext()) {
      String curr = input.next();
      String [] currs = curr.split("x");
      if (currs.length < 2) {
        p = 0;
        e = Integer.parseInt(curr);
      } else {
        e = Integer.parseInt(currs[0].trim());
        p = Integer.parseInt(currs[1].substring(1));
      }
      this.head = this.head.addTerm(p, e);
    }
    input.close();
  }
  
  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("type unmatched!");
    }
    Polynomial res = new PolynomialImpl();
    PolynomialImpl otherImpl = (PolynomialImpl) other;
    PolynomialNode newNode = otherImpl.head;
    while (newNode != null) {
      res.addTerm(newNode.getCoeff(), newNode.getPower());
      newNode = newNode.getRest();
    }
    newNode = this.head;
    while (newNode != null) {
      res.addTerm(newNode.getCoeff(), newNode.getPower());
      newNode = newNode.getRest();
    }
    return res;
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("invalid arguments!");
    }
    this.head = this.head.addTerm(power, coefficient);
  }

  @Override
  public boolean isSame(Polynomial poly) {
    if (poly == null) {
      return false;
    }
    return poly.toString().equals(this.toString());
  }

  @Override
  public double evaluate(double x) {
    return this.head.getValue(x);
  }

  @Override
  public int getCoefficient(int power) {
    return this.head.getCoefficient(power);
  }

  @Override
  public int getDegree() {
    return this.head.getPower();
  }
  
  @Override
  public String toString() {
    if (head == null || head instanceof EmptyPolynomialNode) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(String.valueOf(this.head.getCoeff()));
    if (this.head.getPower() > 0) {
      sb.append("x^");
      sb.append(String.valueOf(this.head.getPower()));
    }
    sb.append(this.head.getRest().toString());
    return sb.toString();
  }

}
