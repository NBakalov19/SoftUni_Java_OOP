package interfacePerson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] input = reader.readLine().split("\\s+");
    List<Birthable> birthables = new ArrayList<>();

    while (!input[0].equals("End")) {

      if (input[0].equals("Citizen")) {
        String name = input[1];
        int age = Integer.parseInt(input[2]);
        String id = input[3];
        String birthDate = input[4];

        Citizen citizen = new Citizen(name, age, id, birthDate);
        birthables.add(citizen);
      } else if (input[0].equals("Pet")) {
        String name = input[1];
        String birthDate = input[2];

        Pet pet = new Pet(name, birthDate);

        birthables.add(pet);
      }
      input = reader.readLine().split("\\s+");
    }

    String yearOfBirth = reader.readLine();

    for (Birthable birthable : birthables) {
      if (birthable.getBirthDate().endsWith(yearOfBirth)) {
        System.out.println(birthable.getBirthDate());
      }
    }
  }
}