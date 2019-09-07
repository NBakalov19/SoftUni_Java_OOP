package firstAndReserveTeam;

public class Person {
  private String firstName;
  private String lastName;
  private int age;
  private double salary;

  public Person(String firstName, String lastName, int age, double salary) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setAge(age);
    this.setSalary(salary);

  }

  public void setFirstName(String firstName) {
    if (firstName.length() < 3) {
      throw new IllegalArgumentException("First name cannot be less than 3 symbols");
    }
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    if (lastName.length() < 3) {
      throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
    }
    this.lastName = lastName;
  }

  public void setAge(int age) {
    if (age < 1) {
      throw new IllegalArgumentException("Age must not be zero or negative");
    }
    this.age = age;
  }

  public void setSalary(double salary) {
    if (salary < 460) {
      throw new IllegalArgumentException("Salary can't be less than 460.0");
    }
    this.salary = salary;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public int getAge() {
    return this.age;
  }

  public double getSalary() {
    return this.salary;
  }

  public void increaseSalary(double bonus) {
    if (this.getAge() > 30) {
      this.salary += this.salary * bonus / 100;
    } else {
      this.salary += this.salary * bonus / 200;
    }
  }

  @Override
  public String toString() {
    return String.format("%s %s gets %f leva", this.getFirstName(), this.getLastName(), this.getSalary());

  }
}