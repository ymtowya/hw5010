import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import polynomial.Polynomial;
import polynomial.PolynomialImpl;

/**
 * Test Polynomial Class.
 *
 *
 */
public class PolynomialTest {
  
  Polynomial poly;
  Polynomial poly2;
  Polynomial poly7;

  /**
   * Init setup.
   *
   * @throws IllegalArgumentException when invalid input
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    poly2 = new PolynomialImpl("4x^3 +3x^1 -5");
    poly7 = new PolynomialImpl("17");
  }
  
  /**
   * Test constructors.
   *
   */
  @Test
  public final void testconstructor() {
    Polynomial poly1 = new PolynomialImpl();
    assertEquals("0", poly1.toString());
    poly2 = new PolynomialImpl("4x^3 +3x^1 -5");
    assertEquals("4x^3 +3x^1 -5", poly2.toString());
    Polynomial poly3 = new PolynomialImpl("2x^3 +3x^1 +2x^3 -5");
    assertEquals("4x^3 +3x^1 -5", poly3.toString());
    Polynomial poly4 = new PolynomialImpl("92");
    assertEquals("92", poly4.toString());
    Polynomial poly5 = new PolynomialImpl("");
    assertEquals("0", poly5.toString());
  }
  
  /**
   * Test constructors of invalid input.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testconstructorInvalid() {
    Polynomial poly1 = new PolynomialImpl("18x^3 -9x^-2 +3");
  }
  
  /**
   * Test toString.
   *
   */
  @Test
  public final void testtoStr() {
    Polynomial poly1 = new PolynomialImpl("18x^2 -9x^4 +3");
    assertTrue("-9x^4 +18x^2 +3".equals(poly1.toString()));
  }
  
  /**
   * Test negative addTerm.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testaddTerm1() {
    Polynomial poly1 = new PolynomialImpl("18x^2 -9x^4 +3");
    poly1.addTerm(7, -2);
  }
  
  /**
   * Test addTerm.
   *
   */
  @Test
  public final void testaddTerm2() {
    Polynomial poly1 = new PolynomialImpl("18x^2 -9x^4 +3");
    poly1.addTerm(7, 2);
    assertEquals("-9x^4 +25x^2 +3", poly1.toString());
    poly1.addTerm(-5, 3);
    assertEquals("-9x^4 -5x^3 +25x^2 +3", poly1.toString());
  }
  
  /**
   * Test isSame of different powers.
   *
   */
  @Test
  public final void testisSame1() {
    Polynomial poly1 = new PolynomialImpl("18x^2 -9x^4");
    assertFalse(poly1.isSame(poly));
  }
  
  /**
   * Test isSame of shared powers.
   *
   */
  @Test
  public final void testisSame2() {
    assertFalse(poly2.isSame(poly));
  }
  
  /**
   * Test isSame even different order.
   *
   */
  @Test
  public final void testSame3() {
    Polynomial poly3 = new PolynomialImpl("-3x^4 -5 -2x^5 +11x^1");
    assertTrue(poly3.isSame(poly));
  }
  
  /**
   * Test degree.
   *
   */
  @Test
  public final void testdegree() {
    assertEquals(5, poly.getDegree());
    assertEquals(3, poly2.getDegree());
    assertEquals(0, poly7.getDegree());
  }
  
  /**
   * Test degree.
   *
   */
  @Test
  public final void testGetCoeff() {
    assertEquals(-2, poly.getCoefficient(5));
    assertEquals(-3, poly.getCoefficient(4));
    assertEquals(0, poly.getCoefficient(2));
    assertEquals(0, poly7.getCoefficient(3));
  }
  
  /**
   * Test evaluation.
   *
   */
  @Test
  public final void testeval() {
    assertEquals(-122, (int) poly2.evaluate(-3));
    assertEquals(-95, (int) poly.evaluate(2));
  }
  
  /**
   * Test add polynomials.
   *
   */
  @Test
  public final void testadd1() {
    Polynomial poly4 = new PolynomialImpl("2x^3 +3x^2 -7");
    Polynomial poly3 = poly4.add(poly);
    assertTrue("-2x^5 -3x^4 +2x^3 +3x^2 +11x^1 -12".equals(poly3.toString()));
  }
  
  /**
   * Test add polynomials.
   *
   */
  @Test
  public final void testadd2() {
    Polynomial poly4 = new PolynomialImpl("2x^5 +3x^1 -5");
    Polynomial poly3 = poly4.add(poly);
    assertEquals(1, (int) poly3.evaluate(1));
    assertTrue("-3x^4 +14x^1 -10".equals(poly3.toString()));
  }

}
