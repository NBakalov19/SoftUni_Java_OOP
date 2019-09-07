package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List<Identifiable> rebellions = new ArrayList<>();

    String[] input = reader.readLine().split("\\s+");

    while (!input[0].equals("End")) {

      if (input.length == 2) {
        String model = input[0];
        String id = input[1];

        Robot robot = new Robot(model, id);

        rebellions.add(robot);
      } else if (input.length == 3) {
        String name = input[0];
        int age = Integer.parseInt(input[1]);
        String id = input[2];

        Citizen citizen = new Citizen(name, age, id);

        rebellions.add(citizen);
      }
      input = reader.readLine().split("\\s+");
    }

    String number = reader.readLine();

    for (Identifiable rebellion : rebellions) {
      if (rebellion.getId().endsWith(number)) {
        System.out.println(rebellion.getId());
      }
    }
  }
}