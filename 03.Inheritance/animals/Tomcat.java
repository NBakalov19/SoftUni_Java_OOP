package animals;

public class Tomcat extends Cat {
  public Tomcat(String name, int age, String gender) {
    super(name, age, gender);
  }

  @Override
  protected void setGender(String gender) {
    if (gender == null || gender.trim().isEmpty() || gender.equalsIgnoreCase("female")) {
      throw new IllegalArgumentException("Invalid input!");
    }
    this.gender = gender;
  }

  @Override
  protected String produceSound() {
    return "Give me one million b***h";
  }

  @Override
  public String toString() {
    return super.toString();
  }
}