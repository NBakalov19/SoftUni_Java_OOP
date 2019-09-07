package wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
  private String breed;

  public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
    super(animalName, animalWeight, livingRegion);
    this.breed = breed;
  }

  public String getBreed() {
    return this.breed;
  }

  @Override
  public String makeSound() {
    return "Meowwww";
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("#.##");

    return String.format("%s[%s, %s, %s, %s, %d]",
            getClass().getSimpleName(),
            getAnimalName(),
            getBreed(),
            df.format(getAnimalWeight()),
            getLivingRegion(),
            getFoodEaten()
    );
  }
}
