package boatRaceSimulation.models.boats;

import boatRaceSimulation.exceptions.ArgumentException;
import boatRaceSimulation.models.Model;
import boatRaceSimulation.race.Conditions;

import java.util.Objects;

public abstract class Boat implements Model {
  private String model;
  private double weight;

  protected Boat(String model, double weight) throws ArgumentException {
    this.setModel(model);
    this.setWeight(weight);
  }

  @Override
  public String getModel() {
    return this.model;
  }

  private void setModel(String model) throws ArgumentException {
    if (model.length() < 5) {
      throw new ArgumentException("Model's name must be at least 5 symbols long.");
    }
    this.model = model;
  }

  public double getWeight() {
    return this.weight;
  }

  private void setWeight(double weight) throws ArgumentException {
    if (weight < 1) {
      throw new ArgumentException("Weight must be a positive integer.");
    }
    this.weight = weight;
  }

  public abstract double getSpeed(Conditions conditions);

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Boat)) return false;
    Boat boat = (Boat) o;
    return model.equals(boat.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(model);
  }
}
