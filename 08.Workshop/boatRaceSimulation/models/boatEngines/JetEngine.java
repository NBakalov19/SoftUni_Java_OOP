package boatRaceSimulation.models.boatEngines;

import boatRaceSimulation.exceptions.ArgumentException;

public class JetEngine extends BoatEngine {

  public JetEngine(String model, int horsepower, int displacement) throws ArgumentException {
    super(model, horsepower, displacement);
  }

  @Override
  double calculateOutput() {
    return this.getHorsepower() * 5 + this.getDisplacement();
  }
}