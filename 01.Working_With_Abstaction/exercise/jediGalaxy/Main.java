package exercise.jediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int[] dimension = Arrays
            .stream(reader.readLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();
    Galaxy galaxy = new Galaxy(dimension[0], dimension[1]);
    StarsManipulator starsManipulator = new StarsManipulator(galaxy);

    String input = reader.readLine();

    long sum = 0;

    while (!input.equalsIgnoreCase("Let the Force be with you")) {

      int[] jediPosition = Arrays
              .stream(input.split("\\s+"))
              .mapToInt(Integer::parseInt)
              .toArray();

      int[] sithPosition = Arrays
              .stream(reader.readLine().split("\\s+"))
              .mapToInt(Integer::parseInt)
              .toArray();

      starsManipulator.destroyStars(sithPosition);

      sum += starsManipulator.sumOfStars(jediPosition);

      input = reader.readLine();
    }

    System.out.println(sum);
  }
}