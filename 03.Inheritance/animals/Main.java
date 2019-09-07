package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] animalInfo = reader.readLine().split("\\s+");

    while (!animalInfo[0].equals("Beast!")) {
      String typeOfAnimal = animalInfo[0];

      animalInfo = reader.readLine().split("\\s+");

      String name = animalInfo[0];
      int age = Integer.parseInt(animalInfo[1]);
      String gender = animalInfo[2];

      switch (typeOfAnimal) {
        case "Dog":
          try {
            Dog dog = new Dog(name, age, gender);
            System.out.println(dog.toString());
          } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
          }
          break;
        case "Cat":
          try {
            Cat cat = new Cat(name, age, gender);
            System.out.println(cat.toString());
          } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
          }
          break;
        case "Frog":
          try {
            Frog frog = new Frog(name, age, gender);
            System.out.println(frog.toString());
          } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
          }
          break;
        case "Kitten":
          try {
            Kitten kitten = new Kitten(name, age, gender);
            System.out.println(kitten.toString());
          } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
          }
          break;
        case "Tomcat":
          try {
            Tomcat tomcat = new Tomcat(name, age, gender);
            System.out.println(tomcat.toString());
          } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
          }
          break;
        default:
          try {
            Animal animal = new Animal(name, age, gender);
            System.out.println(animal.toString());
          } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
          }
      }
      animalInfo = reader.readLine().split("\\s+");
    }
  }
}