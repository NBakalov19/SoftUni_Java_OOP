package Avatar.factories;

import Avatar.entities.Monumets.*;

import static Avatar.utilities.Constants.*;

public final class MonumentsFactory {
    private MonumentsFactory() {
    }

    public static Monument makeMonument(String monumentType, String monumentName, int affinity) {
        Monument monument = null;

        switch (monumentType) {
            case AIR:
                monument = new AirMonument(monumentName, affinity);
                break;
            case EARTH:
                monument = new EarthMonument(monumentName, affinity);
                break;
            case FIRE:
                monument = new FireMonument(monumentName, affinity);
                break;
            case WATER:
                monument = new WaterMonument(monumentName, affinity);
                break;
        }
        return monument;
    }
}
