package lab.rhombusOfStars;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = Integer.parseInt(scanner.nextLine());

    for (int startCount = 1; startCount <= size; startCount++) {
      printRow(size, startCount);
    }

    for (int starCount = size - 1; starCount >= 1; starCount--) {
      printRow(size, starCount);
    }
  }

  private static void printRow(int rhombusSize, int starCount) {

    for (int i = 0; i < rhombusSize - starCount; i++) {
      System.out.print(" ");
    }

    for (int i = 1; i < starCount; i++) {
      System.out.print("* ");
    }

    System.out.println("*");
  }
}