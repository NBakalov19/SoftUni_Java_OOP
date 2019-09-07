package SystemSplits.core;

import SystemSplits.hardwareComponents.Hardware;
import SystemSplits.softwareComponents.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class TheSystem {

  private Map<String, Hardware> hardwareComponents;
  private TheDump dump;

  public TheSystem(TheDump dump) {
    this.hardwareComponents = new LinkedHashMap<>();
    this.dump = dump;
  }

  public void addHardware(Hardware hardware) {
    this.hardwareComponents.putIfAbsent(hardware.getName(), hardware);
  }

  public void addSoftwareComponent(String hardwareName, Software software) {
    if (this.hardwareComponents.containsKey(hardwareName)) {
      this.hardwareComponents.get(hardwareName).installSoftware(software);
    }
  }

  public void releaseSoftwareComponent(String hardwareName, String softwareName) {
    if (this.hardwareComponents.containsKey(hardwareName)) {
      this.hardwareComponents.get(hardwareName).releaseSoftware(softwareName);
    }
  }

  public String analyze() {
    StringBuilder sb = new StringBuilder();
    String separator = System.lineSeparator();

    int softwareComponentsCount = 0;
    int totalOperationalMemoryInUse = 0;
    int maxMemory = 0;
    int totalCapacityTaken = 0;
    int maxCapacity = 0;

    for (String hardwareName : hardwareComponents.keySet()) {
      softwareComponentsCount += this.hardwareComponents.get(hardwareName).getInstalledSoftwareCount();
      totalOperationalMemoryInUse += this.hardwareComponents.get(hardwareName).getUsedMemory();
      maxMemory += this.hardwareComponents.get(hardwareName).getMaxMemory();
      totalCapacityTaken += this.hardwareComponents.get(hardwareName).getUsedCapacity();
      maxCapacity += this.hardwareComponents.get(hardwareName).getMaxCapacity();
    }

    sb.append("System Analysis").append(separator);
    sb.append("Hardware Components: ").append(this.hardwareComponents.size()).append(separator);
    sb.append("Software Components: ").append(softwareComponentsCount).append(separator);
    sb.append("Total Operational Memory: ")
            .append(totalOperationalMemoryInUse)
            .append(" / ")
            .append(maxMemory).append(separator);
    sb.append("Total Capacity Taken: ")
            .append(totalCapacityTaken)
            .append(" / ")
            .append(maxCapacity);

    return sb.toString();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    String separator = System.lineSeparator();

    this.hardwareComponents.entrySet()
            .stream()
            .filter(e -> e.getValue().getType().equals("Power"))
            .forEach(e -> sb.append(e.getValue().toString())
                    .append(separator));

    this.hardwareComponents.entrySet()
            .stream()
            .filter(e -> e.getValue().getType().equals("Heavy"))
            .forEach(e -> sb.append(e.getValue().toString())
                    .append(separator));

    return sb.toString();
  }

  public void dumpHardware(String hardwareName) {
    if (this.hardwareComponents.containsKey(hardwareName)) {
      Hardware hardware = this.hardwareComponents.remove(hardwareName);
      this.dump.addDumpedHardware(hardware);
    }
  }

  public void restoreDumpedHardware(String hardwareName) {
    Hardware hardware = this.dump.restoreHardware(hardwareName);
    if (hardware != null) {
      this.addHardware(hardware);
    }
  }

  public void destroyDumpedHardware(String hardwareName) {
    this.dump.destroy(hardwareName);
  }

  public String getDumpAnalyze() {
    return this.dump.analyze();
  }
}