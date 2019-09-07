package exercise.TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] initialStates = reader.readLine().split("\\s+");

    int updatesCount = Integer.parseInt(reader.readLine());

    ArrayList<TrafficLight> trafficLights = new ArrayList<>();

    for (String initialState : initialStates) {
      TrafficLight trafficLight = new TrafficLight(LightStates.valueOf(initialState));
      trafficLights.add(trafficLight);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < updatesCount; i++) {
      for (TrafficLight trafficLight : trafficLights) {
        trafficLight.update();
        sb.append(trafficLight.toString()).append(" ");
      }
      sb.append(System.lineSeparator());
    }

    System.out.println(sb.toString());
  }
}