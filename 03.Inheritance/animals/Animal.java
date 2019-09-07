package animals;

public class Animal {
  private String name;
  private int age;
  protected String gender;

  public Animal(String name, int age, String gender) {
    this.setName(name);
    this.setAge(age);
    this.setGender(gender);
  }

  private void setName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Invalid input!");
    }
    this.name = name;
  }

  private void setAge(int age) {
    if (age < 1) {
      throw new IllegalArgumentException("Invalid input!");
    }
    this.age = age;
  }

  protected void setGender(String gender) {
    if (gender == null || gender.trim().isEmpty()) {
      throw new IllegalArgumentException("Invalid input!");
    }
    this.gender = gender;
  }

  private String getName() {
    return name;
  }

  private int getAge() {
    return age;
  }

  private String getGender() {
    return gender;
  }

  protected String produceSound() {
    return "Not implemented!";
  }

  @Override
  public String toString() {
    return String.format("%s%n" +
                    "%s %d %s%n" +
                    "%s",
            getClass().getSimpleName(),
            getName(), getAge(), getGender(),
            produceSound());
  }
}