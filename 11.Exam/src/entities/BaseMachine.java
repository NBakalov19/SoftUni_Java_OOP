package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMachine implements Machine {

    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;


    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.setAttackPoints(attackPoints);
        this.setDefensePoints(defensePoints);
        this.setHealthPoints(healthPoints);
        this.targets = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return this.targets;
    }

    @Override
    public void attack(String target) {
        if (target == null || target.isEmpty()) {
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }
        this.targets.add(target);
    }

    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    protected void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public String toString() {
        String separator = System.lineSeparator();
        StringBuilder sb = new StringBuilder(String.format("- %s", getName())).append(separator);
        String type;
        if (getClass().getSimpleName().equalsIgnoreCase("TankImpl")){
            type = "Tank";
        } else {
            type = "Fighter";
        }
        sb.append(" *Type: ").append(type).append(separator);
        sb.append(String.format(" *Health: %.2f",getHealthPoints())).append(separator);
        sb.append(String.format(" *Attack: %.2f",getAttackPoints())).append(separator);
        sb.append(String.format(" *Defense: %.2f",getDefensePoints())).append(separator);
        if (this.getTargets().size() == 0) {
            sb.append(" *Targets: None").append(separator);
        } else {
            sb.append(" *Targets: ").append(String.join(", ", this.getTargets())).append(separator);
        }
        return sb.toString();
    }
}
