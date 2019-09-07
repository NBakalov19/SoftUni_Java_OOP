package mordorPlan;

import java.util.HashMap;
import java.util.Map;

public class Gandalf {
  private int foodPoint;
  public static final Map<String, Food> FOOD_MAP = new HashMap<>() {
    {
      put("apple", new Apple(1));
      put("melon", new Melon(1));
      put("cram", new Cram(2));
      put("lembas", new Lembas(3));
      put("honeycake", new HoneyCake(5));
      put("mushrooms", new Mushrooms(-10));
    }
  };


  public Gandalf() {
  }

  public void eatFood(String food) {
    try {
      this.foodPoint += Integer.parseInt(food);
    } catch (Exception ex) {
      if (Gandalf.FOOD_MAP.containsKey(food.toLowerCase())) {
        this.foodPoint += Gandalf.FOOD_MAP.get(food.toLowerCase()).getHappinessPoints();
      } else {
        this.foodPoint -= 1;
      }
    }
  }

  public int getFoodPoints() {
    return this.foodPoint;
  }

  public String getMood() {
    String mood;
    if (this.getFoodPoints() < -5) {
      mood = "Angry";
    } else if (this.getFoodPoints() < 0) {
      mood = "Sad";
    } else if (this.getFoodPoints() <= 15) {
      mood = "Happy";
    } else {
      mood = "JavaScript";
    }
    return mood;
  }
}