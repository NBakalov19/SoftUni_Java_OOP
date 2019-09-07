package Vehicles;

public class Car extends Vehicle {

  public Car(double fuelQuantity, double fuelConsumptionPerKm, int tackCapacity) {
    super(fuelQuantity, fuelConsumptionPerKm, tackCapacity);
  }

  @Override
  protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
    super.setFuelConsumptionPerKm(fuelConsumptionPerKm + 0.9);
  }

  @Override
  public String drive(double distance) {
    return String.format("Car %s", super.drive(distance));
  }

}