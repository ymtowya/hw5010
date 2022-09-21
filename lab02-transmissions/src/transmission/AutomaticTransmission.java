
package transmission;

/**
 * Implement Transmission, initiated with 6 inputs.
 *
 */
public final class AutomaticTransmission implements Transmission {
  
  int speed;
  int gear;
  int threshold1;
  int threshold2;
  int threshold3;
  int threshold4;
  int threshold5;
  
  /**
   * 
   * Constructor of the AutoTransmission, takes into 5 thresholds for the gear to change.
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
  
  @Override
  public void increaseSpeed() {
    this.speed += 1;
    this.updateGear();
  }

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

}
