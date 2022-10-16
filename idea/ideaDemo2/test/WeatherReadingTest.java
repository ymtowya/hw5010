import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
    StevensonReading stevensonReading2 = new StevensonReading(62.125116, 61.101918, 9.630701, 32);
    assertEquals(stevensonReading2.getRelativeHumidity(), 99);
  }

  /**
   * Test method for {@link weather.WeatherReading#getHeatIndex()}.
   */
  @Test
  public final void testGetHeatIndex() {
    StevensonReading stevensonReading3 = new StevensonReading(40.157599, 23.301219, 21.642746, 58);
    assertEquals(stevensonReading3.getHeatIndex(), 65);
  }

  /**
   * Test method for {@link weather.WeatherReading#getWindChill()}.
   */
  @Test
  public final void testGetWindChill() {
    StevensonReading stevensonReading4 = new StevensonReading(73.248794, 72.403984, 9.097296, 31);
    assertEquals(stevensonReading4.getWindChill(), 86);
  }
  
  /**
   * Test method for {@link weather.StevensonReading#hashCode()}.
   */
  @Test
  public final void testHashCode() {
    StevensonReading stevensonReading5 = new StevensonReading(p1, p2, p3, p4);
    assertEquals(this.myStevensonReading.hashCode(), stevensonReading5.hashCode());
  }
  
  /**
   * Test method for {@link weather.StevensonReading#equals()}.
   */
  @Test
  public final void testEquals() {
    final StevensonReading stevensonReading5 = new StevensonReading(p1, p2, p3, p4);
    final StevensonReading stevensonReading6 = new StevensonReading(p1 + 1.0, p2, p3, p4);
    final StevensonReading stevensonReading7 = new StevensonReading(p1, p2 + 1.0, p3, p4);
    final StevensonReading stevensonReading8 = new StevensonReading(p1, p2, p3 + 1.0, p4);
    final StevensonReading stevensonReading9 = new StevensonReading(p1, p2, p3, p4 + 1);
    assertTrue(this.myStevensonReading.equals(this.myStevensonReading));
    assertTrue(this.myStevensonReading.equals(stevensonReading5));
    assertFalse(this.myStevensonReading.equals(stevensonReading6));
    assertFalse(this.myStevensonReading.equals(stevensonReading7));
    assertFalse(this.myStevensonReading.equals(stevensonReading8));
    assertFalse(this.myStevensonReading.equals(stevensonReading9));
    assertFalse(this.myStevensonReading.equals(null));
  }
  
  /**
   * Test method for {@link weather.StevensonReading#toString()}.
   */
  @Test
  public final void testToString() {
    assertEquals(this.myStevensonReading.toString(), "Reading: T = 40, D = 23, v = 22, rain = 58");
  }

}
