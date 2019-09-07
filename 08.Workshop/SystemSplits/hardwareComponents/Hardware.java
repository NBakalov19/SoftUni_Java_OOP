package SystemSplits.hardwareComponents;

import SystemSplits.softwareComponents.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Hardware {
  private String name;
  private String type;
  private int maxCapacity;
  private int maxMemory;
  private Map<String, Software> installedSoftware;
  private int usedCapacity;
  private int usedMemory;


  protected Hardware(String name, String type, int maxCapacity, int maxMemory) {
    this.name = name;
    this.type = type;
    this.setMaxCapacity(maxCapacity);
    this.setMaxMemory(maxMemory);
    this.installedSoftware = new LinkedHashMap<>();
    this.usedCapacity = 0;
    this.usedMemory = 0;
  }

  public String getName() {
    return this.name;
  }

  public String getType() {
    return this.type;
  }

  public int getMaxCapacity() {
    return this.maxCapacity;
  }

  protected void setMaxCapacity(int maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  public int getMaxMemory() {
    return this.maxMemory;
  }

  protected void setMaxMemory(int maxMemory) {
    this.maxMemory = maxMemory;
  }

  public int getUsedCapacity() {
    return this.usedCapacity;
  }

  public int getUsedMemory() {
    return this.usedMemory;
  }

  private boolean hasFreeCapacity(int capacity) {
    return (this.getMaxCapacity() - (this.getUsedCapacity() + capacity)) >= 0;
  }

  private boolean hasFreeMemory(int memory) {
    return (this.getMaxMemory() - (this.getUsedMemory() + memory)) >= 0;
  }


  public void installSoftware(Software software) {
    if (this.hasFreeCapacity(software.getCapacityConsumption())
            && this.hasFreeMemory(software.getMemoryConsumption())) {
      this.installedSoftware.putIfAbsent(software.getName(), software);
      this.usedCapacity += software.getCapacityConsumption();
      this.usedMemory += software.getMemoryConsumption();
    }
  }

  public void releaseSoftware(String softwareName) {
    if (this.installedSoftware.containsKey(softwareName)) {
      Software software = this.installedSoftware.remove(softwareName);
      this.usedCapacity -= software.getCapacityConsumption();
      this.usedMemory -= software.getMemoryConsumption();
    }
  }

  public int getInstalledSoftwareCount() {
    return this.installedSoftware.size();
  }

  public long getExpressSoftwareCount() {
    return this.installedSoftware
            .keySet()
            .stream()
            .filter(k -> this.installedSoftware.get(k).getType().equals("Express"))
            .count();
  }

  public long getLightSoftwareCount() {
    return this.installedSoftware.size() - this.getExpressSoftwareCount();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    String separator = System.lineSeparator();

    sb.append("Hardware Component - ")
            .append(this.getName())
            .append(separator)
            .append("Express Software Components - ").append(this.getExpressSoftwareCount())
            .append(separator)
            .append("Light Software Components - ").append(this.getLightSoftwareCount())
            .append(separator)
            .append("Memory Usage: ").append(this.getUsedMemory()).append(" / ").append(this.getMaxMemory())
            .append(separator)
            .append("Capacity Usage: ").append(this.getUsedCapacity()).append(" / ").append(this.getMaxCapacity())
            .append(separator)
            .append("Type: ")
            .append(this.getType())
            .append(separator)
            .append("Software Components: ");
    String[] values = this.installedSoftware.values()
            .stream()
            .map(Software::getName)
            .toArray(String[]::new);

    if (values.length == 0) {
      sb.append("None");
    } else {
      sb.append(String.join(", ", values));
    }

    return sb.toString();
  }
}