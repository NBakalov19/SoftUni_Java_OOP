package colectionHierarchy.models;

import colectionHierarchy.interfaces.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {
  public AddRemoveCollection() {
    super();
  }

  @Override
  public String remove() {
    return this.removeLast();
  }

  @Override
  public int add(String item) {
    return this.addFirst(item);
  }
}
