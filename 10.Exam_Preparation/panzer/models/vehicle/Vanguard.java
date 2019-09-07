package panzer.models.vehicle;

import java.math.BigDecimal;

public class Vanguard extends VehicleImpl {
    public Vanguard(String model, double weight, BigDecimal price, int attack, int defence, int hitPoints) {
        super(model, weight, price, attack, defence, hitPoints);
    }

    @Override
    protected void setWeight(double weight) {
        super.setWeight(weight * 2);
    }

    @Override
    protected void setAttack(int attack) {
        super.setAttack(attack - (attack / 4));
    }

    @Override
    protected void setDefence(int defence) {
        super.setDefence(defence + ((defence * 2) / 4));
    }

    @Override
    protected void setHitPoints(int hitPoints) {
        super.setHitPoints(hitPoints + ((hitPoints * 3) / 4));
    }
}