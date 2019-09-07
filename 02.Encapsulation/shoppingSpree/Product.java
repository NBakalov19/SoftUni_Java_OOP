package shoppingSpree;

public class Product {
  private String name;
  private double cost;

  public Product(String name, double cost) {
    this.setName(name);
    this.setCost(cost);
  }

  private void setName(String name) {
    if (name == null || name.trim().length() == 0) {
      throw new IllegalArgumentException("Not a valid product name.");
    }
    this.name = name;
  }

  private void setCost(double cost) {
    if (cost < 0) {
      throw new IllegalArgumentException("Product cannot have negative price.");
    }
    this.cost = cost;
  }

  public String getName() {
    return this.name;
  }

  public double getCost() {
    return this.cost;
  }

  @Override
  public String toString() {
    return getName();
  }
}
