package cresla.core;

import cresla.entities.Modules.CooldownSystem;
import cresla.entities.Modules.CryogenRod;
import cresla.entities.Modules.HeatProcessor;
import cresla.entities.Reactors.CryoReactor;
import cresla.entities.Reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private static int id;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public ManagerImpl() {
        ManagerImpl.id = 1;
        this.reactors = new HashMap<>();
        this.modules = new HashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {

        String type = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int containerModuleCapacity = Integer.parseInt(arguments.get(2));

        Reactor reactor;

        if (type.equalsIgnoreCase("Cryo")) {
            reactor = new CryoReactor(ManagerImpl.id, containerModuleCapacity, additionalParameter);
        } else {
            reactor = new HeatReactor(ManagerImpl.id, containerModuleCapacity, additionalParameter);
        }

        this.reactors.putIfAbsent(id, reactor);
        this.increaseId();
        return String.format("Created %s Reactor – %d", type, this.getPreviousId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));

        Module module = null;

        switch (type) {
            case "CryogenRod":
                module = new CryogenRod(id, additionalParameter);
                break;
            case "HeatProcessor":
                module = new HeatProcessor(id, additionalParameter);
                break;
            case "CooldownSystem":
                module = new CooldownSystem(id, additionalParameter);
                break;
        }

        if (type.equals("CryogenRod")) {
            this.reactors.get(reactorId).addEnergyModule((EnergyModule) module);
        } else {
            this.reactors.get(reactorId).addAbsorbingModule((AbsorbingModule) module);
        }
        this.modules.putIfAbsent(id, module);
        this.increaseId();
        return String.format("Added %s - %d to Reactor - %d", type, this.getPreviousId(), reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int idForCheck = Integer.parseInt(arguments.get(0));
        String result;

        if (this.isReactorId(idForCheck)) {
            result = this.reactors.get(idForCheck).toString();
        } else {
            result = this.reactors.get(idForCheck).toString();
        }

        return result;
    }

    @Override
    public String exitCommand(List<String> arguments) {

        int cryoReactorsCount = 0;
        int heatReactorsCount = 0;

        for (Reactor reactor : this.reactors.values()) {
            if (reactor.getClass().getSimpleName().equals("HeatReactor")) {
                heatReactorsCount++;
            } else {
                cryoReactorsCount++;
            }
        }

        int energyModulesCount = 0;
        int absorbingModulesCount = 0;

        for (Module module : modules.values()) {
            if (module.getClass().getSimpleName().equals("CryogenRod")) {
                energyModulesCount++;
            } else {
                absorbingModulesCount++;
            }
        }

        long totalEnergyOutput = this.reactors.values()
                .stream()
                .mapToLong(Reactor::getTotalEnergyOutput)
                .sum();

        long totalHeatAbsorbing = this.reactors.values()
                .stream()
                .mapToLong(Reactor::getTotalHeatAbsorbing)
                .sum();

        return String.format("Cryo Reactors: %d%n" +
                        "Heat Reactors: %d%n" +
                        "Energy Modules: %d%n" +
                        "Absorbing Modules: %d%n" +
                        "Total Energy Output: %d%n" +
                        "Total Heat Absorbing: %d",
                cryoReactorsCount,
                heatReactorsCount,
                energyModulesCount,
                absorbingModulesCount,
                totalEnergyOutput,
                totalHeatAbsorbing
        ).trim();
    }

    private void increaseId() {
        ManagerImpl.id++;
    }

    private int getPreviousId() {
        return ManagerImpl.id - 1;
    }

    private boolean isReactorId(int idForCheck) {
        boolean containId = false;

        for (Integer key : this.reactors.keySet()) {
            if (key == idForCheck) {
                containId = true;
                break;
            }
        }
        return containId;
    }
}