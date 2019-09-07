package boatRaceSimulation;


import boatRaceSimulation.exceptions.*;

import java.util.Scanner;

public class Executor {
  private static final String END_COMMAND = "End";
  private final Scanner scanner;
  private final CommandHandler commandHandler;

  public Executor() {
    this.scanner = new Scanner(System.in);
    this.commandHandler = new CommandHandler();
  }

  public void execute() {
    String line = this.scanner.nextLine();

    while (!line.equalsIgnoreCase(END_COMMAND)) {
      try {
        this.commandHandler.handle(line.split("\\\\"));
      } catch (ArgumentException
              | RaceAlreadyExistsException
              | InsufficientContestantsException
              | NoSetRaceException | DuplicateModelException e) {
        System.out.println(e.getMessage());
      }
      line = this.scanner.nextLine();
    }
  }
}