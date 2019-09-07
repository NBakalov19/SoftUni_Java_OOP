package wildFarm;

public abstract class Felime extends Mammal {
  protected Felime(String animalName, Double animalWeight, String livingRegion) {
    super(animalName, animalWeight, livingRegion);
  }

  @Override
  public void eat(Food food) {
    super.setFoodEaten(food.getQuantity());
  }
}
