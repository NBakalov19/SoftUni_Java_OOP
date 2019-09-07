package exercise.cardRank;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    if (input.equals("Card Ranks")) {
      System.out.println("Card Ranks:");
      System.out.print(CardRank.getCardRanks());
    }
  }
}