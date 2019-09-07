package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
  private double fuelQuantity;
  private double fuelConsumptionPerKm;
  private int tackCapacity;

  protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm, int tackCapacity) {
    this.fuelQuantity = fuelQuantity;
    this.setFuelConsumptionPerKm(fuelConsumptionPerKm);
    this.setTackCapacity(tackCapacity);
  }

  protected double getFuelConsumptionPerKm() {
    return this.fuelConsumptionPerKm;
  }

  protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
    this.fuelConsumptionPerKm = fuelConsumptionPerKm;
  }

  protected double getFuelQuantity() {
    return this.fuelQuantity;
  }

  public void setFuelQuantity(double fuelQuantity) {
    this.fuelQuantity = fuelQuantity;
  }

  protected void setTackCapacity(int tackCapacity) {
    this.tackCapacity = tackCapacity;
  }

  public String drive(double distance) {
    String result;
    DecimalFormat df = new DecimalFormat("#.##");
    double fuelNeeded = this.fuelConsumptionPerKm * distance;

    result = "needs refueling";

    if (this.fuelQuantity - fuelNeeded >= 0) {
      result = String.format("travelled %s km", df.format(distance));
      this.fuelQuantity -= fuelNeeded;
    }
    return result;
  }

  public void refuel(double liters) {
    double freeCapacity = this.tackCapacity - this.fuelQuantity;
    if (liters <= 0) {
      throw new IllegalArgumentException("Fuel must be a positive number");
    } else if (liters > freeCapacity) {
      throw new IllegalArgumentException("Cannot fit fuel in tank");
    } else {
      this.fuelQuantity += liters;
    }
  }

  @Override
  public String toString() {
    return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
  }
}