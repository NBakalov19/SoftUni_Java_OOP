package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Pilot name cannot be null or empty string.");
        }
        this.name = name;
    }

    @Override
    public void addMachine(Machine machine) throws NullPointerException {
        if (machine == null) {
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }
        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        String separator = System.lineSeparator();
        sb.append(String.format("%s - %d machines",getName(),this.machines.size())).append(separator);
        if (!this.machines.isEmpty()){
            for (Machine machine : this.machines) {
                sb.append(machine.toString()).append(separator);
            }
        }
        return sb.toString().trim();
    }
}
