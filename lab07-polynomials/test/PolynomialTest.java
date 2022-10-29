import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import polynomial.Polynomial;
import polynomial.PolynomialImpl;

public class PolynomialTest {
  
  Polynomial poly;

  @Before
  public void setUp() throws Exception {
    poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
  }

  @Test
  public final void testdegree() {
    assertEquals(5, poly.getDegree());
  }
  
  @Test
  public final void testeval() {
    assertEquals(1, (int) poly.evaluate(1));
  }
  
  @Test
  public final void testadd() {
    Polynomial poly2 = new PolynomialImpl("2x^5 +3x^1 -5");
    Polynomial poly3 = poly2.add(poly);
    assertEquals(1, (int) poly3.evaluate(1));
  }

}
