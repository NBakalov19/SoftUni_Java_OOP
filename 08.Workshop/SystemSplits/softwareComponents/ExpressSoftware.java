package SystemSplits.softwareComponents;

public class ExpressSoftware extends Software {

  public static final String TYPE = "Express";

  public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
    super(name, TYPE, capacityConsumption, memoryConsumption);
  }

  @Override
  protected void setMemoryConsumption(int memoryConsumption) {
    super.setMemoryConsumption(memoryConsumption * 2);
  }
}