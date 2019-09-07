package exercise.TrafficLight;

public class TrafficLight {
  private LightStates lightStates;

  public TrafficLight(LightStates lightStates) {
    this.lightStates = lightStates;
  }

  public void update() {
    switch (this.lightStates) {
      case RED:
        this.lightStates = LightStates.GREEN;
        break;
      case GREEN:
        this.lightStates = LightStates.YELLOW;
        break;
      case YELLOW:
        this.lightStates = LightStates.RED;
        break;
    }
  }

  @Override
  public String toString() {
    return this.lightStates.toString();
  }
}
