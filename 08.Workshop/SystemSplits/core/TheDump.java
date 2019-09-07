package SystemSplits.core;

import SystemSplits.hardwareComponents.Hardware;

import java.util.LinkedHashMap;
import java.util.Map;

public class TheDump {
  private Map<String, Hardware> dumpedHardware;

  public TheDump() {
    this.dumpedHardware = new LinkedHashMap<>();
  }


  public void addDumpedHardware(Hardware hardware) {
    this.dumpedHardware.putIfAbsent(hardware.getName(), hardware);
  }

  public Hardware restoreHardware(String hardwareName) {
    Hardware hardware;
    if (this.dumpedHardware.containsKey(hardwareName)) {
      hardware = this.dumpedHardware.remove(hardwareName);
    } else {
      hardware = null;
    }
    return hardware;
  }

  public void destroy(String hardwareName) {
    this.dumpedHardware.remove(hardwareName);
  }

  private int getHardwareComponentsCountByType(String type) {
    int hardwareComponentCount = 0;
    for (Hardware hardware : dumpedHardware.values()) {
      if (hardware.getType().equals(type)) {
        hardwareComponentCount += 1;
      }
    }
    return hardwareComponentCount;
  }


  private long getExpressSoftwareComponents() {
    return this.dumpedHardware
            .values()
            .stream()
            .mapToLong(Hardware::getExpressSoftwareCount)
            .sum();
  }

  private long getLightSoftwareComponents() {
    return this.dumpedHardware
            .values()
            .stream()
            .mapToLong(Hardware::getLightSoftwareCount)
            .sum();
  }

  private int getDumpedMemory() {
    return this.dumpedHardware.values()
            .stream()
            .mapToInt(Hardware::getUsedMemory)
            .sum();
  }

  private int getDumpedCapacity() {
    return this.dumpedHardware.values()
            .stream()
            .mapToInt(Hardware::getUsedCapacity)
            .sum();
  }

  public String analyze() {
    StringBuilder sb = new StringBuilder();
    String separator = System.lineSeparator();

    sb.append("Dump Analysis")
            .append(separator)
            .append("Power Hardware Components: ").append(this.getHardwareComponentsCountByType("Power"))
            .append(separator)
            .append("Heavy Hardware Components: ").append(this.getHardwareComponentsCountByType("Heavy"))
            .append(separator)
            .append("Express Software Components: ").append(this.getExpressSoftwareComponents())
            .append(separator)
            .append("Light Software Components: ").append(this.getLightSoftwareComponents())
            .append(separator)
            .append("Total Dumped Memory: ").append(this.getDumpedMemory())
            .append(separator)
            .append("Total Dumped Capacity: ").append(this.getDumpedCapacity());


    return sb.toString();
  }
}
