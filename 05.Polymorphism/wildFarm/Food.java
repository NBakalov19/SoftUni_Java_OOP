package wildFarm;

public abstract class Food {
  private int quantity;

  protected Food(int quantity) {
    this.quantity = quantity;
  }

  protected Integer getQuantity() {
    return this.quantity;
  }
}