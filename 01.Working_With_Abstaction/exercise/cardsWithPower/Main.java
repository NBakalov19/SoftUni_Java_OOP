package exercise.cardsWithPower;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String rank = scanner.nextLine();
    String suite = scanner.nextLine();

    Card card = new Card(CardRank.valueOf(rank), CardSuits.valueOf(suite));

    System.out.println(card.toString());
  }
}