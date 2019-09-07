package boatRaceSimulation.models.boats;

import boatRaceSimulation.exceptions.ArgumentException;
import boatRaceSimulation.models.MotorBoats;
import boatRaceSimulation.models.boatEngines.BoatEngine;
import boatRaceSimulation.race.Conditions;

public class Yacht extends MotorBoats {
  private double cargo;

  public Yacht(String model, double weight, BoatEngine engine, double cargo) throws ArgumentException {
    super(model, weight, engine);
    this.setCargo(cargo);
  }

  public double getCargo() {
    return this.cargo;
  }

  private void setCargo(double cargo) throws ArgumentException {
    if (cargo < 1) {
      throw new ArgumentException("Cargo Weight must be a positive integer.");
    }
    this.cargo = cargo;
  }

  public double getSpeed(Conditions conditions) {
    return this.getEngine().getOutput() - (this.getWeight() + this.getCargo()) + (conditions.getCurrentSpeed() / 2);
  }
}
