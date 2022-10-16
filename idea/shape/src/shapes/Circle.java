package shapes;

import java.util.Objects;

/**
 * This class represents a circle. It offers all the operations mandated by the
 * Shape interface.
 */
public class Circle extends Ellipse {
  private double radius;

  /**
   * Construct a circle object using the given center and radius.
   *
   * @param x      x coordinate of the center of this circle
   * @param y      y coordinate of the center of this circle
   * @param radius the radius of this circle
   */
  public Circle(double x, double y, double radius) {
    super(x, y, radius, radius);
    this.radius = radius;
  }

  /**
   * Construct a circle object with the given radius. It is centered at (0,0)
   *
   * @param radius the radius of this circle
   */
  public Circle(double radius) {
    super(radius, radius);
    this.radius = radius;
  }

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public Shape resize(double factor) {
    return new Circle(reference.getX(), reference.getY(), Math.sqrt(factor) * radius);
  }

  @Override
  public String toString() {
    return String.format("Circle: center (%.3f,%.3f) radius %.3f", this.reference.getX(),
        this.reference.getY(), this.radius);
  }

  @Override
  protected boolean equalsCircle(Circle other) {
    return Math.abs(this.reference.dist(other.reference)) < 0.001
        && Math.abs(this.radius - other.radius) < 0.001;
  }
  
  @Override
  protected boolean equalsEllipse(Ellipse other) {
    return false;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractShape) {
      AbstractShape ashape = (AbstractShape) other;
      // we know that this is a circle, so we check rectangle equality
      return ashape.equalsCircle(this);
    }
    // since it is not AbstractShape it is not a circle either, so
    // return false
    return false;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(reference, radius);
  }
}
