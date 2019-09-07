package panzer.models.Parts;

import java.math.BigDecimal;

import panzer.contracts.AttackModifyingPart;

public class ArsenalPart extends PartImpl implements AttackModifyingPart {
    private int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }

    @Override
    public String toString() {
        return String.format("%s%d Attack Modifier",super.toString(),this.getAttackModifier());
    }
}