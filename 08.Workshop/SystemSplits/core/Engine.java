package SystemSplits.core;

import SystemSplits.hardwareComponents.HeavyHardware;
import SystemSplits.hardwareComponents.PowerHardware;
import SystemSplits.softwareComponents.ExpressSoftware;
import SystemSplits.softwareComponents.LightSoftware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

  private TheSystem system;

  public Engine(TheSystem system) {
    this.system = system;
  }

  public void run() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String input = reader.readLine();

    while (!input.equals("System Split")) {

      String command = input.substring(0, input.indexOf('('));
      String[] commandArguments = input.substring(input.indexOf('(') + 1, input.length() - 1).split(", ");

      switch (command) {
        case "RegisterPowerHardware":

          this.system.addHardware(new PowerHardware(
                  commandArguments[0],
                  Integer.parseInt(commandArguments[1]),
                  Integer.parseInt(commandArguments[2])
          ));
          break;
        case "RegisterHeavyHardware":

          this.system.addHardware(new HeavyHardware(
                  commandArguments[0],
                  Integer.parseInt(commandArguments[1]),
                  Integer.parseInt(commandArguments[2])));
          break;
        case "RegisterExpressSoftware":
          this.system.addSoftwareComponent(
                  commandArguments[0],
                  new ExpressSoftware(
                          commandArguments[1],
                          Integer.parseInt(commandArguments[2]),
                          Integer.parseInt(commandArguments[3])
                  )
          );
          break;
        case "RegisterLightSoftware":
          this.system.addSoftwareComponent(
                  commandArguments[0],
                  new LightSoftware(
                          commandArguments[1],
                          Integer.parseInt(commandArguments[2]),
                          Integer.parseInt(commandArguments[3])
                  )
          );
          break;

        case "ReleaseSoftwareComponent":
          this.system.releaseSoftwareComponent(
                  commandArguments[0],
                  commandArguments[1]);
          break;

        case "Analyze":
          System.out.println(this.system.analyze());
          break;

        case "Dump":
          this.system.dumpHardware(commandArguments[0]);
          break;

        case "Restore":
          this.system.restoreDumpedHardware(commandArguments[0]);
          break;

        case "Destroy":
          this.system.destroyDumpedHardware(commandArguments[0]);
          break;

        case "DumpAnalyze":
          System.out.println(this.system.getDumpAnalyze());
          break;
      }

      input = reader.readLine();
    }
    System.out.println(this.system.toString());
  }
}