package colectionHierarchy;

import colectionHierarchy.interfaces.AddRemovable;
import colectionHierarchy.interfaces.Addable;
import colectionHierarchy.models.AddCollection;
import colectionHierarchy.models.AddRemoveCollection;
import colectionHierarchy.models.MyListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] insertStrings = reader.readLine().split("\\s+");

    AddCollection addCollection = new AddCollection();
    AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
    MyListImpl myList = new MyListImpl();

    insertInto(addCollection, insertStrings).forEach(Main::printAddResult);
    System.out.println();
    insertInto(addRemoveCollection, insertStrings).forEach(Main::printAddResult);
    System.out.println();
    insertInto(myList, insertStrings).forEach(Main::printAddResult);
    System.out.println();

    int removeCount = Integer.parseInt(reader.readLine());

    String[] results = removeTimes(addRemoveCollection, removeCount);
    printResult(results);
    results = removeTimes(myList, removeCount);
    printResult(results);

  }

  private static void printResult(String[] results) {
    for (String result : results) {
      System.out.print(result + " ");
    }
    System.out.println();
  }

  private static String[] removeTimes(AddRemovable collection, int removeCount) {
    String[] result = new String[removeCount];
    for (int i = 0; i < removeCount; i++) {
      result[i] = collection.remove();
    }
    return result;
  }

  private static void printAddResult(Integer result) {
    System.out.print(result + " ");
  }

  private static Stream<Integer> insertInto(Addable collection, String[] items) {
    return Arrays.stream(items).map(collection::add);
  }

}