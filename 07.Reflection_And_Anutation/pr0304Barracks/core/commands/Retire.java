package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Inject;
import pr0304Barracks.contracts.Repository;

public class Retire extends CommandImpl {
  @Inject
  private Repository repository;

  public Retire(String[] data) {
    super(data);
  }

  @Override
  public String execute() {
    String result;
    try {
      this.repository.removeUnit(this.getData()[1]);
      result = this.getData()[1] + " retired!";
    } catch (IllegalArgumentException ex) {
      result = ex.getMessage();
    }
    return result;
  }
}
