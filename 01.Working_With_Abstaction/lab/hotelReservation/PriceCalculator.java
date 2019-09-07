package lab.hotelReservation;

public class PriceCalculator {
  private double pricePerDay;
  private int numberOfDays;
  private Season season;
  private Discount discount;

  public static double calculate(double pricePerDay, int numberOfDays, Season season, Discount discount) {
    int multiplier = season.getValue();
    double discountMultiplier = discount.getValue() / 100.0;

    double priceBeforeDiscount = pricePerDay * numberOfDays * multiplier;
    double discountedAmount = priceBeforeDiscount * discountMultiplier;

    return priceBeforeDiscount - discountedAmount;
  }
}
