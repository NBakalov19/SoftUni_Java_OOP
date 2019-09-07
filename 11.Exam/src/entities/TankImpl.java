package entities;

import entities.interfaces.Pilot;
import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double DEFAULT_HEALTH_POINTS = 100.0;
    private boolean defenseMode;
    private double attackPointsModifier;
    private double deffencePointsModifier;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS);
        this.toggleDefenseMode();
        this.attackPointsModifier = 40.0;
        this.deffencePointsModifier = 30.0;
    }

    public void setDefenseMode(boolean defenseMode) {
        this.defenseMode = defenseMode;
    }

    @Override
    public void setPilot(Pilot pilot) throws NullPointerException {
        if (pilot == null) {
            throw new NullPointerException("Pilot cannot be null.");
        }
        super.setPilot(pilot);
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode()) {
            this.setDefenseMode(false);
            super.setAttackPoints(super.getAttackPoints() + 40);
            super.setDefensePoints(super.getDefensePoints() - 30);
        } else {
            this.setDefenseMode(true);
            super.setAttackPoints(super.getAttackPoints() - 40);
            super.setDefensePoints(super.getDefensePoints() + 30);
        }
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        super.setHealthPoints(healthPoints);
    }

    @Override
    public String toString() {
        return (super.toString() + String.format(" *Defense Mode%s", this.checkMode())).trim();
    }

    private String checkMode() {
        String result;
        if (this.getDefenseMode()) {
            result = "(ON)";
        } else {
            result = "(OFF)";
        }
        return result;
    }
}