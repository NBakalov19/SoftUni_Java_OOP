package randomArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List randomArrayList = new RandomArrayList();

    randomArrayList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));

    System.out.println(((RandomArrayList) randomArrayList).getRandomElement());
  }
}