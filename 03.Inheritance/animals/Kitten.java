package animals;

public class Kitten extends Cat {
  public Kitten(String name, int age, String gender) {
    super(name, age, gender);
  }

  @Override
  public void setGender(String gender) {
    if (gender == null || gender.trim().isEmpty() || gender.equalsIgnoreCase("male")) {
      throw new IllegalArgumentException("Invalid input!");
    }
    this.gender = gender;
  }

  @Override
  protected String produceSound() {
    return "Miau";
  }

  @Override
  public String toString() {
    return super.toString();
  }
}