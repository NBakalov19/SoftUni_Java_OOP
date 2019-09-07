package Avatar.entities.Benders;

import static Avatar.utilities.Constants.EARTH;

public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    public double getGroundSaturation() {
        return this.groundSaturation;
    }

    @Override
    public double getBenderTotalPower() {
        return this.getPower() * this.getGroundSaturation();
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "Ground Saturation: %.2f",
                EARTH, super.getName(), super.getPower(), this.groundSaturation);
    }
}