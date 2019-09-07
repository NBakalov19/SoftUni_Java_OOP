package exercise.cardsWithPower;

public enum CardSuits {
  CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

  private int value;

  CardSuits(int value) {
    this.value = value;
  }

  public int getPowerOfSuits() {
    return value;
  }
}