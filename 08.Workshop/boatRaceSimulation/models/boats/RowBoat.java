package boatRaceSimulation.models.boats;

import boatRaceSimulation.exceptions.ArgumentException;
import boatRaceSimulation.race.Conditions;

public class RowBoat extends Boat {
  private int oars;

  public RowBoat(String model, double weight, int oars) throws ArgumentException {
    super(model, weight);
    this.setOars(oars);
  }

  public int getOars() {
    return this.oars;
  }

  private void setOars(int oars) throws ArgumentException {
    if (oars < 1) {
      throw new ArgumentException("Oars must be a positive integer.");
    }

    this.oars = oars;
  }

  @Override
  public double getSpeed(Conditions conditions) {
    return this.getOars() * 100 - this.getWeight() + conditions.getCurrentSpeed();
  }
}