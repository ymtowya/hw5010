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
  public final void test() {
//    String teString = "-34";
//    String [] res = teString.split("x");
//    System.out.println(res.length);
////    System.out.println(res[1].substring(1));
    System.out.println(poly.toString());
    assertEquals(5, poly.getDegree());
  }

}
