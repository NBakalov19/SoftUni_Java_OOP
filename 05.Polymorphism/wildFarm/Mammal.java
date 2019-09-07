package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
  private String livingRegion;

  protected Mammal(String animalName, Double animalWeight, String livingRegion) {
    super(animalName, animalWeight);
    this.livingRegion = livingRegion;
  }

  public String getLivingRegion() {
    return this.livingRegion;
  }

  @Override
  public void eat(Food food) {
    String animalType = this.getClass().getSimpleName().equals("Mouse") ? "Mice" : "Zebras";
    if (food.getClass().getSimpleName().equals("Vegetable")) {
      setFoodEaten(food.getQuantity());
    } else {
      throw new IllegalArgumentException(
              String.format("%s are not eating that type of food!", animalType));
    }
  }

  @Override
  public String toString() {

    DecimalFormat df = new DecimalFormat("#.##");

    return String.format("%s[%s, %s, %s, %d]",
            getClass().getSimpleName(),
            getAnimalName(),
            df.format(getAnimalWeight()),
            getLivingRegion(),
            getFoodEaten()
    );
  }
}