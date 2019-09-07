package Vehicles;

public class Truck extends Vehicle {

  public Truck(double fuelQuantity, double fuelConsumptionPerKm, int tackCapacity) {
    super(fuelQuantity, fuelConsumptionPerKm, tackCapacity);
  }

  @Override
  protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
    super.setFuelConsumptionPerKm(fuelConsumptionPerKm + 1.6);
  }

  @Override
  public String drive(double distance) {
    return String.format("Truck %s", super.drive(distance));
  }

  @Override
  public void refuel(double liters) {
    super.refuel(liters * 0.95);
  }
}