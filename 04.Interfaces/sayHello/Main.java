package sayHello;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Person> persons = new ArrayList<>();

    persons.add(new Bulgarian("Pesho"));
    persons.add(new European("George"));
    persons.add(new Chinese("Liu"));

    for (Person person : persons) {
      System.out.println(person.sayHello());
    }
  }
}