package militaryElite.models;

import militaryElite.Interfaces.SpecialisedSoldier;
import militaryElite.enumerations.Corp;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
  private Corp corps;

  public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corp corps) {
    super(id, firstName, lastName, salary);
    this.corps = corps;
  }


  @Override
  public String toString() {
    return super.toString() + System.lineSeparator() + "Corps: " + this.corps.toString();
  }
}
