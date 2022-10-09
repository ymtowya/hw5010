import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import transmission.AutomaticTransmission;
import transmission.Transmission;

/**
 * Test case for Transmission Class.
 *
 */
public class TransmissionTest {
  
  Transmission myTransmission;
  
  private void increaseSpeeds(Transmission transmission, int speed) {
    for (int i = 0; i < speed; ++i) {
      transmission.increaseSpeed();
    }
  }
  
  private void decreaseSpeeds(Transmission transmission, int speed) {
    for (int i = 0; i < speed; ++i) {
      transmission.decreaseSpeed();
    }
  }

  /**
   * Set up the instance.
   * 
   * @throws java.lang.Exception when input is invalid
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    myTransmission = new AutomaticTransmission(5, 10, 15, 20, 25);
  }
  
  /**
   * 
   * This suit of functions tests throwing Exception when input is invalid. 
   * 
   * @throws IllegalArgumentException because threshold is invalid.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testIllegalInit1() {
    AutomaticTransmission autoTransmission = new AutomaticTransmission(0, 10, 20, 30, 40);
    autoTransmission.toString();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public final void testIllegalInit2() {
    AutomaticTransmission autoTransmission = new AutomaticTransmission(10, 5, 20, 30, 40);
    autoTransmission.toString();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public final void testIllegalInit3() {
    AutomaticTransmission autoTransmission = new AutomaticTransmission(5, 10, 8, 30, 40);
    autoTransmission.toString();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public final void testIllegalInit4() {
    AutomaticTransmission autoTransmission = new AutomaticTransmission(5, 10, 20, 18, 40);
    autoTransmission.toString();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public final void testIllegalInit5() {
    AutomaticTransmission autoTransmission = new AutomaticTransmission(5, 10, 20, 30, 27);
    autoTransmission.toString();
  }
  
  /**
   * This tests the increaseSpeed() function and how gear changes respectively.
   */
  @Test
  public final void testIncreaseSpeed() {
    Transmission transmission = new AutomaticTransmission(10, 20, 30, 40, 50);
    assertEquals(transmission.getSpeed(), 0);
    assertEquals(transmission.getGear(), 0);
    int tmpSpeed = 0;
    final int speedIncrement = 9;
    for (int i = 2; i <= 6; i++) {
      tmpSpeed += speedIncrement;
      this.increaseSpeeds(transmission, speedIncrement);
      assertEquals(transmission.getSpeed(), tmpSpeed);
      assertEquals(transmission.getGear(), i - 1);
      tmpSpeed += 1;
      transmission.increaseSpeed(); // next gear
      assertEquals(transmission.getSpeed(), tmpSpeed);
      assertEquals(transmission.getGear(), i);
    }
  }
  
  /**
   * This tests the decreaseSpeed() function and how gear changes respectively.
   */
  @Test
  public final void testDecreaseSpeed() {
    Transmission transmission = new AutomaticTransmission(10, 20, 30, 40, 50);
    this.increaseSpeeds(transmission, 59);
    assertEquals(transmission.getSpeed(), 59);
    assertEquals(transmission.getGear(), 6);
    int tmpSpeed = 59;
    final int speedDecrement = 9;
    for (int i = 5; i >= 1; i--) {
      tmpSpeed -= speedDecrement;
      this.decreaseSpeeds(transmission, speedDecrement);
      assertEquals(transmission.getSpeed(), tmpSpeed);
      assertEquals(transmission.getGear(), i + 1);
      tmpSpeed -= 1;
      transmission.decreaseSpeed(); // next gear
      assertEquals(transmission.getSpeed(), tmpSpeed);
      assertEquals(transmission.getGear(), i);
    }
    this.decreaseSpeeds(transmission, 9);
    assertEquals(transmission.getSpeed(), 0);
    assertEquals(transmission.getGear(), 0);
  }
  
  /**
   * This tests the decreaseSpeed() function's throwing Exception when speed becomes negative.
   */
  @Test(expected = IllegalStateException.class)
  public final void testDecreaseSpeedIllegal() {
    Transmission transmission = new AutomaticTransmission(10, 20, 30, 40, 50);
    transmission.increaseSpeed();
    transmission.decreaseSpeed();
    assertEquals(transmission.getSpeed(), 0);
    transmission.decreaseSpeed();
  }

  /**
   * This tests the equals() function.
   */
  @Test
  public final void testEquals() {
    Transmission transmission1 = new AutomaticTransmission(2, 21, 31, 41, 51);
    final Transmission transmission3 = new AutomaticTransmission(1, 21, 31, 41, 51);
    final Transmission transmission4 = new AutomaticTransmission(2, 20, 31, 41, 51);
    final Transmission transmission5 = new AutomaticTransmission(2, 21, 30, 41, 51);
    final Transmission transmission6 = new AutomaticTransmission(2, 21, 31, 40, 51);
    final Transmission transmission7 = new AutomaticTransmission(2, 21, 31, 41, 50);
    // Threshold Comparison
    assertFalse(transmission1.equals(transmission3));
    assertFalse(transmission1.equals(transmission4));
    assertFalse(transmission1.equals(transmission5));
    assertFalse(transmission1.equals(transmission6));
    assertFalse(transmission1.equals(transmission7));
    Transmission transmission2 = new AutomaticTransmission(2, 21, 31, 41, 51);
    // Speed & Gear Comparison
    assertEquals(transmission1.hashCode(), transmission2.hashCode());
    assertTrue(transmission1.equals(transmission2));
    transmission1.increaseSpeed();
    transmission2.increaseSpeed();
    assertTrue(transmission2.equals(transmission1));
    transmission1.increaseSpeed();
    assertFalse(transmission1.equals(transmission2));
    transmission3.increaseSpeed();
    assertFalse(transmission2.equals(transmission3));
    // other Comparison
    assertFalse(transmission1.equals(null));
    
  }
  
  @Test
  public final void testToString() {
    this.increaseSpeeds(this.myTransmission, 14);
    assertEquals(this.myTransmission.toString(), "Transmission (speed = 14, gear = 3)");
  }
}
