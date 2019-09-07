package pizzaCalories;

import java.util.Arrays;
import java.util.List;

public class Topping {
  private static final List<String> VALID_TOPPINGS = Arrays.asList("Meat", "Veggies", "Cheese", "Sauce");
  private String toppingType;
  private double weight;

  public Topping(String toppingType, double weight) {
    this.setToppingType(toppingType);
    this.setWeight(weight);
  }


  public void setToppingType(String toppingType) {
    if (!VALID_TOPPINGS.contains(toppingType)) {
      throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
    }
    this.toppingType = toppingType;
  }

  public void setWeight(double weight) {
    if (weight < 1 || weight > 50) {
      throw new IllegalArgumentException(
              String.format("%s weight should be in the range [1..50].", this.toppingType));
    }
    this.weight = weight;
  }

  public String getToppingType() {
    return this.toppingType;
  }

  public double getWeight() {
    return this.weight;
  }

  private double getModifier(String modifier) {
    double result = 0d;
    switch (modifier) {
      case "Meat":
        result = 1.2;
        break;
      case "Veggies":
        result = 0.8;
        break;
      case "Cheese":
        result = 1.1;
        break;
      default:
        result = 0.9;
        break;
    }
    return result;
  }

  public double calculateCalories() {
    return (2 * getWeight()) * getModifier(getToppingType());
  }
}