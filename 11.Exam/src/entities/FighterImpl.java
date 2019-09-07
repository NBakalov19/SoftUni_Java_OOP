package entities;

import entities.interfaces.Fighter;
import entities.interfaces.Pilot;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double DEFAULT_HEALTH_POINTS = 200;


    private boolean aggressiveMode;
    private double attackPointsModifier;
    private double deffencePointsModifier;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS);
        this.toggleAggressiveMode();
        this.attackPointsModifier = 50.0;
        this.deffencePointsModifier = 25.0;
    }


    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    private void setAggressiveMode(boolean aggressiveMode) {
        this.aggressiveMode = aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.getAggressiveMode()) {
            this.setAggressiveMode(false);
            super.setAttackPoints(super.getAttackPoints() - 50);
            super.setDefensePoints(super.getDefensePoints() + 25);
        } else {
            this.setAggressiveMode(true);
            super.setAttackPoints(super.getAttackPoints() + 50);
            super.setDefensePoints(super.getDefensePoints() - 25);
        }
    }

    @Override
    public void setPilot(Pilot pilot) throws NullPointerException {
        if (pilot == null) {
            throw new NullPointerException("Pilot cannot be null.");
        }
        super.setPilot(pilot);
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        super.setHealthPoints(healthPoints);
    }

    @Override
    public String toString() {
        return (super.toString() + String.format(" *Aggressive Mode%s", this.checkMode())).trim();
    }

    private String checkMode() {
        String result;
        if (this.getAggressiveMode()) {
            result = "(ON)";
        } else {
            result = "(OFF)";
        }
        return result;
    }

}