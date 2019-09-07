package animals;

public class Cat extends Animal {
  public Cat(String name, int age, String gender) {
    super(name, age, gender);
  }

  @Override
  protected String produceSound() {
    return "MiauMiau";
  }

  @Override
  public String toString() {
    return super.toString();
  }
}