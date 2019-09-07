package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] tokens = reader.readLine().split("\\s+");
    Car car = new Car(
            Double.parseDouble(tokens[1]),
            Double.parseDouble(tokens[2]),
            Integer.parseInt(tokens[3]));

    tokens = reader.readLine().split("\\s+");

    Truck truck = new Truck(
            Double.parseDouble(tokens[1]),
            Double.parseDouble(tokens[2]),
            Integer.parseInt(tokens[3]));

    tokens = reader.readLine().split("\\s+");

    Bus bus = new Bus(
            Double.parseDouble(tokens[1]),
            Double.parseDouble(tokens[2]),
            Integer.parseInt(tokens[3]));

    int n = Integer.parseInt(reader.readLine());

    while (n > 0) {
      tokens = reader.readLine().split("\\s+");
      String action = tokens[0];
      String typeVehicle = tokens[1];
      switch (action) {
        case "Drive":
          if (typeVehicle.equals("Car")) {
            System.out.println(car.drive(Double.parseDouble(tokens[2])));
          } else if (typeVehicle.equals("Truck")) {
            System.out.println(truck.drive(Double.parseDouble(tokens[2])));
          } else {
            System.out.println(bus.drive(Double.parseDouble(tokens[2]), false));
          }
          break;
        case "DriveEmpty":
          System.out.println(bus.drive(Double.parseDouble(tokens[2]), true));
          break;
        case "Refuel":
          try {
            if (typeVehicle.equals("Car")) {
              car.refuel(Double.parseDouble(tokens[2]));
            } else if (typeVehicle.equals("Truck")) {
              truck.refuel(Double.parseDouble(tokens[2]));
            } else {
              bus.refuel(Double.parseDouble(tokens[2]));
            }
          } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());

          }
          break;
      }
      n--;
    }

    System.out.println(car.toString());
    System.out.println(truck.toString());
    System.out.println(bus.toString());
  }
}