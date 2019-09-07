package pizzaCalories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
  private String name;
  private Dough dough;
  private List<Topping> toppings;

  public Pizza(String name, int countOfToppings) {
    this.setName(name);
    this.setToppings(countOfToppings);
    this.toppings = new ArrayList<>();
  }

  public void setName(String name) {
    if (name == null || name.trim().isEmpty() || name.length() > 15) {
      throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
    }
    this.name = name;
  }

  public void setDough(Dough dough) {
    this.dough = dough;
  }

  private void setToppings(int countOfToppings) {
    if (countOfToppings < 0 || countOfToppings > 10) {
      throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
    }
  }

  public void addTopping(Topping topping) {
    this.toppings.add(topping);
  }

  public String getName() {
    return this.name;
  }

  public Dough getDough() {
    return this.dough;
  }

  public List<Topping> getToppings() {
    return Collections.unmodifiableList(this.toppings);
  }

  public double getOverallCalories() {
    double toppingsCalories = this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    double doughCalories = getDough().calculateCalories();
    return toppingsCalories + doughCalories;
  }

  @Override
  public String toString() {
    return String.format("%s - %.2f", getName(), getOverallCalories());
  }
}
