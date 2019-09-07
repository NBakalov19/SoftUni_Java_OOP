package cresla.entities.Reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;


public abstract class ReactorImpl implements Reactor {
    private int id;
    private Container container;

    protected ReactorImpl(int id, int moduleCapacity) {
        this.id = id;
        this.container = new ModuleContainer(moduleCapacity);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return this.container.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public String toString() {
        String separator = System.lineSeparator();
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());

        sb.append(" - ").append(this.getId()).append(separator);
        sb.append("Energy Output: ").append(this.getTotalEnergyOutput()).append(separator);
        sb.append("Heat Absorbing: ").append(this.getTotalHeatAbsorbing()).append(separator);
        sb.append("Modules: ").append(this.getModuleCount());

        return sb.toString().trim();
    }
}