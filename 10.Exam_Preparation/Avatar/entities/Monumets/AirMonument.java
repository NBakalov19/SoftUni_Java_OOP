package Avatar.entities.Monumets;

import static Avatar.utilities.Constants.AIR;

public class AirMonument extends Monument {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    public int getAffinity() {
        return this.airAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), AIR, super.getName(), AIR, this.airAffinity);
    }
}