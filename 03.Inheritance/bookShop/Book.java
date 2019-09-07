package bookShop;

public class Book {
  private String title;
  private String author;
  private double price;

  public Book(String author, String title, double price) {
    this.setAuthor(author);
    this.setTitle(title);
    this.setPrice(price);
  }

  public void setTitle(String title) {
    if (title.length() < 3) {
      throw new IllegalArgumentException("Title not valid!");
    }
    this.title = title;
  }

  public void setAuthor(String author) {
    for (int i = 0; i < author.length(); i++) {
      char symbol = author.charAt(i);
      if (Character.isDigit(symbol)) {
        throw new IllegalArgumentException("Author not valid!");
      }
    }
    this.author = author;
  }

  public void setPrice(double price) {
    if (price < 1) {
      throw new IllegalArgumentException("Price not valid!");
    }
    this.price = price;
  }

  public String getTitle() {
    return this.title;
  }

  public String getAuthor() {
    return this.author;
  }

  public double getPrice() {
    return this.price;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Type: ").append(this.getClass().getSimpleName())
            .append(System.lineSeparator())
            .append("Title: ").append(this.getTitle())
            .append(System.lineSeparator())
            .append("Author: ").append(this.getAuthor())
            .append(System.lineSeparator())
            .append("Price: ").append(this.getPrice())
            .append(System.lineSeparator());
    return sb.toString();
  }
}
