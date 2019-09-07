package Avatar.entities.Benders;

import static Avatar.utilities.Constants.WATER;

public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    public double getWaterClarity() {
        return this.waterClarity;
    }

    @Override
    public double getBenderTotalPower() {
        return this.getPower() * this.getWaterClarity();
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "Water Clarity: %.2f",
                WATER, super.getName(), super.getPower(), this.waterClarity);
    }
}