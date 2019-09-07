package boatRaceSimulation.models.boats;

import boatRaceSimulation.exceptions.ArgumentException;
import boatRaceSimulation.models.MotorBoats;
import boatRaceSimulation.models.boatEngines.BoatEngine;
import boatRaceSimulation.race.Conditions;

public class PowerBoat extends MotorBoats {
  private BoatEngine secondEngine;

  public PowerBoat(String model, double weight, BoatEngine firstEngine, BoatEngine secondEngine) throws ArgumentException {
    super(model, weight, firstEngine);
    this.secondEngine = secondEngine;
  }

  @Override
  public double getSpeed(Conditions conditions) {
    return (this.getEngine().getOutput() + this.secondEngine.getOutput()) -
            this.getWeight() +
            (conditions.getCurrentSpeed() / 5);
  }
}