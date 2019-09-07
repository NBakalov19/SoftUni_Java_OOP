package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
  private List<String> numbers;
  private List<String> urls;

  public Smartphone(List<String> numbers, List<String> urls) {
    this.numbers = numbers;
    this.urls = urls;
  }


  @Override
  public String browse() {
    StringBuilder browseResult = new StringBuilder();
    for (String url : urls) {
      if (isValidUrl(url)) {
        browseResult.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
      } else {
        browseResult.append("Invalid URL!").append(System.lineSeparator());
      }
    }
    return browseResult.toString();
  }

  private boolean isValidUrl(String url) {
    for (int i = 0; i < url.length(); i++) {
      if (Character.isDigit(url.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String call() {
    StringBuilder callResult = new StringBuilder();
    for (String number : numbers) {
      if (isValidNumber(number)) {
        callResult.append("Calling... ").append(number).append(System.lineSeparator());
      } else {
        callResult.append("Invalid number!").append(System.lineSeparator());
      }
    }
    return callResult.toString();
  }

  private boolean isValidNumber(String number) {
    for (int i = 0; i < number.length(); i++) {
      if (Character.isLetter(number.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}