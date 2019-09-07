package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings extends ArrayList<String> {

  private ArrayList<String> data;

  public StackOfStrings() {
    this.data = new ArrayList<>();
  }

  public void push(String item) {
    this.data.add(item);
  }

  public String pop() {
    String element = this.data.get(this.data.size() - 1);
    this.data.remove(element);
    return element;
  }

  public String peek() {
    return this.data.get(this.data.size() - 1);
  }

  public boolean isEmpty() {
    return this.data.size() == 0;
  }
}