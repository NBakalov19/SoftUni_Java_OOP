package shapes;

public class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public final double getRadius() {
    return this.radius;
  }

  @Override
  double calculatePerimeter() {
    return 2 * Math.PI * getRadius();
  }

  @Override
  double calculateArea() {
    return Math.PI * Math.pow(getRadius(), 2);
  }
}