package exercise.cardRank;

public enum CardRank {
  ACE,
  TWO,
  THREE,
  FOUR,
  FIVE,
  SIX,
  SEVEN,
  EIGHT,
  NINE,
  TEN,
  JACK,
  QUEEN,
  KING;

  public static String getCardRanks() {
    StringBuilder result = new StringBuilder();
    for (CardRank cardRank : CardRank.values()) {
      result.append(String.format("Ordinal value: %d; Name value: %s%n",
              cardRank.ordinal(), cardRank.name()));
    }
    return result.toString();
  }
}