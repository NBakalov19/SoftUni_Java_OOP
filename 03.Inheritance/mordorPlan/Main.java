package mordorPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] input = reader.readLine().toLowerCase().split("\\s+");
    Map<String, Food> foods = new HashMap<>() {
      {
        put("apple", new Apple(1));
        put("melon", new Melon(1));
        put("cram", new Cram(2));
        put("lembas", new Lembas(3));
        put("honeycake", new HoneyCake(5));
        put("mushrooms", new Mushrooms(-10));
      }
    };

    Gandalf gandalf = new Gandalf();

    for (String food : input) {
      int happiness = -1;
      if (foods.containsKey(food)) {
        happiness = foods.get(food).getHappinessPoints();
      }
      gandalf.eatFood(happiness + "");
    }

    System.out.println(gandalf.getFoodPoints());
    System.out.println(gandalf.getMood());
  }
}