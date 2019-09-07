package sortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int countOfPeople = Integer.parseInt(reader.readLine());

    ArrayList<Person> people = new ArrayList<>();

    for (int i = 0; i < countOfPeople; i++) {
      String[] tokens = reader.readLine().split("\\s+");

      Person person = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]));

      people.add(person);
    }

    people.stream().sorted(Comparator.comparing(Person::getFirstName)
            .thenComparing(Person::getAge))
            .forEach(System.out::println);
  }
}