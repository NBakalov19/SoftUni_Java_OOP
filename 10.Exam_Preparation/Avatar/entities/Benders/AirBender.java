package Avatar.entities.Benders;

import static Avatar.utilities.Constants.AIR;

public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    public double getAerialIntegrity() {
        return this.aerialIntegrity;
    }

    public double getBenderTotalPower() {
        return this.getPower() * this.getAerialIntegrity();
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "Aerial Integrity: %.2f",
                AIR, super.getName(), super.getPower(), this.aerialIntegrity);
    }
}