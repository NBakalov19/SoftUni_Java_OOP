package Avatar.entities.Benders;

import static Avatar.utilities.Constants.FIRE;

public class FireBender extends Bender {

    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    public double getHeatAggression() {
        return this.heatAggression;
    }

    @Override
    public double getBenderTotalPower() {
        return this.getPower() * this.getHeatAggression();
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "Heat Aggression: %.2f",
                FIRE, super.getName(), super.getPower(), this.heatAggression);
    }
}