package Avatar.entities.Monumets;

import static Avatar.utilities.Constants.FIRE;

public class FireMonument extends Monument {
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    public int getAffinity() {
        return this.fireAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), FIRE, super.getName(), FIRE, this.fireAffinity);
    }
}