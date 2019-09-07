package exercise.cardSuit;

public enum CardSuits {
  CLUBS, DIAMONDS, HEARTS, SPADES;

  public static String getSuits() {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format("Card Suits:%n"));

    for (CardSuits suit : CardSuits.values()) {
      sb.append(String.format("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name()));
    }

    return sb.toString();
  }
}