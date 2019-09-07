package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.LinkedHashMap;
import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {

    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;
    private Map<String, Tank> tanks;
    private Map<String, Fighter> fighters;

    public MachinesManagerImpl(PilotFactory pilotFactory,
                               MachineFactory machineFactory,
                               Map<String, Pilot> pilots,
                               Map<String, Machine> machines) {

        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
        this.tanks = new LinkedHashMap<>();
        this.fighters = new LinkedHashMap<>();
    }


    @Override
    public String hirePilot(String name) throws IllegalArgumentException {
        Pilot pilot = this.pilotFactory.createPilot(name);
        String output;
        if (!this.pilots.containsKey(name)) {
            this.pilots.put(name, pilot);
            output = String.format(OutputMessages.pilotHired, name);
        } else {
            output = String.format(OutputMessages.pilotExists, name);
        }

        return output;
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) throws IllegalArgumentException {
        Tank tank = this.machineFactory.createTank(name, attackPoints, defensePoints);
        String output;

        if (!this.machines.containsKey(name)) {
            this.machines.put(name, tank);
            this.tanks.put(name, tank);
            output = String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
        } else {
            output = String.format(OutputMessages.machineExists, name);
        }

        return output;
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) throws IllegalArgumentException {
        Fighter fighter = this.machineFactory.createFighter(name, attackPoints, defensePoints);
        String output;

        if (!this.machines.containsKey(name)) {
            this.machines.put(name, fighter);
            this.fighters.put(name, fighter);
            output = String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
        } else {
            output = String.format(OutputMessages.machineExists, name);
        }

        return output;
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        String output = "";

        if (this.pilots.containsKey(selectedPilotName) && this.machines.containsKey(selectedMachineName)) {
            Pilot pilot = this.pilots.get(selectedPilotName);
            Machine machine = this.machines.get(selectedMachineName);

            if (machine.getPilot() != null) {
                output = String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
            } else {
                this.pilots.get(selectedPilotName).addMachine(machine);
                this.machines.get(selectedMachineName).setPilot(pilot);
                output = String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
            }
        } else if (!this.pilots.containsKey(selectedPilotName)) {
            output = String.format(OutputMessages.pilotNotFound, selectedPilotName);
        } else if (!this.machines.containsKey(selectedMachineName)) {
            output = String.format(OutputMessages.machineNotFound, selectedMachineName);
        }

        return output;
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        String output;

        if (!this.machines.containsKey(attackingMachineName)) {
            output = String.format(OutputMessages.machineNotFound, attackingMachineName);
        } else if (!this.machines.containsKey(defendingMachineName)) {
            output = String.format(OutputMessages.machineNotFound, defendingMachineName);
        } else {
            Machine attacker = this.machines.get(attackingMachineName);
            Machine defender = this.machines.get(defendingMachineName);

            attacker.attack(defender.getName());

            if (attacker.getAttackPoints() > defender.getDefensePoints()) {
                double damageTaken = defender.getHealthPoints() - attacker.getAttackPoints();
                if (damageTaken <= 0) {
                    defender.setHealthPoints(0);
                } else {
                    defender.setHealthPoints(defender.getHealthPoints() - damageTaken);
                }
            }
            output = String.format(OutputMessages.attackSuccessful,
                    defender.getName(),
                    attacker.getName(),
                    defender.getHealthPoints());
        }
        return output;
    }

    @Override
    public String pilotReport(String pilotName) {
        if (this.pilots.containsKey(pilotName)) {
            return this.pilots.get(pilotName).report();
        } else {
            return String.format(OutputMessages.pilotNotFound, pilotName);
        }
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        String output;

        if (this.machines.containsKey(fighterName)) {
            if (this.fighters.containsKey(fighterName)) {
                this.fighters.get(fighterName).toggleAggressiveMode();
                output = String.format(OutputMessages.fighterOperationSuccessful, fighterName);
            } else {
                output = String.format(OutputMessages.notSupportedOperation, fighterName);
            }
        } else {
            output = String.format(OutputMessages.machineNotFound, fighterName);
        }
        return output;
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        String output;

        if (this.machines.containsKey(tankName)) {
            if (this.tanks.containsKey(tankName)) {
                this.tanks.get(tankName).toggleDefenseMode();
                output = String.format(OutputMessages.tankOperationSuccessful, tankName);
            } else {
                output = String.format(OutputMessages.notSupportedOperation, tankName);
            }
        } else {
            output = String.format(OutputMessages.machineNotFound, tankName);
        }
        return output;
    }
}