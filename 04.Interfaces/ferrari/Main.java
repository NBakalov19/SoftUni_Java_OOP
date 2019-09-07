package ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {
  public static void main(String[] args) throws IOException, IllegalClassFormatException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String driverName = reader.readLine();
    Ferrari ferrari = new Ferrari(driverName);

    String ferrariName = Ferrari.class.getSimpleName();
    String carInterface = Car.class.getSimpleName();
    boolean isCreated = Car.class.isInterface();
    if (!isCreated) {
      throw new IllegalClassFormatException("No interface created!");
    }

    System.out.println(ferrari.toString());
  }
}
