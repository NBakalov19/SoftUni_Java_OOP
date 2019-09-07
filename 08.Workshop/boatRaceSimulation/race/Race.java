package boatRaceSimulation.race;

import boatRaceSimulation.exceptions.ArgumentException;
import boatRaceSimulation.exceptions.DuplicateModelException;
import boatRaceSimulation.models.MotorBoats;
import boatRaceSimulation.models.boats.Boat;

import java.util.HashSet;
import java.util.Set;

public class Race {
  private double distance;
  private Conditions conditions;
  private Set<Boat> participants;
  private boolean allowMotorboats;

  public Race(double distance, double windSpeed, double currentSpeed, boolean allowMotorboats) throws ArgumentException {
    this.setDistance(distance);
    this.conditions = new Conditions(windSpeed, currentSpeed);
    this.allowMotorboats = allowMotorboats;
    this.participants = new HashSet<>();
  }

  public void addParticipants(Boat participant) throws DuplicateModelException, ArgumentException {
    if (!this.areAllowedMotorboats() && participant instanceof MotorBoats) {
      throw new ArgumentException("The specified boat does not meet the race constraints.");
    }

    boolean added = this.participants.add(participant);

    if (!added) {
      throw new DuplicateModelException();
    }
  }

  public double getDistance() {
    return this.distance;
  }

  private void setDistance(double distance) throws ArgumentException {
    if (distance < 1) {
      throw new ArgumentException("Distance must be a positive integer.");
    }
    this.distance = distance;
  }

  public Conditions getConditions() {
    return this.conditions;
  }

  public Set<Boat> getParticipants() {
    return this.participants;
  }

  private boolean areAllowedMotorboats() {
    return this.allowMotorboats;
  }

  public boolean enoughParticipants() {
    return this.participants.size() > 2;
  }
}