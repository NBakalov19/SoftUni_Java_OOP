package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String input = reader.readLine();

    Field[] fields = RichSoilLand.class.getDeclaredFields();
    Consumer<Field> printer = f -> System.out.println(String.format("%s %s %s",
            Modifier.toString(f.getModifiers()),
            f.getType().getSimpleName(),
            f.getName()
    ));

    while (!input.equalsIgnoreCase("harvest")) {

      if (input.equalsIgnoreCase("all")) {
        Arrays.stream(fields).forEach(printer);
      } else {
        String finalInput = input;
        Arrays.stream(fields)
                .filter(f ->
                        Modifier.toString(f.getModifiers()).equalsIgnoreCase(finalInput)
                ).forEach(printer);
      }
      input = reader.readLine();
    }
  }
}