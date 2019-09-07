package cresla.entities.Modules;

import cresla.interfaces.EnergyModule;

public abstract class EnergyModuleIml extends ModuleImpl implements EnergyModule {
    private int energyOutput;

    protected EnergyModuleIml(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        return String.format(
                "%s Module - %d%nEnergy Output: %d",
                this.getClass().getSimpleName(), super.getId(),
                this.getEnergyOutput());
    }
}