package panzer.models.Parts;

import java.math.BigDecimal;

import panzer.contracts.HitPointsModifyingPart;

public class EndurancePart extends PartImpl implements HitPointsModifyingPart {
    private int hitPointsModifier;

    public EndurancePart(String model, double weight, BigDecimal price, int hitPointsModifier) {
        super(model, weight, price);
        this.hitPointsModifier = hitPointsModifier;
    }

    @Override
    public int getHitPointsModifier() {
        return this.hitPointsModifier;
    }

    @Override
    public String toString() {
        return String.format("%s%d Hit Points Modifier",super.toString(),this.getHitPointsModifier());
    }
}
