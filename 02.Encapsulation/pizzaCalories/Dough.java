package pizzaCalories;

public class Dough {
  private double weight;
  private String flourType;
  private String bakingTechnique;

  public Dough(String flourType, String bakingTechnique, double weight) {
    this.setFlourType(flourType);
    this.setBakingTechnique(bakingTechnique);
    this.setWeight(weight);
  }

  private void setWeight(double weight) {
    if (weight < 1 || weight > 200) {
      throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
    }
    this.weight = weight;
  }

  private void setFlourType(String flourType) {
    if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
      throw new IllegalArgumentException("Invalid type of dough.");
    }
    this.flourType = flourType;
  }

  private void setBakingTechnique(String bakingTechnique) {
    if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy")
            && !bakingTechnique.equals("Homemade")) {
      throw new IllegalArgumentException("Invalid type of dough.");
    }
    this.bakingTechnique = bakingTechnique;
  }

  public double getWeight() {
    return this.weight;
  }

  public String getFlourType() {
    return this.flourType;
  }

  public String getBakingTechnique() {
    return this.bakingTechnique;
  }

  public double calculateCalories() {
    return (2 * getWeight()) * getModifier(getFlourType()) * getModifier(getBakingTechnique());
  }

  private double getModifier(String modifier) {
    double result = 0d;
    switch (modifier) {
      case "White":
        result = 1.5;
        break;
      case "Crispy":
        result = 0.9;
        break;
      case "Chewy":
        result = 1.1;
        break;
      default:
        result = 1.0;
        break;
    }
    return result;
  }
}