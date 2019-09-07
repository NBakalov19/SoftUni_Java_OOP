package wildFarm;

public class Zebra extends Mammal {
  public Zebra(String animalName, Double animalWeight, String livingRegion) {
    super(animalName, animalWeight, livingRegion);
  }

  @Override
  public String makeSound() {
    return "Zs";
  }

}