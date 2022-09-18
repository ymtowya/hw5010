import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import weather.StevensonReading;

/**
 * 
 * Test the StevensonReading class.
 *
 */
public class StevensonReadingTest {

  private StevensonReading myStevensonReading;

  /**
   * Set up the field.
   * @throws IllegalArgumentException for invalid inputs
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    this.myStevensonReading = new StevensonReading(40.157599, 23.301219, 21.642746, 58);
  }

  @Test
  public void test() {
    assertEquals(this.myStevensonReading.getDewPoint(), 23);
  }

}
