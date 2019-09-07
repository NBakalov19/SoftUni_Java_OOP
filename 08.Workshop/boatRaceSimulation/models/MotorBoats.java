package boatRaceSimulation.models;

import boatRaceSimulation.exceptions.ArgumentException;
import boatRaceSimulation.models.boatEngines.BoatEngine;
import boatRaceSimulation.models.boats.Boat;

public abstract class MotorBoats extends Boat {
  private BoatEngine engine;

  protected MotorBoats(String model, double weight, BoatEngine engine) throws ArgumentException {
    super(model, weight);
    this.engine = engine;
  }

  public BoatEngine getEngine() {
    return this.engine;
  }
}