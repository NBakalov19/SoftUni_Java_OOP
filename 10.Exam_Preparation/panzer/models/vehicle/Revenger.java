package panzer.models.vehicle;

import java.math.BigDecimal;

public class Revenger extends VehicleImpl {
    public Revenger(String model, double weight, BigDecimal price, int attack, int defence, int hitPoints) {
        super(model, weight, price, attack, defence, hitPoints);
    }

    @Override
    protected void setPrice(BigDecimal price) {
        super.setPrice(price.multiply(BigDecimal.valueOf(1.5)));
    }

    @Override
    protected void setAttack(int attack) {
        super.setAttack(attack + ((attack * 6) / 4));
    }

    @Override
    protected void setDefence(int defence) {
        super.setDefence(defence - ((defence * 2) / 4));
    }

    @Override
    protected void setHitPoints(int hitPoints) {
        super.setHitPoints(hitPoints - ((hitPoints * 2) / 4));
    }
}