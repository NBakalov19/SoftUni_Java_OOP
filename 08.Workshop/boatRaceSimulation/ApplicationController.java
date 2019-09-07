package boatRaceSimulation;

import boatRaceSimulation.exceptions.*;
import boatRaceSimulation.models.boatEngines.BoatEngine;
import boatRaceSimulation.models.boatEngines.JetEngine;
import boatRaceSimulation.models.boatEngines.SterndriveEngine;
import boatRaceSimulation.models.boats.*;
import boatRaceSimulation.race.Race;
import boatRaceSimulation.repository.BoatRepository;
import boatRaceSimulation.repository.EngineRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationController {
  private static final String JET_ENGINE = "Jet";
  private EngineRepository engineRepository;
  private BoatRepository boatRepository;
  private Race currentRace;

  public ApplicationController() {
    this.engineRepository = new EngineRepository();
    this.boatRepository = new BoatRepository();
    this.currentRace = null;
  }

  public void createEngine(String model,
                           int horsepower,
                           int displacement,
                           String type) throws DuplicateModelException, ArgumentException {
    BoatEngine engine;

    if (type.equals(JET_ENGINE)) {
      engine = new JetEngine(model, horsepower, displacement);
    } else {
      engine = new SterndriveEngine(model, horsepower, displacement);
    }

    boolean saveResult = this.engineRepository.save(engine);

    if (!saveResult) {
      throw new DuplicateModelException();
    }
  }

  public void createRowBoat(String model, double weight, int oars) throws ArgumentException {
    Boat boat = new RowBoat(model, weight, oars);
    this.boatRepository.save(boat);
  }


  public void createSailBoat(String model, double weight, int sailEfficiency) throws ArgumentException {
    Boat sailBoat = new SailBoat(model, weight, sailEfficiency);
    this.boatRepository.save(sailBoat);
  }

  public void createPowerBoat(
          String model, double weight, String firstEngineModel, String secondEngineModel) throws ArgumentException {
    BoatEngine firstEngine = this.engineRepository.getByModel(firstEngineModel);
    BoatEngine secondEngine = this.engineRepository.getByModel(secondEngineModel);

    Boat powerBoat = new PowerBoat(model, weight, firstEngine, secondEngine);
    this.boatRepository.save(powerBoat);
  }

  public void createYacht(String model, double weight, String engine, double cargo) throws ArgumentException {
    BoatEngine boatEngine = this.engineRepository.getByModel(engine);

    Boat yacht = new Yacht(model, weight, boatEngine, cargo);
    this.boatRepository.save(yacht);
  }

  public void openRace(double distance,
                       double windSpeed,
                       double currentSpeed,
                       boolean allowMotorBoats) throws RaceAlreadyExistsException, ArgumentException {
    if (this.currentRace != null) {
      throw new RaceAlreadyExistsException("The current race has already been set.");
    }

    this.currentRace = new Race(distance, windSpeed, currentSpeed, allowMotorBoats);

  }

  public String sighUpBoat(String model) throws NoSetRaceException, DuplicateModelException, ArgumentException {
    if (this.currentRace == null) {
      throw new NoSetRaceException("There is currently no race set.");
    }
    Boat participant = this.boatRepository.getByModel(model);
    this.currentRace.addParticipants(participant);

    return String.format("Boat with model %s has signed up for the current Race.", model);
  }

  public List<BoatResult> startRace() throws NoSetRaceException, InsufficientContestantsException {
    if (this.currentRace == null) {
      throw new NoSetRaceException("There is currently no race set.");
    }
    if (!this.currentRace.enoughParticipants()) {
      throw new InsufficientContestantsException("Not enough contestants for the race.");
    }

    return this.currentRace.getParticipants()
            .stream()
            .sorted(
                    (f, s) -> Double.compare(
                            s.getSpeed(this.currentRace.getConditions()),
                            f.getSpeed(this.currentRace.getConditions()))
            )
            .limit(3)
            .map(b -> {
                      double speed = b.getSpeed(this.currentRace.getConditions());
                      double time = this.currentRace.getDistance() / speed;

                      return new BoatResult(b, time);
                    }
            )
            .collect(Collectors.toList());
  }
}