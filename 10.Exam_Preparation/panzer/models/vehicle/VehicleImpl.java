package panzer.models.vehicle;

import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class VehicleImpl implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defence;
    private int hitPoints;
    private VehicleAssembler assembler;
    private List<Part> parts;

    protected VehicleImpl(String model, double weight, BigDecimal price, int attack, int defence, int hitPoints) {
        this.model = model;
        this.setWeight(weight);
        this.setPrice(price);
        this.setAttack(attack);
        this.setDefence(defence);
        this.setHitPoints(hitPoints);
        this.assembler = new VehicleAssembler();
        this.parts = new LinkedList<>();
    }

    @Override
    public String getModel() {
        return this.model;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    protected void setDefence(int defence) {
        this.defence = defence;
    }

    protected void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public double getTotalWeight() {
        return this.assembler.getTotalWeight() + this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.assembler.getTotalPrice().add(this.price);
    }

    @Override
    public long getTotalAttack() {
        return this.assembler.getTotalAttackModification() + this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.assembler.getTotalDefenseModification() + this.defence;
    }

    @Override
    public long getTotalHitPoints() {
        return this.assembler.getTotalHitPointModification() + this.hitPoints;
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
        this.parts.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
        this.parts.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
        this.parts.add(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.parts;
    }


    @Override
    public String toString() {
        String separator = System.lineSeparator();
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append(" - ").append(this.getModel()).append(separator);
        sb.append(String.format("Total Weight: %.3f", this.getTotalWeight())).append(separator);
        sb.append(String.format("Total Price: %.3f", this.getTotalPrice())).append(separator);
        sb.append("Attack: ").append(this.getTotalAttack()).append(separator);
        sb.append("Defense: ").append(this.getTotalDefense()).append(separator);
        sb.append("HitPoints: ").append(this.getTotalHitPoints()).append(separator);

        if (this.parts.isEmpty()) {
            sb.append("Parts: None");
        } else {
            List<String> joined = new ArrayList<>();
            for (Part part : this.parts) {
                joined.add(part.getModel());
            }
            sb.append("Parts: ").append(String.join(", ", joined));
        }

        return sb.toString().trim();
    }
}