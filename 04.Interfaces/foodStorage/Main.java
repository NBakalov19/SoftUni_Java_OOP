package foodStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int countOfPersons = Integer.parseInt(reader.readLine());
    Map<String, Buyer> people = new HashMap<>();

    for (int i = 0; i < countOfPersons; i++) {
      Buyer person;
      String[] input = reader.readLine().split("\\s+");
      String name = input[0];
      int age = Integer.parseInt(input[1]);

      if (input.length == 3) {
        String group = input[2];
        person = new Rebel(name, age, group);
        people.put(name, person);
      } else if (input.length == 4) {
        String id = input[2];
        String birthDate = input[3];
        person = new Citizen(name, age, id, birthDate);
        people.put(name, person);
      }
    }

    String buyer = reader.readLine();

    while (!buyer.equals("End")) {
      if (people.containsKey(buyer)) {
        people.get(buyer).buyFood();
      }
      buyer = reader.readLine();
    }

    System.out.println(people.values().stream()
            .map(Buyer::getFood)
            .reduce(0, Integer::sum));
  }
}