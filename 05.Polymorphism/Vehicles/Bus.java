package Vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

  protected Bus(double fuelQuantity, double fuelConsumptionPerKm, int tackCapacity) {
    super(fuelQuantity, fuelConsumptionPerKm, tackCapacity);
  }

  public String drive(double distance, boolean isEmpty) {
    String result;
    DecimalFormat df = new DecimalFormat("#.##");
    double fuelNeeded = 0d;
    if (isEmpty) {
      fuelNeeded = getFuelConsumptionPerKm() * distance;
    } else {
      fuelNeeded = (getFuelConsumptionPerKm() + 1.4) * distance;
    }
    result = "needs refueling";

    if (getFuelQuantity() - fuelNeeded >= 0) {
      result = String.format("travelled %s km", df.format(distance));
      setFuelQuantity(getFuelQuantity() - fuelNeeded);
    }
    return String.format("Bus %s", result);
  }

}