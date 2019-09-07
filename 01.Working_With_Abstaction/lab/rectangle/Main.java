package lab.rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] rectangleCoordinates = readArray(scanner);

    Point topLeft = new Point(rectangleCoordinates[0], rectangleCoordinates[1]);
    Point bottomRight = new Point(rectangleCoordinates[2], rectangleCoordinates[3]);

    Rectangle rectangle = new Rectangle(topLeft, bottomRight);

    int pointsCount = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < pointsCount; i++) {

      int[] pointsCoordinates = readArray(scanner);

      Point currentPoint = new Point(pointsCoordinates[0], pointsCoordinates[1]);
      System.out.println(rectangle.contains(currentPoint));
    }
  }

  private static int[] readArray(Scanner scanner) {
    return Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();
  }
}