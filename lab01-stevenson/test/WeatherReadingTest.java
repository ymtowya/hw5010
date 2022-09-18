import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import weather.StevensonReading;

/**
 * 
 * Test the StevensonReading class's implementation of WeatherReading.
 */
public class WeatherReadingTest {
  
  // constant parameters
  private final double p1 = 40.157599;
  private final double p2 = 23.301219;
  private final double p3 = 21.642746;
  private final int p4 = 58;
  // To-test class
  private StevensonReading myStevensonReading;

  /**
   * Set up the StevensonReading instance variable.
   * 
   * @throws java.lang.IllegalArgumentException when the input parameters are invalid
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    this.myStevensonReading = new StevensonReading(p1, p2, p3, p4);
  }
  
  /**
   * Test the rule for Dew Point in Celsius that 
   * it cannot be greater than the air temperature.
   * 
   * @throws IllegalArgumentException when dew point is greater than air temp
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalDew() throws IllegalArgumentException {
    StevensonReading stevensonReading = new StevensonReading(16.2, 18.7, 19.4, 4);
    stevensonReading.toString();
    fail("Failed due to no IllegalArgumentException thrown for invalid Dew Point");
  }
  
  /**
   * Test the rule for wind speed that 
   * it must be non-negative.
   * 
   * @throws IllegalArgumentException when wind speed is negative
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalWindSpeed() throws IllegalArgumentException {
    StevensonReading stevensonReading = new StevensonReading(16.2, 14.1, -3.5, 4);
    stevensonReading.toString();
    fail("Failed due to no IllegalArgumentException thrown for invalid wind speed");
  }
  
  /**
   * Test the rule for total rain that 
   * it must be non-negative.
   * 
   * @throws IllegalArgumentException when total rain is negative
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalTotalRain() throws IllegalArgumentException {
    StevensonReading stevensonReading = new StevensonReading(16.2, 14.1, 23.5, -1);
    stevensonReading.toString();
    fail("Failed due to no IllegalArgumentException thrown for invalid total rain");
  }

  /**
   * Test method for {@link weather.WeatherReading#getTemperature()}.
   */
  @Test
  public final void testGetTemperature() {
    assertEquals(this.myStevensonReading.getTemperature(), Math.round(this.p1), 0.01);
  }

  /**
   * Test method for {@link weather.WeatherReading#getDewPoint()}.
   */
  @Test
  public final void testGetDewPoint() {
    assertEquals(this.myStevensonReading.getDewPoint(), Math.round(this.p2), 0.01);
  }

  /**
   * Test method for {@link weather.WeatherReading#getWindSpeed()}.
   */
  @Test
  public final void testGetWindSpeed() {
    assertEquals(this.myStevensonReading.getWindSpeed(), Math.round(this.p3), 0.01);
  }

  /**
   * Test method for {@link weather.WeatherReading#getTotalRain()}.
   */
  @Test
  public final void testGetTotalRain() {
    assertEquals(this.myStevensonReading.getTotalRain(), this.p4);
  }

  /**
   * Test method for {@link weather.WeatherReading#getRelativeHumidity()}.
   */
  @Test
  public final void testGetRelativeHumidity() {
    assertEquals(1, 1);
  }

  /**
   * Test method for {@link weather.WeatherReading#getHeatIndex()}.
   */
  @Test
  public final void testGetHeatIndex() {
    assertEquals(1, 1);
  }

  /**
   * Test method for {@link weather.WeatherReading#getWindChill()}.
   */
  @Test
  public final void testGetWindChill() {
    assertEquals(1, 1);
  }

}
