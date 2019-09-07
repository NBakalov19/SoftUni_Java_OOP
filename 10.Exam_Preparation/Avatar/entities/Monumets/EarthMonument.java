package Avatar.entities.Monumets;

import static Avatar.utilities.Constants.EARTH;

public class EarthMonument extends Monument {
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    public int getAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), EARTH, super.getName(), EARTH, this.earthAffinity);
    }
}