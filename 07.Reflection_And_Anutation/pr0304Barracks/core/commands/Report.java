package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Inject;
import pr0304Barracks.contracts.Repository;

public class Report extends CommandImpl {
  @Inject
  private Repository repository;

  public Report(String[] data) {
    super(data);
  }

  @Override
  public String execute() {
    return this.repository.getStatistics();
  }
}
