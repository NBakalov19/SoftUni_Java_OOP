package shapes;

public class Rectangle extends Shape {
  private double height;
  private double width;

  public Rectangle(double height, double width) {
    this.height = height;
    this.width = width;
  }

  public double getHeight() {
    return this.height;
  }

  public double getWidth() {
    return this.width;
  }

  @Override
  double calculatePerimeter() {
    return 2 * getHeight() + 2 * getWidth();
  }

  @Override
  double calculateArea() {
    return getHeight() * getWidth();
  }
}