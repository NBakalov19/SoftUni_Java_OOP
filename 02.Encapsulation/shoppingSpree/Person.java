package shoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
  private String name;
  private double money;
  private List<Product> products;

  public Person(String name, double money) {
    this.setName(name);
    this.setMoney(money);
    this.products = new ArrayList<>();
  }

  public void setName(String name) {
    if (name == null || name.trim().length() == 0) {
      throw new IllegalArgumentException("Name cannot be empty");
    }
    this.name = name;
  }

  public void setMoney(double money) {
    if (money < 0) {
      throw new IllegalArgumentException("Money cannot be negative");
    }
    this.money = money;
  }

  public String getName() {
    return this.name;
  }

  private List<Product> getProducts() {
    return Collections.unmodifiableList(this.products);
  }

  public void buyProduct(Product product) {
    if (this.money >= product.getCost()) {
      this.products.add(product);
      double moneyLeft = this.money - product.getCost();
      this.setMoney(moneyLeft);
      System.out.printf("%s bought %s%n", getName(), product.getName());
    } else {
      System.out.println(String.format("%s can't afford %s", getName(), product.getName()));
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getName()).append(" - ");
    if (getProducts().size() > 0) {
      sb.append(getProducts().stream()
              .map(Product::toString)
              .collect(Collectors.joining(", ")));
    } else {
      sb.append("Nothing bought");
    }
    return sb.toString();
  }
}