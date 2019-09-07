package Avatar.factories;

import Avatar.entities.Benders.*;

import static Avatar.utilities.Constants.*;

public final class BendersFactory {

    private BendersFactory() {
    }

    public static Bender makeBender(String benderType, String benderName, int power, double specialPower) {
        Bender bender = null;
        switch (benderType) {
            case AIR:
                bender = new AirBender(benderName, power, specialPower);
                break;
            case EARTH:
                bender = new EarthBender(benderName, power, specialPower);
                break;
            case FIRE:
                bender = new FireBender(benderName, power, specialPower);
                break;
            case WATER:
                bender = new WaterBender(benderName, power, specialPower);
                break;
        }
        return bender;
    }
}