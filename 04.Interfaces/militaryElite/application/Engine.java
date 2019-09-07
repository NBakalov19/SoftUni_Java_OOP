package militaryElite.application;


import militaryElite.inputOutput.InputReader;
import militaryElite.inputOutput.OutputWriter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Engine {
  public static void run() throws IOException {
    InputReader inputReader = new InputReader(new InputStreamReader(System.in), "End");
    CommandParser commandParser = new CommandParser(inputReader.readAllLines());
    Army army = commandParser.parseCommandsAndGetArmy();
    OutputWriter outputWriter = new OutputWriter(new OutputStreamWriter(System.out));
    outputWriter.writeAll(army);
  }
}
