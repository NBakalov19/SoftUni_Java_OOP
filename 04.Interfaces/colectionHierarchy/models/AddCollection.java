package colectionHierarchy.models;

import colectionHierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {

  public AddCollection() {
    super();
  }

  @Override
  public int add(String item) {
    return this.addLast(item);
  }
}
