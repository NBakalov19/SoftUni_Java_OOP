package shapes;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Shape rectangle = new Rectangle(2, 5);
    Shape circle = new Circle(5);

    List<Shape> shapes = new ArrayList<>();
    shapes.add(rectangle);
    shapes.add(circle);


    for (Shape shape : shapes) {
      System.out.println(shape.calculatePerimeter());
      System.out.println(shape.calculateArea());
    }
  }
}