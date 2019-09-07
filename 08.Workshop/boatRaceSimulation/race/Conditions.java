package boatRaceSimulation.race;

public class Conditions {
  private double windSpeed;
  private double currentSpeed;

  public Conditions(double windSpeed, double currentSpeed) {
    this.windSpeed = windSpeed;
    this.currentSpeed = currentSpeed;
  }

  public double getWindSpeed() {
    return this.windSpeed;
  }

  public double getCurrentSpeed() {
    return this.currentSpeed;
  }
}
