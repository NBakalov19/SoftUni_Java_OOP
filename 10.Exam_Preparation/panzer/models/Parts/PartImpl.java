package panzer.models.Parts;

import panzer.contracts.Part;

import java.math.BigDecimal;

public abstract class PartImpl implements Part {
    private String model;
    private double weight;
    private BigDecimal price;

    protected PartImpl(String model, double weight, BigDecimal price) {
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());

        sb.append(" - ").append(this.getModel()).append(System.lineSeparator());
        sb.append("+");
        return sb.toString();
    }
}
