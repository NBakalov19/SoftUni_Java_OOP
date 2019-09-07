package boatRaceSimulation.models.boatEngines;

import boatRaceSimulation.exceptions.ArgumentException;

public class SterndriveEngine extends BoatEngine {

  public SterndriveEngine(String model, int horsepower, int displacement) throws ArgumentException {
    super(model, horsepower, displacement);
  }

  @Override
  double calculateOutput() {
    return this.getHorsepower() * 7 + this.getDisplacement();
  }
}
