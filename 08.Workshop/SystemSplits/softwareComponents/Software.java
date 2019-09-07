package SystemSplits.softwareComponents;

public abstract class Software {

  private String name;
  private String type;
  private int capacityConsumption;
  private int memoryConsumption;

  protected Software(String name, String type, int capacityConsumption, int memoryConsumption) {
    this.name = name;
    this.type = type;
    this.setCapacityConsumption(capacityConsumption);
    this.setMemoryConsumption(memoryConsumption);
  }

  public String getName() {
    return this.name;
  }

  public String getType() {
    return this.type;
  }

  public int getCapacityConsumption() {
    return this.capacityConsumption;
  }

  protected void setCapacityConsumption(int capacityConsumption) {
    this.capacityConsumption = capacityConsumption;
  }

  public int getMemoryConsumption() {
    return this.memoryConsumption;
  }

  protected void setMemoryConsumption(int memoryConsumption) {
    this.memoryConsumption = memoryConsumption;
  }
}
