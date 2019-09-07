package boatRaceSimulation.models.boats;

public class BoatResult {
  private Boat boat;
  private double raceTime;


  public BoatResult(Boat boat, double raceTime) {
    this.boat = boat;
    this.raceTime = raceTime;
  }

  public Boat getBoat() {
    return boat;
  }

  public double getRaceTime() {
    return raceTime;
  }

}