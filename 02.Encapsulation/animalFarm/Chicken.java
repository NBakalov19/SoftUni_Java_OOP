package animalFarm;

public class Chicken {
  private String name;
  private int age;

  public Chicken(String name, int age) {
    this.setName(name);
    this.setAge(age);
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  private void setName(String name) {
    if (name.length() < 1 || name.equals(" ")) {
      throw new IllegalArgumentException("Name cannot be empty");
    }
    this.name = name;
  }

  private void setAge(int age) {
    if (age < 0 || age > 15) {
      throw new IllegalArgumentException("Age should be between 0 and 15.");
    }
    this.age = age;
  }

  public double productPerDay() {
    return this.calculateProductPerDay();
  }

  private double calculateProductPerDay() {
    double eggs;
    if (this.age < 6) {
      eggs = 2;
    } else if (this.age < 12) {
      eggs = 1;
    } else {
      eggs = 0.75;
    }
    return eggs;
  }

  @Override
  public String toString() {
    return String.format("Chicken %s (age %d) can produce %f eggs per day.", getName(), getAge(), productPerDay());
  }
}