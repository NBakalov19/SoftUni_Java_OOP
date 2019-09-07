package militaryElite.common;


import militaryElite.Interfaces.Mission;
import militaryElite.enumerations.State;

public class MissionImpl implements Mission {
  private String codeName;
  private State state;

  public MissionImpl(String codeName, State state) {
    this.codeName = codeName;
    this.state = state;
  }


  @Override
  public String toString() {
    return String.format("Code Name: %s State: %s", this.codeName, this.state);
  }
}
