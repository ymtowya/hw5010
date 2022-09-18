package weather;

/**
 * 
 * This class implements the interface {@code WeatherReading} and is based on
 * Stevenson Screen's data collection, represented as Air Temperature, Dew Points, 
 * Wind Speed, and Total Rain.
 */
public final class StevensonReading implements WeatherReading {

  /**
   * 
   * Fields of major collected and calculated values.
   */
  private final Double airTemperatureDouble;
  private final Double dewTemperatureDouble;
  private final Double windSpeedDouble;
  private final Integer totalRainInteger;

  /**
   * Constructs a StevensonReading in terms of its air temperature, its Dew
   * Points, its wind speed and its total rain as collected by the device.
   * 
   * @param airTemperature the temperature of air in Celsius
   * @param dewTemperature the dew point temperature in Celsius
   * @param windSpeed      the non-negative wind speed in miles per hour
   * @param totalRain      the non-negative total rain received in the last 24
   *                       hours in millimeters
   */
  public StevensonReading(double airTemperature, double dewTemperature, double windSpeed,
      int totalRain) {
    
    // The dew point cannot be greater than the air temperature
    if (dewTemperature > airTemperature) {
      throw new IllegalArgumentException("dewTemperature cannot be higher than airTemperature");
    }

    if (windSpeed < 0) {
      throw new IllegalArgumentException("windSpeed cannot be negative");
    }

    if (totalRain < 0) {
      throw new IllegalArgumentException("totalRain cannot be negative");
    }

    this.airTemperatureDouble = airTemperature;
    this.dewTemperatureDouble = dewTemperature;
    this.windSpeedDouble = windSpeed;
    this.totalRainInteger = totalRain;
  }

  /**
   * This private function converts a double value into its rounded nearest integer value.
   * 
   * @param input value in double type
   * @return the nearest integer of the input
   */
  private int getRoundIntFromDouble(double input) {
    return (int) Math.round(input);
  }

  @Override
  public int getTemperature() {
    return this.getRoundIntFromDouble(this.airTemperatureDouble);
  }

  @Override
  public int getDewPoint() {
    return this.getRoundIntFromDouble(this.dewTemperatureDouble);
  }

  @Override
  public int getWindSpeed() {
    return this.getRoundIntFromDouble(this.windSpeedDouble);
  }

  @Override
  public int getTotalRain() {
    return this.totalRainInteger.intValue();
  }

  /**
   * This function calculated the vapor pressure based on the input temperature.
   * 
   * @param temperature double type value of the temperature
   * @return the vapor pressure
   */
  private double calcVaporPressure(Double temperature) {
    return 6.11 * 10.0 * (7.5 * temperature / (237.3 + temperature));
  }

  /**
   * This function calculates the relative humidity (of 100 percentage).
   * 
   * @return the relative humidity (in xx% form)
   */
  private double calcReH() {
    return 100 * this.calcVaporPressure(this.dewTemperatureDouble)
        / this.calcVaporPressure(this.airTemperatureDouble);
  }

  @Override
  public int getRelativeHumidity() {
    return this.getRoundIntFromDouble(this.calcReH());
  }

  /**
   * This function calculates the Heat index All coefficients are treated as inside constants.
   * 
   * @return Heat index
   */
  private double calcHeatIndex() {
    // constant coefficients
    final double c1 = -8.78469475556;
    final double c2 = 1.61139411;
    final double c3 = 2.33854883889;
    final double c4 = -0.14611605;
    final double c5 = -0.012308094;
    final double c6 = -0.0164248277778;
    final double c7 = 0.002211732;
    final double c8 = 0.00072546;
    final double c9 = -0.000003582;
    // air temperature
    final double airT = this.airTemperatureDouble.doubleValue();
    // relative humidity
    final double rh = this.calcReH();
    // based on given formulas
    double result = 0.0;
    result += c1 + c2 * airT + c3 * rh + c4 * airT * rh;
    result += c5 * airT * airT + c6 * rh * rh;
    result += c7 * airT * airT * rh + c8 * airT * rh * rh;
    result += c9 * airT * airT * rh * rh;

    return result;
  }

  @Override
  public int getHeatIndex() {
    return this.getRoundIntFromDouble(this.calcHeatIndex());
  }

  private double getFahrFromCels(double tempInCels) {
    return 9.0 * tempInCels / 5.0 + 32.0;
  }

  private double getCelsFromFahr(double tempInFahr) {
    return 5.0 * (tempInFahr - 32.0) / 9.0;
  }

  private double calcWindChill() {
    // temperature in Fehr form
    final double tF = this.getFahrFromCels(this.airTemperatureDouble);
    // wind speed
    final double wS = this.windSpeedDouble.doubleValue();
    // constant coefficients
    final double p1 = 35.74;
    final double p2 = 0.6215;
    final double p3 = 35.75;
    final double p4 = 0.4275;
    final double e1 = +0.16;

    double result = 0.0;
    result += p1 + p2 * tF - p3 * Math.pow(wS, e1) + p4 * tF * Math.pow(wS, e1);

    return result;
  }

  @Override
  public int getWindChill() {
    return this.getRoundIntFromDouble(this.getCelsFromFahr(this.calcWindChill()));
  }

  @Override
  public String toString() {
    String resultString = String.format("Reading: T = %d, D = %d, v = %d, rain = %d",
        this.getTemperature(), this.getDewPoint(), this.getWindSpeed(), this.getTotalRain());
    return resultString;
  }

  @Override
  public int hashCode() {
    return 19 + this.toString().hashCode() * 7;
  }

  @Override
  public boolean equals(Object o) {
    // Same Reference
    if (o == this) {
      return true;
    }

    // Type mismatch
    if (!(o instanceof WeatherReading)) {
      return false;
    }

    // Type convert
    WeatherReading thatReading = (WeatherReading) o;
    
    // hashCode Comparison
    if (this.hashCode() != thatReading.hashCode()) {
      return false;
    }

    boolean result = thatReading.getTemperature() == this.getTemperature()
        && thatReading.getDewPoint() == this.getDewPoint()
        && thatReading.getWindSpeed() == this.getWindSpeed()
        && thatReading.getTotalRain() == this.getTotalRain();

    return result;
  }

}
