package wildFarm;

public class Mouse extends Mammal {
  protected Mouse(String animalName, Double animalWeight, String livingRegion) {
    super(animalName, animalWeight, livingRegion);
  }

  @Override
  public String makeSound() {
    return "SQUEEEAAAK!";
  }

}