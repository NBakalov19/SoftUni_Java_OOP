package cresla.entities.Modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbsorbingModuleImpl extends ModuleImpl implements AbsorbingModule {
    private int heatAbsorbing;

    protected AbsorbingModuleImpl(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        return String.format(
                "%s Module - %d%nHeat Absorbing: %d",
                this.getClass().getSimpleName(), super.getId(),
                this.getHeatAbsorbing());
    }
}