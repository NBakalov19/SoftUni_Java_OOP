package carShop;

public class Main {
  public static void main(String[] args) {
    Seat seat = new Seat("Leon",
            "Gray",
            110,
            "Spain",
            11111.1);
    Audi audi = new Audi("A4",
            "Gray",
            110,
            "Germany",
            3,
            99.9);

    System.out.println(seat.toString());
    System.out.println(audi.toString());
  }
}