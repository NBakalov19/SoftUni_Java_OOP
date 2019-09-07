package Avatar.entities.Benders;

import static Avatar.utilities.Constants.STRING_FORMAT_PARENT_BENDER;

public abstract class Bender {
    private String name;
    private int power;

    protected Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return this.name;
    }

    protected int getPower() {
        return this.power;
    }

    public abstract double getBenderTotalPower();

    @Override
    public String toString() {
        return STRING_FORMAT_PARENT_BENDER;
    }
}