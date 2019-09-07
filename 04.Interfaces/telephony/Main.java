package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<String> numbers = Arrays.stream(reader.readLine().split("\\s+"))
            .collect(Collectors.toCollection(ArrayList::new));
    ArrayList<String> urls = Arrays.stream(reader.readLine().split("\\s+"))
            .collect(Collectors.toCollection(ArrayList::new));

    Smartphone smartphone = new Smartphone(numbers, urls);

    System.out.println(smartphone.call());
    System.out.println(smartphone.browse());
  }
}