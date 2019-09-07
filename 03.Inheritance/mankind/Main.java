package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] studentInfo = reader.readLine().split("\\s+");

    try {
      String firstName = studentInfo[0];
      String lastName = studentInfo[1];
      String facultyNumber = studentInfo[2];

      Student student = new Student(firstName, lastName, facultyNumber);
      System.out.println(student.toString());
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }

    String[] workerInfo = reader.readLine().split("\\s+");

    try {
      String firstName = workerInfo[0];
      String lastName = workerInfo[1];
      double weekSalary = Double.parseDouble(workerInfo[2]);
      double workHoursPerDay = Double.parseDouble(workerInfo[3]);

      Worker worker = new Worker(firstName, lastName, weekSalary, workHoursPerDay);
      System.out.println(worker.toString());
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
