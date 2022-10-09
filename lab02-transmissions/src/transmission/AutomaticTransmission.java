package transmission;

/**
 * Class AutomaticTransmission represents an auto 
 * which can change its speed and automatically change its gear.
 * It implements the class Transmission, and initiated with 5 inputs of thresholds.
 * The gear variable changes according to the thresholds, while the speed in\decreases. 
 *
 */
public final class AutomaticTransmission implements Transmission {
  
  // fields
  private int speed;
  private int gear;
  private final int threshold1;
  private final int threshold2;
  private final int threshold3;
  private final int threshold4;
  private final int threshold5;
  
  /**
   * 
   * Constructor of the AutoTransmission, takes into 5 thresholds as the gear changing gate.
   * 
   * @param inThreshold1 speed that causes the transmission to change from gear 1 to gear 2
   * @param inThreshold2 speed that causes the transmission to change from gear 2 to gear 3
   * @param inThreshold3 speed that causes the transmission to change from gear 3 to gear 4
   * @param inThreshold4 speed that causes the transmission to change from gear 4 to gear 5
   * @param inThreshold5 speed that causes the transmission to change from gear 5 to gear 6
   */
  public AutomaticTransmission(int inThreshold1,
      int inThreshold2,
      int inThreshold3,
      int inThreshold4,
      int inThreshold5) {

    if (inThreshold1 > 0 && inThreshold2 > inThreshold1
        && inThreshold3 > inThreshold2 && inThreshold4 > inThreshold3
        && inThreshold5 > inThreshold4) {
      this.threshold1 = inThreshold1;
      this.threshold2 = inThreshold2;
      this.threshold3 = inThreshold3;
      this.threshold4 = inThreshold4;
      this.threshold5 = inThreshold5;
    } else {
      throw new IllegalArgumentException("invalid input for the thresholds!\n");
    }
    
    this.speed = 0;
    this.gear = 0;
  }
  
  /**
   * Update the gear variable based on the speed.
   * 
   */
  private void updateGear() {
    this.gear = 1;
    if (this.speed == 0) {
      this.gear = 0;
    }
    if (this.speed >= this.threshold1) {
      this.gear = 2;
    }
    if (this.speed >= this.threshold2) {
      this.gear = 3;
    }
    if (this.speed >= this.threshold3) {
      this.gear = 4;
    }
    if (this.speed >= this.threshold4) {
      this.gear = 5;
    }
    if (this.speed >= this.threshold5) {
      this.gear = 6;
    }
  }
  
  /**
   * Increase the Speed by 1, and update the gear respectively.
   * 
   */
  @Override
  public void increaseSpeed() {
    this.speed += 1;
    this.updateGear();
  }

  /**
   * Decrease the Speed by 1, and update the gear respectively.
   * 
   * @throws IllegalStateException when the speed is negative after changing
   */
  @Override
  public void decreaseSpeed() throws IllegalStateException {
    this.speed -= 1;
    if (this.speed < 0) {
      throw new IllegalStateException("invalid state for negative speed!\n");
    }
    this.updateGear();
  }

  @Override
  public int getSpeed() {
    return this.speed;
  }

  @Override
  public int getGear() {
    return this.gear;
  }
  
  @Override
  public String toString() {
    final String resultString = String.format("Transmission (speed = %d, gear = %d)",
        this.getSpeed(), this.getGear());
    return resultString;
  }
  
  @Override
  public int hashCode() {
    return 41 + this.toString().hashCode() * 7;
  }
  
  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    
    // Type mismatch
    if (!(o instanceof AutomaticTransmission)) {
      return false;
    }
    
    AutomaticTransmission that = (AutomaticTransmission) o;
    
    if (this.getGear() == that.getGear()
        && this.getSpeed() == that.getSpeed()
        && this.threshold1 == that.threshold1
        && this.threshold2 == that.threshold2
        && this.threshold3 == that.threshold3
        && this.threshold4 == that.threshold4
        && this.threshold5 == that.threshold5) {
      return true;
    }
    
    return false;
  }

}
