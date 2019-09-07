package boatRaceSimulation;

import boatRaceSimulation.exceptions.*;
import boatRaceSimulation.models.boats.BoatResult;

import java.text.DecimalFormat;
import java.util.List;

public class CommandHandler {

  private static final String TRUE_STRING = "true";
  private final ApplicationController appController;

  public CommandHandler() {
    this.appController = new ApplicationController();
  }

  public void handle(String[] split) throws DuplicateModelException,
          RaceAlreadyExistsException,
          NoSetRaceException,
          ArgumentException,
          InsufficientContestantsException {
    String result = "";

    switch (split[0]) {
      case "CreateBoatEngine":
        result = createBoatEngine(split);
        break;
      case "CreateRowBoat":
        result = createRowBoat(split);
        break;
      case "CreateSailBoat":
        result = createSailBoat(split);
        break;
      case "CreatePowerBoat":
        result = createPowerBoat(split);
        break;
      case "CreateYacht":
        result = createYacht(split);
        break;
      case "OpenRace":
        result = openRace(split);
        break;
      case "SignUpBoat":
        result = sighUpBoat(split);
        break;
      case "StartRace":
        startRace();
        break;
    }
    if (!result.isEmpty()) {
      System.out.println(result);
    }
  }

  private void startRace() throws NoSetRaceException, InsufficientContestantsException {
    List<BoatResult> top3 = this.appController.startRace();

    printResults("First place", top3.get(0));
    printResults("Second place", top3.get(1));
    printResults("Third place", top3.get(2));
  }

  private void printResults(String title, BoatResult raceResult) {
    DecimalFormat df = new DecimalFormat("#####.##");
    double raceTime = raceResult.getRaceTime();
    System.out.printf("%s: %s Model: %s Time: %s%n",
            title,
            raceResult.getBoat().getClass().getSimpleName(),
            raceResult.getBoat().getModel(),
            raceResult.getRaceTime() <= 0 ? "Did not finish!" : df.format(raceTime) + " sec"
    );
  }

  private String sighUpBoat(String[] split) throws NoSetRaceException, DuplicateModelException, ArgumentException {
    String model = split[1];
    return this.appController.sighUpBoat(model);
  }

  private String openRace(String[] split) throws RaceAlreadyExistsException, ArgumentException {
    double distance = Double.parseDouble(split[1]);
    double windSpeed = Double.parseDouble(split[2]);
    double currentSpeed = Double.parseDouble(split[3]);
    boolean allowMotorBoats = split[4].equals(TRUE_STRING);

    this.appController.openRace(distance, windSpeed, currentSpeed, allowMotorBoats);
    return String.format("A new race with distance %.0f meters, wind speed %.0f m/s " +
                    "and ocean current speed %.0f m/s has been set.",
            distance,
            windSpeed,
            currentSpeed
    );
  }

  private String createYacht(String[] split) throws ArgumentException {
    String model = split[1];
    double weight = Double.parseDouble(split[2]);
    String engine = split[3];
    double cargo = Double.parseDouble(split[4]);

    this.appController.createYacht(model, weight, engine, cargo);
    return String.format("Yacht with model %s registered successfully.", model);

  }

  private String createPowerBoat(String[] split) throws ArgumentException {
    String model = split[1];
    double weight = Double.parseDouble(split[2]);
    String firstEngineModel = split[3];
    String secondEngineModel = split[4];

    this.appController.createPowerBoat(model, weight, firstEngineModel, secondEngineModel);
    return String.format("Power boat with model %s registered successfully.", model);
  }

  private String createSailBoat(String[] split) throws ArgumentException {
    String model = split[1];
    double weight = Double.parseDouble(split[2]);
    int sailEfficiency = Integer.parseInt(split[3]);

    this.appController.createSailBoat(model, weight, sailEfficiency);

    return String.format("Sail boat with model %s registered successfully.", model);
  }

  private String createRowBoat(String[] args) throws ArgumentException {
    String model = args[1];
    double weight = Double.parseDouble(args[2]);
    int oars = Integer.parseInt(args[3]);

    this.appController.createRowBoat(model, weight, oars);
    return String.format("Row boat with model %s registered successfully.", model);
  }

  private String createBoatEngine(String[] split) throws DuplicateModelException, ArgumentException {
    String model = split[1];
    int horsepower = Integer.parseInt(split[2]);
    int displacement = Integer.parseInt(split[3]);
    String type = split[4];

    this.appController.createEngine(model, horsepower, displacement, type);
    return String.format("Engine model %s with %d HP and displacement %d cm3 created successfully.",
            model,
            horsepower,
            displacement);
  }
}