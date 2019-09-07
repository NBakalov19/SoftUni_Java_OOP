package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] input = reader.readLine().split("\\s+");
    Pizza pizza;
    try {
      String typePizza = input[1];
      int count = Integer.parseInt(input[2]);
      pizza = new Pizza(typePizza, count);
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
      return;
    }

    input = reader.readLine().split("\\s+");

    Dough dough;
    String flourType = input[1];
    String bakingTechnique = input[2];
    double flourWeight = Double.parseDouble(input[3]);
    try {
      dough = new Dough(flourType, bakingTechnique, flourWeight);
      pizza.setDough(dough);
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
      return;
    }

    Topping topping;
    input = reader.readLine().split("\\s+");
    while (!input[0].equals("END")) {

      String toppingType = input[1];
      double toppingWeight = Double.parseDouble(input[2]);
      try {
        topping = new Topping(toppingType, toppingWeight);
        pizza.addTopping(topping);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        return;
      }

      input = reader.readLine().split("\\s+");
    }
    System.out.println(pizza.toString());
  }
}