package panzer.models.Parts;

import java.math.BigDecimal;

import panzer.contracts.DefenseModifyingPart;

public class ShellPart extends PartImpl implements DefenseModifyingPart {
    private int defenseModifier;

    public ShellPart(String model, double weight, BigDecimal price, int defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    @Override
    public int getDefenseModifier() {
        return this.defenseModifier;
    }

    @Override
    public String toString() {
        return String.format("%s%d Defense Modifier",super.toString(),this.getDefenseModifier());
    }
}