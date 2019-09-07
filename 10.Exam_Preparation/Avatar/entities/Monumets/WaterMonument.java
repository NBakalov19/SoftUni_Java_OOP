package Avatar.entities.Monumets;

import static Avatar.utilities.Constants.WATER;

public class WaterMonument extends Monument {
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    public int getAffinity() {
        return waterAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), WATER, super.getName(), WATER, this.waterAffinity);
    }
}