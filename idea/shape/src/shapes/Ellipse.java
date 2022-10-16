package shapes;

import java.util.Objects;

public class Ellipse extends AbstractShape{

    private double radiusA;
    private double radiusB;

    /**
     * Protected constructor for use by subclasses.
     * @param x
     * @param y
     * @param radiusA
     * @param radiusB
     */
    public Ellipse(double x, double y, double radiusA, double radiusB) {
        super(new Point2D(x, y));
        this.radiusA = radiusA;
        this.radiusB = radiusB;
    }

    public Ellipse(double radiusA, double radiusB) {
        super(new Point2D(0, 0));
        this.radiusA = radiusA;
        this.radiusB = radiusB;
    }

    @Override
    public double area() {
        return Math.PI * radiusA * radiusB;
    }

    @Override
    public double perimeter() {
        final double pi = Math.PI;
        final double abSum = this.radiusA + this.radiusB;
        final double abSub = this.radiusA - this.radiusB;
        final double sqrtVal = Math.sqrt(4.0 - 3.0 * abSub * abSub / (abSum * abSum));
        final double baseVal = abSum * abSum * (10.0 + sqrtVal);
        final double resVal = pi * abSum * (3.0 * abSub * abSub / baseVal + 1.00);
        return resVal;
    }

    @Override
    public Shape resize(double factor) {
        return new Ellipse(reference.getX(), reference.getY(), Math.sqrt(factor) * radiusA, Math.sqrt(factor) * radiusB);
    }

    @Override
    public String toString() {
        return String.format("Ellipse: center (%.3f,%.3f) width %.3f height %.3f", this.reference.getX(),
                this.reference.getY(), this.radiusA, this.radiusB);
    }

    @Override
    protected boolean equalsEllipse(Ellipse other) {
        return Math.abs(this.reference.dist(other.reference)) < 0.001
                && Math.abs(this.radiusA - other.radiusA) < 0.001
                && Math.abs(this.radiusB - other.radiusB) < 0.001;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AbstractShape) {
            AbstractShape ashape = (AbstractShape) other;
            // we know that this is a Ellipse, so we check rectangle equality
            return ashape.equalsEllipse(this);
        }
        // since it is not AbstractShape it is not a Ellipse either, so
        // return false
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, radiusA, radiusB);
    }
}
