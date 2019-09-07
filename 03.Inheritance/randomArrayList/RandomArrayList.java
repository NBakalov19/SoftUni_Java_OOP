package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

  private Random rnd;

  public RandomArrayList() {
    super();
    this.rnd = new Random();
  }

  public Object getRandomElement() {
    int index = this.rnd.nextInt(super.size());
    Object element = super.get(index);
    super.remove(index);
    return element;
  }
}
