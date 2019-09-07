package boatRaceSimulation.models.boatEngines;

import boatRaceSimulation.exceptions.ArgumentException;
import boatRaceSimulation.models.Model;

public abstract class BoatEngine implements Model {
  private String model;
  private double output;
  private int horsepower;
  private int displacement;

  protected BoatEngine(String model, int horsepower, int displacement) throws ArgumentException {
    this.setModel(model);
    this.setHorsepower(horsepower);
    this.setDisplacement(displacement);
    this.output = this.calculateOutput();
  }

  abstract double calculateOutput();

  @Override
  public String getModel() {
    return this.model;
  }

  public void setModel(String model) throws ArgumentException {
    if (model.length() < 3) {
      throw new ArgumentException("Model's name must be at least 3 symbols long.");
    }
    this.model = model;
  }

  public double getOutput() {
    return this.output;
  }

  public int getHorsepower() {
    return horsepower;
  }

  private void setHorsepower(int horsepower) throws ArgumentException {
    if (horsepower < 1) {
      throw new ArgumentException("Horsepower must be a positive integer.");
    }
    this.horsepower = horsepower;
  }

  public int getDisplacement() {
    return displacement;
  }

  private void setDisplacement(int displacement) throws ArgumentException {
    if (displacement < 1) {
      throw new ArgumentException("Displacement must be a positive integer.");
    }

    this.displacement = displacement;
  }
}