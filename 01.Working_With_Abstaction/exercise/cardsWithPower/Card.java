package exercise.cardsWithPower;

public class Card {
  private static final int[] RANK_POWER = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,};
  public static final int[] SUITE_POWER = {0, 13, 29, 39,};
  private CardRank cardRank;
  private CardSuits cardSuits;

  public Card(CardRank cardRank, CardSuits cardSuits) {
    this.cardRank = cardRank;
    this.cardSuits = cardSuits;
  }

  public int calculatePower() {

    return Card.RANK_POWER[this.cardRank.ordinal()] + Card.SUITE_POWER[this.cardSuits.ordinal()];
  }

  @Override
  public String toString() {
    return String.format("Card name: %s of %s; Card power: %d",
            this.cardRank.toString(),
            this.cardSuits.toString(),
            this.calculatePower());
  }
}