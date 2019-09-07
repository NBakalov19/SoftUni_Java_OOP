package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] people = reader.readLine().split("[;=]+");
    Person person;
    Map<String, Person> validPeople = new HashMap<>();

    for (int i = 0; i < people.length - 1; i += 2) {
      String name = people[i];
      double money = Double.parseDouble(people[i + 1]);

      try {
        person = new Person(name, money);
        validPeople.put(name, person);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
      }
    }

    String[] products = reader.readLine().split("[;=]+");
    Map<String, Product> validProducts = new HashMap<>();
    Product product;

    for (int i = 0; i < products.length - 1; i += 2) {
      String name = products[i];
      double cost = Double.parseDouble(products[i + 1]);

      try {
        product = new Product(name, cost);
        validProducts.put(name, product);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
      }
    }

    String[] tokens = reader.readLine().split("\\s+");
    while (!tokens[0].equals("END")) {
      String personName = tokens[0];
      String productName = tokens[1];
      Person currentPerson;
      Product currentProduct;
      if (validPeople.containsKey(personName) && validProducts.containsKey(productName)) {
        currentPerson = validPeople.get(personName);
        currentProduct = validProducts.get(tokens[1]);
        currentPerson.buyProduct(currentProduct);
      } else {
        tokens = reader.readLine().split("\\s+");
        continue;
      }

      tokens = reader.readLine().split("\\s+");
    }

    for (Person p : validPeople.values()) {
      System.out.println(p.toString());
    }
  }
}