package pr0304Barracks.core.commands;

public class Fight extends CommandImpl {
  public Fight(String[] data) {
    super(data);
  }

  @Override
  public String execute() {
    return "fight";
  }
}
