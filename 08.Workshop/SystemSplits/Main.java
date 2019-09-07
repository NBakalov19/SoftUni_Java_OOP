package SystemSplits;

import SystemSplits.core.Engine;
import SystemSplits.core.TheDump;
import SystemSplits.core.TheSystem;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    TheDump theDump = new TheDump();
    TheSystem system = new TheSystem(theDump);
    Engine engine = new Engine(system);
    engine.run();
  }
}