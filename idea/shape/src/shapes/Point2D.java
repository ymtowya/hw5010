package shapes;

import java.util.Objects;

/**
 * This class represents a 2D point. This point is denoted in Cartesian
 * coordinates as (x, y).
 */
public class Point2D {
  private double xcoord;
  private double ycoord;

  /**
   * Construct a 2d point with the given coordinates.
   *
   * @param x the x-coordinate of this point
   * @param y the y-coordinate of this point
   */
  public Point2D(double x, double y) {
    this.xcoord = x;
    this.ycoord = y;
  }

  /**
   * Compute and return the Euclidean distance between this point and another
   * point passed as its argument.
   *
   * @param other the other point to which the distance from this point is to be
   *              computed
   * @return the Euclidean distance between this point and the other point
   */
  public double dist(Point2D other) {
    double xdiff = this.xcoord - other.xcoord;
    double ydiff = this.ycoord - other.ycoord;
    return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
  }

  /**
   * Return the x-coordinate of this point.
   *
   * @return x-coordinate of this point
   */
  public double getX() {
    return xcoord;
  }

  /**
   * Return the y-coordinate of this point.
   *
   * @return y-coordinate of this point
   */
  public double getY() {
    return ycoord;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Point2D)) {
      return false;
    }

    Point2D other = (Point2D) o;
    return Math.abs(this.xcoord - other.xcoord) < 0.001
        && Math.abs(this.ycoord - other.ycoord) < 0.001;
  }

  @Override
  public int hashCode() {
    return Objects.hash(xcoord, ycoord);
  }
}
