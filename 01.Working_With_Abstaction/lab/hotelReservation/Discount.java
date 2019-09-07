package lab.hotelReservation;

public enum Discount {
  Regular(0),
  Loyal(10),
  VIP(20);

  private int value;

  Discount(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
