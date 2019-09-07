package exercise.cardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("Card Suits")){
            System.out.println(CardSuits.getSuits());
        }
    }
}
