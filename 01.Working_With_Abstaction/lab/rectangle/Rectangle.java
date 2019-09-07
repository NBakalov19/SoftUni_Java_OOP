package lab.rectangle;

public class Rectangle {
  private Point topLeft;
  private Point bottomRight;

  public Rectangle(Point topLeft, Point bottomRight) {
    this.topLeft = topLeft;
    this.bottomRight = bottomRight;
  }

  public Point getTopLeft() {
    return topLeft;
  }

  public void setTopLeft(Point topLeft) {
    this.topLeft = topLeft;
  }

  public Point getBottomRight() {
    return bottomRight;
  }

  public void setBottomRight(Point bottomRight) {
    this.bottomRight = bottomRight;
  }

  public boolean contains(Point point) {

    boolean isOnHorizontal =
            this.topLeft.getX() <= point.getX() && this.bottomRight.getX() >= point.getX();

    boolean isOnVertical =
            this.topLeft.getY() <= point.getY() & this.bottomRight.getY() >= point.getY();

    return isOnHorizontal && isOnVertical;
  }
}
