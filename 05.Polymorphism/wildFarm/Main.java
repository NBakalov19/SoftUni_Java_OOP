package wildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    String[] input = reader.readLine().split("\\s+");
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Food> foods = new ArrayList<>();
    while (!input[0].equals("End")) {
      Animal animal;
      String typeAnimal = input[0];
      String animalName = input[1];
      Double animalWeight = Double.parseDouble(input[2]);
      String livingRegion = input[3];

      switch (typeAnimal) {
        case "Mouse":
          animal = new Mouse(animalName, animalWeight, livingRegion);

          break;
        case "Zebra":
          animal = new Zebra(animalName, animalWeight, livingRegion);
          break;
        case "Tiger":
          animal = new Tiger(animalName, animalWeight, livingRegion);

          break;
        default:
          String catBreed = input[4];
          animal = new Cat(animalName, animalWeight, livingRegion, catBreed);
          break;
      }

      input = reader.readLine().split("\\s+");
      Food food;

      String typeFood = input[0];
      int quantity = Integer.parseInt(input[1]);
      if (typeFood.equals("Vegetable")) {
        food = new Vegetable(quantity);
      } else {
        food = new Meat(quantity);
      }
      animals.add(animal);
      foods.add(food);
      input = reader.readLine().split("\\s+");
    }

    for (int i = 0; i < animals.size(); i++) {
      System.out.println(animals.get(i).makeSound());
      try {
        animals.get(i).eat(foods.get(i));
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
      }
    }
    for (Animal animal : animals) {
      System.out.println(animal.toString());
    }
  }
}