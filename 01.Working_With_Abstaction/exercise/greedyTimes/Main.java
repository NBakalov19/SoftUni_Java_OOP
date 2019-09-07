package exercise.greedyTimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    long bagCapacity = Long.parseLong(reader.readLine());
    Bag bag = new Bag(bagCapacity);
    String[] input = reader.readLine().split("\\s+");

    for (int i = 0; i < input.length; i += 2) {
      String item = input[i];
      long quantity = Long.parseLong(input[i + 1]);

      if (item.length() == 3) {
        bag.addCash(item, quantity);
      } else if (item.toLowerCase().endsWith("gem") && item.length() > 3) {
        bag.addGem(item, quantity);
      } else if (item.equalsIgnoreCase("gold")) {
        bag.addGold(quantity);
      }
    }

    System.out.print(bag.toString());
  }
}