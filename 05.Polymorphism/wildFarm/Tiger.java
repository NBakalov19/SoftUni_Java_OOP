package wildFarm;

public class Tiger extends Felime {
  public Tiger(String animalName, Double animalWeight, String livingRegion) {
    super(animalName, animalWeight, livingRegion);
  }

  @Override
  public String makeSound() {
    return "ROAAR!!!";
  }

  @Override
  public void eat(Food food) {
    if (food.getClass().getSimpleName().equals("Meat")) {
      super.eat(food);
    } else {
      throw new IllegalArgumentException("Tigers are not eating that type of food!");
    }
  }
}
